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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.EPExceptionCodes;
import com.mobios.ep.web.util.NoTestFoundException;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.services.MedicalTestsService;
import com.mobios.ep.web.models.DrugWM;
import com.mobios.ep.web.models.MedicalTestsWM;
import com.mobios.ep.web.util.Mapper;
import com.ombios.ep.entity.model.MedicalTests;

/**
 * Controller for providing Medical Tests informations
 * 
 * @author Nishantha
 *
 */
@RestController
public class MedicalTestsController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "tests/sync", method= RequestMethod.POST)
	public List<MedicalTestsWM> medicalTestSync(HttpServletRequest request, @RequestBody MedicalTestsWM medicalTestsWM) throws  Exception{
		
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
				
		List<MedicalTestsWM> testsWMs = new ArrayList<MedicalTestsWM>();
		List<MedicalTests> list =new ArrayList<MedicalTests>();
		MedicalTestsService medicalTestsService = new MedicalTestsService();
		Mapper mapper = new Mapper();		
		list= medicalTestsService.getMedicalTests(medicalTestsWM.getLastUpdatedTime());
		if(list.size()==0) throw new NoTestFoundException();
		
		try {
			testsWMs = mapper.mapMedicalTests(list);
		} catch (Exception e) {
			throw new EPException();
		} 
		
		return testsWMs;
	}

}
