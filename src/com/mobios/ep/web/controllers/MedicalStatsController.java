package com.mobios.ep.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.services.MedicalStatsService;
import com.mobios.ep.web.models.MedicalStatWM;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.MedicalStatNotFoundException;
import com.ombios.ep.entity.model.MedicalStat;

/**
 * 
 * Controller for functionalities such as save / update / delete for patients' medical stats.
 * @author hasithakaushan
 *
 */
@RestController
public class MedicalStatsController {
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "medicalHistory/get", method = RequestMethod.POST)
	public MedicalStatWM getMedicalStat(HttpServletRequest request, @RequestBody MedicalStatWM medicalStatWM) throws Exception {
		
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
		
		MedicalStatWM medicalStat = new MedicalStatWM();
		MedicalStat stat = new MedicalStat();
		MedicalStatsService medicalStatsService = new MedicalStatsService();
		Mapper mapper = new Mapper();
		
		stat = medicalStatsService.getMedicalStatService(medicalStatWM.getPatientId());
		if(stat.getId() == 0)throw new MedicalStatNotFoundException();
		medicalStat = mapper.mapMedicalStat(stat);
		
		return medicalStat;
		
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "medicalHistory/save", method = RequestMethod.POST)
	public @ResponseBody int saveMedicalStat(HttpServletRequest request, @RequestBody MedicalStatWM medicalStatWM) throws Exception {
		
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
    	
		int id=0;
		MedicalStat medicalStat = new MedicalStat();
		MedicalStatsService medicalStatsService = new MedicalStatsService();
		Mapper mapper = new Mapper();
		
		medicalStat = mapper.mapmedicalStatToSave(medicalStatWM);
		id= medicalStatsService.saveMedicalStatService(medicalStat);
		
		return id;
	}

}
