/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.PatientService;
import com.mobios.ep.services.SmsService;
import com.mobios.ep.services.UrlShortningService;
import com.mobios.ep.web.models.BloodGroupReq;
import com.mobios.ep.web.models.Patient;
import com.mobios.ep.web.models.PatientByNicOrMoblieReq;
import com.mobios.ep.web.models.PatientGetPassword;
import com.mobios.ep.web.models.PatientGetPasswordResponse;
import com.mobios.ep.web.models.PatientListReq;
import com.mobios.ep.web.models.PatientNameResp;
import com.mobios.ep.web.models.PatientUpdatePassword;
import com.mobios.ep.web.models.Prescription;
import com.mobios.ep.web.models.RegistrationOtpReq;
import com.mobios.ep.web.models.RegistrationReferenceResponse;
import com.mobios.ep.web.models.RegistrationReq;
import com.mobios.ep.web.models.StatusResp;
import com.mobios.ep.web.models.SubmitOtpReq;
import com.mobios.ep.web.models.UpdateMobileReq;
import com.mobios.ep.web.models.UserProfileWM;
import com.mobios.ep.web.models.UserWM;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.EPExceptionCodes;
import com.mobios.ep.web.util.MD5Encryption;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoPatientFoundException;
import com.mobios.ep.web.util.UserNotFoundException;
import com.ombios.ep.entity.factory.LoginFactory;
import com.ombios.ep.entity.model.PatientEM;
import com.ombios.ep.entity.model.RegistrationResponseEM;
import com.ombios.ep.entity.model.UrlRef;
import com.ombios.ep.entity.model.User;
import com.ombios.ep.entity.model.UserInfo;

/**
 * Controller for giving patient details
 * @author Nishantha
 *
 */

@RestController
public class PatientController{
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/listByNic",method = RequestMethod.POST) 
	public List<UserWM> patientByNIC(HttpServletRequest request, @RequestBody UserWM userWM) throws Exception{
		
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
    	
		PatientService patientService = new PatientService();
		Mapper mapper = new Mapper();
		List<UserInfo> userInfo = new ArrayList<UserInfo>();
		List<UserWM> userWMList = null;
		userInfo = patientService.getPatientByNIC(userWM.getNic(),userWM.getParentNIC(), userWM.getPassportNo());
		if(userInfo.size()==0) throw new NoPatientFoundException();
		try{
			userWMList = mapper.mapPatient(userInfo);
		}catch(Exception exp){
			throw new Exception(exp.getMessage());
		}			
		return userWMList;
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/listBy",method = RequestMethod.POST) 
	public List<UserWM> patientBy(HttpServletRequest request, @RequestBody UserWM userWM) throws Exception{
		
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
    	
		PatientService  patientService = new PatientService();
		
		List<UserInfo> userInfo = new ArrayList<UserInfo>();
		List<UserWM> userWMList = new ArrayList<UserWM>() ;
		
		//TODO: Passport to be implemented
		userInfo = patientService.getPatients(userWM.getNic(),userWM.getParentNIC(), userWM.getMobile(), userWM.getName(), "");
		// no users found
		if(userInfo.size()==0 ) throw new NoPatientFoundException();
		
		try{
			Mapper mapper 	= new Mapper();
			userWMList 		= mapper.mapPatient(userInfo);
		}catch(Exception exp){
			throw new Exception(exp.getMessage());
		}			
		return userWMList;		
	}
/** Made Changes
 * */	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/listByMobile",method = RequestMethod.POST) 
	public List<UserWM> patientByMobile(HttpServletRequest request, @RequestBody UserWM userWM) throws Exception{
		
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
    	
		PatientService  patientService = new PatientService();
		
		List<UserInfo> userInfo = new ArrayList<UserInfo>();
		List<UserWM> userWMList = new ArrayList<UserWM>() ;
		
		//TODO: Passport to be implemented
		userInfo = patientService.getPatientsByMobile(userWM.getMobile());
		// no users found
		if(userInfo.size()==0 ) throw new NoPatientFoundException();
		
		try{
			Mapper mapper 	= new Mapper();
			userWMList 		= mapper.mapPatient(userInfo);
		}catch(Exception exp){
			throw new Exception(exp.getMessage());
		}			
		return userWMList;		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/patient/save", method = RequestMethod.POST)
	public @ResponseBody int savePatient(HttpServletRequest request, @RequestBody Patient patient) throws Exception{
		
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
    	
		System.out.println(">>>>>>>>>> "+patient.getPassportNo());
		int id=0;	
		PatientService patientService= new PatientService();
		Mapper mapper = new Mapper();
		UserInfo userInfo = mapper.mapPatientSave(patient);
				
		try{
			System.out.println("/patient/save " + userInfo.getPassportNo());
			System.out.println("/patient/save " + userInfo.getFirstName());
			id= patientService.savePatient(userInfo);
			
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_save_request,Request="+patient.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/patient/saveBloodgroup",method = RequestMethod.POST)
	public @ResponseBody int editBloodGroup(HttpServletRequest request, @RequestBody BloodGroupReq bloodGroupReq) throws Exception{
		
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
		PatientService  patientService= new PatientService();
		Mapper mapper = new Mapper();
		UserInfo userInfo = mapper.mapBloodGroupReq(bloodGroupReq);
		try{
			id = patientService.editBloodGroup(userInfo, bloodGroupReq.getDoctorId(), bloodGroupReq.getBloodGroup());
			
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_edit_request,Request="+bloodGroupReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/register",method=RequestMethod.POST) 
	public RegistrationReferenceResponse registerPatient(HttpServletRequest request, @RequestBody RegistrationReq registrationReq) throws Exception{
		
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
		Log4JUtil.logger.info("PATIENT,patient_register_request,Request="+registrationReq.toString());
		PatientService  service= new PatientService();
		Mapper mapper = new Mapper();
		RegistrationResponseEM mappedPatient = mapper.mapUserRegister(registrationReq);
		RegistrationResponseEM em =null;
		try{
			em = service.registerPatient(mappedPatient);
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_register_request,Request="+registrationReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		RegistrationReferenceResponse response= new RegistrationReferenceResponse();
		response.setReferenceId(em.getReferenceId());
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/getOtpCode",method=RequestMethod.POST)
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
    	
		RegistrationReferenceResponse response = new RegistrationReferenceResponse();
		Log4JUtil.logger.info("PATIENT,patient_getOtpCode_request,Request="+submitOtpReq.toString());
		PatientService  service= new PatientService();
		Mapper mapper = new Mapper();
		RegistrationResponseEM rrEM=null;	
		RegistrationResponseEM mappedRegistrationResponse= mapper.mapGetOtp(submitOtpReq);		
		try{
			rrEM = service.getOtpCode(mappedRegistrationResponse);
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_getOtpCode_request,Request="+submitOtpReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		response.setReferenceId(rrEM.getReferenceId());
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/submitPatientProfile",method=RequestMethod.POST)
	public int submitPatientProfile(HttpServletRequest request, @RequestBody Patient patient) throws Exception{
		
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
		Log4JUtil.logger.info("PATIENT,patient_profile_submit_request,Request="+patient.toString());
		PatientService service = new PatientService();
		Mapper mapper = new Mapper();
		UserInfo userInfo = mapper.mapPatientSave(patient);
		try{
			id = service.submitPatientProfile(userInfo);
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_profile_submit_request,Request="+patient.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/get",method=RequestMethod.POST)
	public UserWM getPatient(HttpServletRequest request, @RequestBody Patient patient) throws Exception {
		
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
    	
		UserWM  userWM = new UserWM();	
		UserInfo userInfo = new UserInfo();
		Log4JUtil.logger.info("PATIENT,get_patientrequest,Request="+patient.toString());
		PatientService service = new PatientService();
		Mapper mapper = new Mapper();
		try{
			userInfo = service.getPatient(patient.getId());
			userWM = mapper.mapUserInfoPatient(userInfo);
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,get_patientrequest,Request="+patient.toString()+","+ exp.getMessage());
			throw new UserNotFoundException();
		}

		return userWM ;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="patient/updateMoblieById",method=RequestMethod.POST)
	public boolean updateMobileById(HttpServletRequest request, @RequestBody UpdateMobileReq updateMobileReq )throws Exception {
		
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
    	
		boolean isUpdateSuccess= false;
		Log4JUtil.logger.info("PATIENT,update_patient_mobile_request,Request="+updateMobileReq.toString());
		PatientService service = new PatientService();
		try{
			isUpdateSuccess = service.updateMobileById(updateMobileReq.getIds(), updateMobileReq.getMobile());
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,update_patient_mobile_request,Request="+updateMobileReq.toString()+","+ exp.getMessage());
			throw new UserNotFoundException();			
		}		
		
		return isUpdateSuccess;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/patient/nameListByIds", method= RequestMethod.POST)
	public List<PatientNameResp> getPatientNamesById(HttpServletRequest request, @RequestBody PatientListReq patientListReq) throws Exception {
		
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
    	
		List<PatientNameResp> patientNameResps = new ArrayList<>();
		List<UserInfo>  patientRespsUI = new ArrayList<>();
		Log4JUtil.logger.info("PATIENT,get_patient_name_list_request,Request="+patientListReq.toString());
		PatientService service = new PatientService();
		Mapper mapper = new Mapper();
		try{
			patientRespsUI = service.getPatientNamesById(patientListReq.getPatients());
			patientNameResps = mapper.mapPatientResps(patientRespsUI);
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,get_patient_name_list_request,Request="+patientListReq.toString()+","+ exp.getMessage());
			throw new UserNotFoundException();		
		}
		
		return patientNameResps;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/sendOtp",method=RequestMethod.POST)
	public RegistrationOtpReq sendOtp(HttpServletRequest request, @RequestBody RegistrationOtpReq registrationsubmitOtpReq) throws Exception{
		
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
    	
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		Log4JUtil.logger.info("PATIENT,patient_setOtp_request,Request="+registrationsubmitOtpReq.toString());
		SmsService smsService = new SmsService();
		MD5Encryption md5Encryption = new MD5Encryption();
		registrationsubmitOtpReq.setReferenceId(md5Encryption.getMD5EncryptedValue(Integer.toString(otp)));
		registrationsubmitOtpReq.setOtp(Integer.toString(otp));
		PatientService service = new PatientService();
		try{
			service.patientUpdateOtp(registrationsubmitOtpReq.getMobile(), registrationsubmitOtpReq.getReferenceId(), otp);
			smsService.sendSmsService("Your OTP code is "+otp, registrationsubmitOtpReq.getMobile());
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_getOtpCode_request,Request="+registrationsubmitOtpReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		registrationsubmitOtpReq.setOtp(null);
		return registrationsubmitOtpReq;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/confirmOtp",method=RequestMethod.POST)
	public RegistrationOtpReq confirmOtp(HttpServletRequest request, @RequestBody RegistrationOtpReq registrationsubmitOtpReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("PATIENT,patient_confirmOtp_request,Request="+registrationsubmitOtpReq.toString());
		MD5Encryption md5Encryption = new MD5Encryption();
		//........
//		LoginFactory loginFactory = new LoginFactory();
//		User user = new User();	
//		UrlRef userRef = new UrlRef();
		//.............
		String referenceId = md5Encryption.getMD5EncryptedValue(registrationsubmitOtpReq.getOtp());
		//............
//		user = loginFactory.getUserInfo(referenceId);
		//.............
		if(!registrationsubmitOtpReq.getReferenceId().equals(referenceId)) {
			registrationsubmitOtpReq.setReferenceId("OTP is not valid");
		} 
//		else {
//			//..............
//			System.out.println("asasas "+user.getOtpConfirmationAttempt());
//			user.setOtpConfirmationAttempt(user.getOtpConfirmationAttempt()+1);
//			System.out.println("rrrr "+user.getOtpConfirmationAttempt());
//			loginFactory.updateUser(user);
//			System.out.println("Update" +user.getOtpConfirmationAttempt());
//			
//			if (user.getOtpConfirmationAttempt() == 1) {	
//				UserInfo userInfo=loginFactory.getUserInfoById(user.getUserId());
//				
//				UrlShortningService urlShortningService = new UrlShortningService();
//				String newUrl = urlShortningService.getShortningUrl("http://213.136.79.138:8080/MedicaMobileRewards/index.jsp?id=", userInfo.getMobile(), userInfo.getId());
//				
//				SmsService smsService = new SmsService();
//				smsService.sendSmsService("You have recieved 1GB Data.Invite 10 Friends to win more Data. " +newUrl, userInfo.getMobile());
//				System.out.println("send new user to web link and data");
//				
//				boolean isUser = loginFactory.checkUserByMobile(userInfo.getMobile());
//				System.out.println(isUser);
//				
//				if (isUser == true) {
//					System.out.println("new user is an invited user");
//					userRef = loginFactory.getUserInfoByMobile(userInfo.getMobile());
//					System.out.println("get invited user info");
//					UserInfo invitedUser = new UserInfo();
//					invitedUser = loginFactory.getInvitedUserInfoById(userRef.getRef_id());
//				
//					String s = "0";
//					
//				if (userRef.getExsit_id().equals(s)) {
//					smsService.sendSmsService("You have recieved 10GB Data.", invitedUser.getMobile());
//					System.out.println("send data to invited user");
//				}
//			}
//		}
//			//............
//		}
		
		return registrationsubmitOtpReq;
	}
	/**
	 * Changed code
	 * Service for updating patient password when patient enters one 
	 * */
	@CrossOrigin(origins="*")
	@RequestMapping(value="patient/updatePassword", method=RequestMethod.POST)
	public RegistrationReferenceResponse  patientUpdatePassword(HttpServletRequest request, @RequestBody PatientUpdatePassword updatepassword) throws Exception {
		
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
    	
		//int id =0;
		Log4JUtil.logger.info("PATIENT,patient_update_password_request,Request="+updatepassword.toString());
		PatientService service = new PatientService();
		User user = new User(); 
		Mapper mapper = new Mapper();
		try{
			user = service.patientUpdatePassword(updatepassword.getUsername(),updatepassword.getPassword());
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_update_password_request,Request="+updatepassword.toString()+ exp.getMessage());
			throw new UserNotFoundException();
		}
		
		//return id;
		RegistrationReferenceResponse response= new RegistrationReferenceResponse();
		response.setReferenceId(user.getReferenceId());
			
		return response;
		
	}
	/**
	 * Changed code
	 * Service for getting patient password when patient enters username(mobile no) 
	 * */
	@CrossOrigin(origins="*")
	@RequestMapping(value="patient/getPasswordByMobile", method=RequestMethod.POST)
	public  PatientGetPasswordResponse patientGetPassword(HttpServletRequest request, @RequestBody  PatientGetPassword getmobile) throws Exception {
		
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
    	
		Log4JUtil.logger.info("PATIENT,patient_get_password_request,Request="+getmobile.toString());
		PatientService service = new PatientService();
		User user = new User(); 
		try{
			user = service.patientGetPasswordByMobile(getmobile.getMobile(), getmobile.getPassword());
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_get_password_request,Request="+getmobile.toString()+ exp.getMessage());
			throw new UserNotFoundException();
		}
		
		PatientGetPasswordResponse response= new  PatientGetPasswordResponse();
		if(user != null && user.getPassword() != null && user.getPassword() != "") {
			response.setIsValid(true);
		}else {
			response.setIsValid(false);
		}
		return response;
		
	}
	/**
	 * Changed code
	 * Service for getting patient password when patient enters nic 
	 * */
	@CrossOrigin(origins="*")
	@RequestMapping(value="patient/getPasswordByNic", method=RequestMethod.POST)
	public PatientGetPasswordResponse  patientGetPasswordByNic(HttpServletRequest request, @RequestBody PatientGetPassword getnic) throws Exception {
		
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
    	
		Log4JUtil.logger.info("PATIENT,patient_get_password_request,Request="+getnic.toString());
		PatientService service = new PatientService();
		User user = new User(); 
		try{
			user = service.patientGetPasswordByNic(getnic.getNic(), getnic.getPassword());
		}catch(Exception exp){
			Log4JUtil.logger.info("PATIENT,patient_get_password_request,Request="+getnic.toString()+ exp.getMessage());
			throw new UserNotFoundException();
		}
		
		PatientGetPasswordResponse response= new PatientGetPasswordResponse();
		//response.setPassword(user.getPassword());
		if(user != null && user.getPassword() != null && user.getPassword() != "") {
			response.setIsValid(true);
		}else {
			response.setIsValid(false);
		}
		
		return response;
		
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="patient/listByDOB",method = RequestMethod.POST) 
	public List<UserWM> patientByDOB(HttpServletRequest request, @RequestBody UserWM userWM) throws Exception{
		
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
    	
		PatientService  patientService = new PatientService();
		
		List<UserInfo> userInfo = new ArrayList<UserInfo>();
		List<UserWM> userWMList = new ArrayList<UserWM>() ;
		
		//TODO: Passport to be implemented
		userInfo = patientService.getPatientsByDOB(userWM.getDateOfBirth());
		// no users found
		if(userInfo.size()==0 ) throw new NoPatientFoundException();
		
		try{
			Mapper mapper 	= new Mapper();
			userWMList 		= mapper.mapPatient(userInfo);
		}catch(Exception exp){
			throw new Exception(exp.getMessage());
		}			
		return userWMList;		
	}
}
