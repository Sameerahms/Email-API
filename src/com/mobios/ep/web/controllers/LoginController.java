package com.mobios.ep.web.controllers;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.LoginService;
import com.mobios.ep.web.models.ChangePasswordReq;
import com.mobios.ep.web.models.InstituteLoginReq;
import com.mobios.ep.web.models.LoginReq;
import com.mobios.ep.web.models.PasswordResetReq;
import com.mobios.ep.web.models.Patient;
import com.mobios.ep.web.models.PatientAuthReq;
import com.mobios.ep.web.models.PatientAuthResponse;
import com.mobios.ep.web.models.PatientLoginReq;
import com.mobios.ep.web.models.PatientReq;
import com.mobios.ep.web.models.RegistrationReferenceResponse;
import com.mobios.ep.web.models.StatusResp;
import com.mobios.ep.web.models.SubmitOtpReq;
import com.mobios.ep.web.models.UserWM;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.UserInfoNotFoundException;
import com.mobios.ep.web.util.UserNotFoundException;
import com.ombios.ep.entity.model.RegistrationResponseEM;
import com.ombios.ep.entity.model.User;
import com.ombios.ep.entity.model.UserInfo;
import com.ombios.ep.entity.model.UserProfileEM;

@RestController
public class LoginController {
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public UserWM authenticateUser(HttpServletRequest request, @RequestBody LoginReq loginReq) throws Exception{
		
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
		
		System.out.println("aaaaa");
		//Log4JUtil.logger.info(loginReq.getClientId()+",LOGIN,initial_login_request,Request="+loginReq.toString());
		System.out.println("info :"+loginReq.toString());
		LoginService loginService = new LoginService();
		System.out.println("assss");
		Mapper mapper = new Mapper();
		UserInfo userInfo = null;
		try {
			System.out.println("adasd");
			userInfo = loginService.getUser(loginReq.getUsername(), loginReq.getPassword(), loginReq.getClientId());
			System.out.println("hhh");
		} catch (Exception e) {
			//Log4JUtil.logger.info(loginReq.getClientId()+",LOGIN,login_error,Request="+loginReq.toString()+","+ e);
			throw new UserNotFoundException();
		}
		if ( userInfo == null ) throw new UserNotFoundException();
		UserWM infoWM = mapper.mapUserInfo(userInfo);
		return infoWM;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/login",method= RequestMethod.POST) 
	public RegistrationReferenceResponse authenticatePatient(HttpServletRequest request, @RequestBody PatientLoginReq patientLoginReq) throws Exception  {
		
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
    	
		Log4JUtil.logger.info("LOGIN,initial_login_request,Request="+patientLoginReq.toString());
		User user = new User(); 
		LoginService loginService = new LoginService();
		Mapper mapper = new Mapper();
		try{
			user = loginService.authenticatePatient(patientLoginReq.getMobile());
		}catch(Exception exp){
			Log4JUtil.logger.info("LOGIN,initial_login_request,Request="+patientLoginReq.toString()+exp.getMessage());
			throw new UserNotFoundException();
		}
		RegistrationReferenceResponse response= new RegistrationReferenceResponse();
		response.setReferenceId(user.getReferenceId());
			
		return response;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/getOtp",method=RequestMethod.POST) 
	public RegistrationReferenceResponse getOtp(HttpServletRequest request, @RequestBody SubmitOtpReq submitOtpReq) throws Exception {
		
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
    	
		Log4JUtil.logger.info("LOGIN,patient_login_otp_submit_request,Request="+submitOtpReq.toString());
		LoginService service = new LoginService();
		Mapper mapper =new Mapper();
		RegistrationResponseEM rrEM=null;	
		RegistrationResponseEM mappedRegistrationResponse= mapper.mapGetOtp(submitOtpReq);	
		try{
			rrEM = service.getOtpCode(mappedRegistrationResponse);
		}catch(Exception exp){
			Log4JUtil.logger.info("LOGIN,patient_login_otp_submit_request,Request="+submitOtpReq.toString()+exp.getMessage());
			throw new UserNotFoundException();
		}			
		RegistrationReferenceResponse response = new RegistrationReferenceResponse();
		response.setReferenceId(rrEM.getReferenceId());
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/getAuthStatus",method= RequestMethod.POST) 
	public PatientAuthResponse getAuthStatus(HttpServletRequest request, @RequestBody PatientAuthReq patientAuthReq) throws Exception{
		
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
    	
		PatientAuthResponse authResponse = new PatientAuthResponse();
		Log4JUtil.logger.info("LOGIN,patient_profile_submit_request,Request="+patientAuthReq.toString());
		LoginService service = new LoginService();
		Mapper mapper  = new Mapper();
		int authenStatus =0;		
		try{
			authenStatus = service.getAuthStatus(patientAuthReq.getNic(), patientAuthReq.getParentNIC(),patientAuthReq.getMobile());
		}catch(Exception exp){
			Log4JUtil.logger.info("LOGIN,patient_profile_submit_request,Request="+patientAuthReq.toString()+exp.getMessage());
			throw new UserNotFoundException();
		}
		authResponse.setAuthenStatus(authenStatus);
		
		return authResponse;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="password/getResetEmail",method= RequestMethod.POST)
	public int getPasswordResetEmail(HttpServletRequest request, @RequestBody UserWM userWM) throws Exception{
		
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
    	
		int id = 0;
		Log4JUtil.logger.info("PASSWORD,password_reset_email_request,Request="+userWM.toString());
		LoginService service = new LoginService();
		Mapper mapper =new Mapper();
		try{
			id = service.getPasswordResetEmail(userWM.getEmail());			
		}catch(Exception exp){
			Log4JUtil.logger.info("PASSWORD,password_reset_email_request,Request="+userWM.toString()+ exp.getMessage());
			throw new UserNotFoundException();
		}		
		if(id==0) throw new UserNotFoundException();
		
		return id;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="password/submitNewPassword", method=RequestMethod.POST)
	public StatusResp submitNewPassword(HttpServletRequest request, @RequestBody PasswordResetReq passwordResetReq) throws Exception {
		
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
    	
		int id =0;
		Log4JUtil.logger.info("PASSWORD,submit_new_password_request,Request="+passwordResetReq.toString());
		LoginService service = new LoginService();
		try{
			id = service.submitNewPassword(passwordResetReq.getUsername(),passwordResetReq.getPassword(),passwordResetReq.getResetCode());
		}catch(Exception exp){
			Log4JUtil.logger.info("PASSWORD,submit_new_password_request,Request="+passwordResetReq.toString()+ exp.getMessage());
			throw new UserNotFoundException();
		}
		StatusResp statusResp = new StatusResp();
		statusResp.setStatus(id);
		
		return statusResp;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping (value="password/change",method=RequestMethod.POST)
	public StatusResp changePassword(HttpServletRequest request, @RequestBody ChangePasswordReq changePasswordReq) throws Exception{
		
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
    	
		int id =0;
		Log4JUtil.logger.info("PASSWORD,change_password_request,Request="+changePasswordReq.toString());
		LoginService service = new LoginService();
		try{
			id = service.changePassword(changePasswordReq.getUsername(),changePasswordReq.getCurrentPassword(),changePasswordReq.getNewPassword());
		}catch(Exception exp){
			Log4JUtil.logger.info("PASSWORD,change_password_request,Request="+changePasswordReq.toString()+ exp.getMessage());
			throw new UserNotFoundException();
		}
		
		StatusResp statusResp = new StatusResp();
		statusResp.setStatus(id);
		
		return statusResp;		
	}
	/**
	 * Changed code
	**/
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/loginByMobile",method= RequestMethod.POST) 
	public RegistrationReferenceResponse patientLoginByMobile(HttpServletRequest request, @RequestBody PatientLoginReq patientLoginReq) throws Exception  {
		
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
    	
		Log4JUtil.logger.info("WEB_LOGIN,initial_login_request,Request="+patientLoginReq.toString());
		User user = new User(); 
		LoginService loginService = new LoginService();
		try{
			user = loginService.patientLoginByMobile(patientLoginReq.getMobile());
		}catch(Exception exp){
			Log4JUtil.logger.info("WEB_LOGIN,initial_login_request,Request="+patientLoginReq.toString()+exp.getMessage());
			throw new UserNotFoundException();
		}
		RegistrationReferenceResponse response= new RegistrationReferenceResponse();
		response.setReferenceId(user.getReferenceId());
			
		return response;
	}
	/**
	 * Changed code
	 * **/
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/loginByNic",method= RequestMethod.POST) 
	public PatientAuthResponse patientLoginByNic(HttpServletRequest request, @RequestBody PatientAuthReq patientAuthReq) throws Exception{
		
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
    	
		PatientAuthResponse authResponse = new PatientAuthResponse();
		Log4JUtil.logger.info("WEB_LOGIN,patient_login_request,Request="+patientAuthReq.toString());
		LoginService service = new LoginService();
		int authenStatus =0;		
		try{
			authenStatus = service.getAuthStatusByNic(patientAuthReq.getNic(), patientAuthReq.getParentNIC());
		}catch(Exception exp){
			Log4JUtil.logger.info("WEB_LOGIN,patient_login_request,Request="+patientAuthReq.toString()+exp.getMessage());
			throw new UserNotFoundException();
		}
		authResponse.setAuthenStatus(authenStatus);
		
		return authResponse;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/Institutelogin", method = RequestMethod.POST)
	public int authenticateUser(HttpServletRequest request, @RequestBody InstituteLoginReq instituteloginReq) throws Exception{
		
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
		
		Log4JUtil.logger.info("LOGIN,initial_login_request,Request="+instituteloginReq.toString());
		//System.out.println("info :"+loginReq.toString());
		LoginService loginService = new LoginService();
		Mapper mapper = new Mapper();
		//UserInfo userInfo = null;
		int instituteId =0;
		try {
			instituteId = loginService.getInstituteUser(instituteloginReq.getUsername(), instituteloginReq.getPassword());
		} catch (Exception e) {
			Log4JUtil.logger.info("LOGIN,login_error,Request="+instituteloginReq.toString()+","+ e);
			throw new UserNotFoundException();
		}
	//	if ( status == "fail" ) throw new UserNotFoundException();
		//UserWM infoWM = mapper.mapUserInfo(userInfo);
		return instituteId;
	}
}
