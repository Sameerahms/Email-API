/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.MedicalCertificateHistoryService;
import com.mobios.ep.services.MedicalCertificateService;
import com.mobios.ep.web.models.MedicalCertificateWM;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.ombios.ep.entity.model.MedicalCertificate;

/**
 * @author Nishantha
 *
 */
@Controller
public class MedicalCertificateController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="medical/certificate/save", method = RequestMethod.POST)
	public @ResponseBody int saveMedicalCertificate(HttpServletRequest request, @RequestBody MedicalCertificateWM medicalCertificateWM) throws Exception {
		
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
		Log4JUtil.logger.info("MEDICAL_CERTIFICATE,medical_certificate_save,Request="+medicalCertificateWM.toString());
		MedicalCertificate medicalCertificate= new MedicalCertificate();
		MedicalCertificateService certificateService= new MedicalCertificateService();
		Mapper mapper= new Mapper();
		medicalCertificate = mapper.mapMedicalCertificate(medicalCertificateWM);
		try{
			id = certificateService.saveMedicalCertificate(medicalCertificate);
			
			medicalCertificate=certificateService.getMedicalCertificateById(id);
			medicalCertificateWM=mapper.mapMedicalCertificate(medicalCertificate);
			
			Gson gsn=new Gson();
			String json = gsn.toJson(medicalCertificateWM); 
			
			MedicalCertificateHistoryService medicalCertificateHistoryService=new MedicalCertificateHistoryService();
			medicalCertificateHistoryService.saveMedicalCertificateHistory(json, id, medicalCertificate.getDoctor().getId());
			
		}catch(Exception exp){
			Log4JUtil.logger.info("MEDICAL_CERTIFICATE,medical_certificate_save,Request="+medicalCertificateWM.toString()+","+ exp.getMessage());
			throw new EPException();			
		}		
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="medical/certificate/list", method = RequestMethod.POST)
	public @ResponseBody List<MedicalCertificateWM> getMedicalCertificate(HttpServletRequest request, @RequestBody int patientId) throws Exception {
		
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
		Log4JUtil.logger.info("MEDICAL_CERTIFICATE,medical_certificate_save,Request="+patientId);
		List<MedicalCertificate> medicalCertificates= new ArrayList<MedicalCertificate>();
		List<MedicalCertificateWM> medicalCertificateWMs= new ArrayList<MedicalCertificateWM>();
		MedicalCertificateService certificateService= new MedicalCertificateService();
		Mapper mapper= new Mapper();
		try{
			medicalCertificates = certificateService.getMedicalCertificate(patientId);
			for (MedicalCertificate medicalCertificate : medicalCertificates) {
				medicalCertificateWMs.add(mapper.mapMedicalCertificate(medicalCertificate));
			}
		}catch(Exception exp){
			Log4JUtil.logger.info("MEDICAL_CERTIFICATE,medical_certificate_list,Request="+patientId+","+ exp.getMessage());
			throw new EPException();			
		}		
		
		return medicalCertificateWMs;
	}

}
