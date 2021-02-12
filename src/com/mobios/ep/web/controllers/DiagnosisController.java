/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.DiagnosisService;
import com.mobios.ep.web.models.DiagnosisWM;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoDiagnosisFoundException;

/**
 * Controller for functionality of getting diagnosis list
 * @author Nishantha
 *
 */
@RestController
public class DiagnosisController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="diagnosis/list",method=RequestMethod.POST)
	public @ResponseBody List<String> getDiagnosisList(HttpServletRequest request, @RequestBody DiagnosisWM diagnosisWM) throws Exception{
		
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
    	
		List<String> diagnosisList= new ArrayList<String>();
		Log4JUtil.logger.info("DIAGNOSIS,diagnosis_get_list_request,Request="+diagnosisWM.toString());
		Mapper mapper = new Mapper();
		DiagnosisService diagnosisService= new DiagnosisService();
		try{
			diagnosisList = diagnosisService.getDiagnosisList(diagnosisWM.getDoctorId(), diagnosisWM.getSpeciality());
		}catch(Exception exp){
			Log4JUtil.logger.info("DIAGNOSIS,diagnosis_get_list_request,Request="+diagnosisWM.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(diagnosisList.size()==0) throw new NoDiagnosisFoundException();
		
		return diagnosisList;
	}

}
