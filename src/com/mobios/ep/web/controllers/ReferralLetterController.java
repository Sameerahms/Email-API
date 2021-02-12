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

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.MedicalCertificateService;
import com.mobios.ep.services.ReferralLetterService;
import com.mobios.ep.web.models.MedicalCertificateWM;
import com.mobios.ep.web.models.ReferralLetterWM;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.ombios.ep.entity.model.MedicalCertificate;
import com.ombios.ep.entity.model.ReferralLetter;

@Controller
public class ReferralLetterController {

	@CrossOrigin(origins = "*")
	@RequestMapping(value="referrel/letter/save", method = RequestMethod.POST)
	public @ResponseBody int saveReferralLetter(HttpServletRequest request, @RequestBody ReferralLetterWM referralLetterWM) throws Exception {
		
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
		Log4JUtil.logger.info("REFERREL_LETTER,referral_letter_save,Request="+referralLetterWM.toString());
		ReferralLetter referralLetter = new ReferralLetter();
		ReferralLetterService referralLetterService= new ReferralLetterService();
		Mapper mapper= new Mapper();
		referralLetter = mapper.mapReferralLetter(referralLetterWM);
		try{
			id = referralLetterService.saveReferralLetter(referralLetter);
		}catch(Exception exp){
			Log4JUtil.logger.info("REFERREL_LETTER,referral_letter_save,Request="+referralLetterWM.toString()+","+ exp.getMessage());
			throw new EPException();			
		}		
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="referrel/letter/list", method = RequestMethod.POST)
	public @ResponseBody List<ReferralLetterWM> getReferralLetter(HttpServletRequest request, @RequestBody int patientId) throws Exception {
		
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
		Log4JUtil.logger.info("REFERREL_LETTER,referral_letter_list,Request="+patientId);
		List<ReferralLetter> referralLetters = new ArrayList<ReferralLetter>();
		List<ReferralLetterWM> referralLetterWMs=new ArrayList<>();
		ReferralLetterService referralLetterService= new ReferralLetterService();
		Mapper mapper= new Mapper();
		
		try{
			referralLetters = referralLetterService.getReferralLetter(patientId);
			for (ReferralLetter referralLetter : referralLetters) {
				referralLetterWMs.add(mapper.mapReferralLetter(referralLetter));
			}
		}catch(Exception exp){
			Log4JUtil.logger.info("REFERREL_LETTER,referral_letter_list,Request="+patientId+","+ exp.getMessage());
			throw new EPException();			
		}		
		
		return referralLetterWMs;
	}
	
}
