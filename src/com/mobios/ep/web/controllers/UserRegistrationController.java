package com.mobios.ep.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.UserRegistrationService;
import com.mobios.ep.web.models.RegistrationReferenceResponse;
import com.mobios.ep.web.models.RegistrationReq;
import com.mobios.ep.web.models.RegistrationResponse;
import com.mobios.ep.web.models.SubmitOtpReq;
import com.mobios.ep.web.models.SubmitOtpResponse;
import com.mobios.ep.web.models.UserProfileResponseWM;
import com.mobios.ep.web.models.UserProfileWM;
import com.mobios.ep.web.util.Mapper;
import com.ombios.ep.entity.model.RegistrationEM;
import com.ombios.ep.entity.model.RegistrationResponseEM;
import com.ombios.ep.entity.model.UserInfo;
import com.ombios.ep.entity.model.UserProfileEM;
import com.ombios.ep.entity.model.UserProfileResponse;

/**
 * 
 * Registration from mobile application
 * 
 * @author hasithakaushan
 *
 */
@RestController
public class UserRegistrationController {
	
	/**
	 * 
	 * Registration
	 * 
	 * @param {"mobile":"0715656765", "nic":"654543432v", "name":"samila", "email":"samila@gmail.lk", "imei":"345654323465764", "timestamp":"2017-05-22 10:12:23" }
	 * @return {"referenceId":"334422323"}
	 * @throws Exception 
	 */
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	public RegistrationResponse registerUser(HttpServletRequest request, @RequestBody RegistrationReq registrationReq) throws Exception{
		
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
		
		RegistrationResponse registrationResponse = new RegistrationResponse();
		registrationResponse.setReferenceId("334422323");
		
		return registrationResponse;		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/user/registration",method=RequestMethod.POST)
	public RegistrationReferenceResponse userRegister(HttpServletRequest request, @RequestBody RegistrationReq registrationReq) throws Exception{	
		
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
    	
		Mapper mapper= new Mapper();
		RegistrationResponseEM mappedRegistration= mapper.mapUserRegister(registrationReq);
		RegistrationResponseEM registrationResponseEM=null;
		UserRegistrationService urs = new UserRegistrationService();
		try{
			registrationResponseEM = urs.userRegister(mappedRegistration);
		}
		catch(Exception exp){
			Log4JUtil.logger.info("REGISTRATION,user_register_request,Request="+registrationReq.toString()+","+ exp.getMessage());
		}		

		RegistrationReferenceResponse response= new RegistrationReferenceResponse();
		response.setReferenceId(registrationResponseEM.getReferenceId());
		
		return response;
	}
	
	/**
	 * 
	 * Sends generated username , password etc..
	 * @param {"refernceId":"334422323", "otp":"12345", "imei":"345654323465764", "timestamp":"2017-05-22 10:12:25" } 
	 * @return {"userName" : "0715656765" "password" : "334434" }
	 * @throws Exception 
	 */
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/user/getOtp", method=RequestMethod.POST)
	public SubmitOtpResponse getOtp (HttpServletRequest request, @RequestBody SubmitOtpReq submitOtpReq) throws Exception{
		
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
		
		SubmitOtpResponse submitOtpResponse = new SubmitOtpResponse();
		submitOtpResponse.setPassword("334434");
		submitOtpResponse.setUserName("0702576096");
		
		return submitOtpResponse;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/user/getOtpCode", method=RequestMethod.POST)
	public RegistrationReferenceResponse getOtpCode(HttpServletRequest request, @RequestBody SubmitOtpReq submitOtpReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("REGISTRATION,user_register_getOTP_request,Request="+submitOtpReq.toString());
		RegistrationReferenceResponse registrationReferenceResponse = new RegistrationReferenceResponse();
		UserRegistrationService userRegistrationService = new UserRegistrationService();
		RegistrationResponseEM rrEM=null;	
		Mapper mapper= new Mapper();
		RegistrationResponseEM mappedRegistrationResponse= mapper.mapGetOtp(submitOtpReq);		
		try{
			rrEM = userRegistrationService.getOtpCode(mappedRegistrationResponse);
		}catch(Exception exp){
			Log4JUtil.logger.info("REGISTRATION,user_getOtp_request,Request="+submitOtpReq.toString()+","+ exp.getMessage());
		}
		registrationReferenceResponse.setReferenceId(rrEM.getReferenceId());
		
		return registrationReferenceResponse;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/user/submitUserProfile", method=RequestMethod.POST)
	public UserProfileResponse submitUserProfile(HttpServletRequest request, @RequestBody UserProfileWM userProfileWM) throws Exception{
		
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
    	
		Log4JUtil.logger.info("REGISTRATION,user_register_submitUserProfile,Request="+userProfileWM.toString());
		UserProfileResponse  userProfileResponse= new UserProfileResponse();
		UserRegistrationService userRegistrationService = new UserRegistrationService();
		Mapper mapper= new Mapper();
		UserProfileEM userProfileEM = null;
		UserProfileEM  mappedUserProfileEM = mapper.mapUserProfile(userProfileWM);
		try{
			userProfileResponse = userRegistrationService.submitUserProfile(mappedUserProfileEM);
		}catch(Exception exp ){
			
		}		
		
		return userProfileResponse;
	}
	
	

}
