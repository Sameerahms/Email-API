package com.mobios.ep.web.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.DiagnosticApiService;
import com.mobios.ep.services.LoginService;
import com.mobios.ep.web.models.DiagnosticSaveWM;
import com.mobios.ep.web.models.LoginReq;
import com.mobios.ep.web.models.RequestDiagnosticsWM;
import com.mobios.ep.web.models.UserWM;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.MapperDiagnosticApi;
import com.mobios.ep.web.util.UserNotFoundException;
import com.ombios.ep.entity.model.DiagnosticSaveEM;
import com.ombios.ep.entity.model.UserInfo;

@RestController
public class DiagnosticController {

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/diagnostic/save", method = RequestMethod.POST)
	public DiagnosticSaveEM saveDiagnostic(HttpServletRequest request, @RequestBody DiagnosticSaveWM diagnosticSaveWM) throws UserNotFoundException, JsonParseException, JsonMappingException, IOException, Exception{
		
    	String authKey = request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
		
		DiagnosticSaveEM diagnosticSaveEM = new DiagnosticSaveEM();
		try {
			Date currentDate = new Date();
			RequestDiagnosticsWM requestDiagnosticsWM = new RequestDiagnosticsWM();
			requestDiagnosticsWM.setCreatedDate(new java.sql.Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate()));
			diagnosticSaveWM.setRequestDiagnosticsWM(requestDiagnosticsWM);
			DiagnosticApiService diagnosticApiService = new DiagnosticApiService();
			MapperDiagnosticApi mapperDiagnosticApi = new MapperDiagnosticApi();
			
			diagnosticSaveEM = diagnosticApiService.saveDiagnostic(mapperDiagnosticApi.mapDiagnosticSave(diagnosticSaveWM));
			
		} catch (Exception e) {
			
			throw e;
			//Exception ex = e;
			//Log4JUtil.logger.info(loginReq.getClientId()+",LOGIN,login_error,Request="+loginReq.toString()+","+ e);
			//throw new UserNotFoundException();
		}
		
		return diagnosticSaveEM;
	}
	
}
