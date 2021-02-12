/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.DoctorService;
import com.mobios.ep.web.models.AppointmentReq;
import com.mobios.ep.web.models.Doctor;
import com.mobios.ep.web.models.DoctorProfileWM;
import com.mobios.ep.web.models.DoctorReq;
import com.mobios.ep.web.models.FileUploadInfo;
import com.mobios.ep.web.models.UserWM;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoAppointmentFoundException;
import com.mobios.ep.web.util.NoDoctorFoundException;
import com.ombios.ep.entity.model.DoctorProfile;
import com.ombios.ep.entity.model.UserInfo;

/**
 * @author Nishantha
 *
 */
@RestController
public class DoctorController {
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="doctor/list",method = RequestMethod.POST)
	public List<UserWM> getDoctorList(HttpServletRequest request, @RequestBody DoctorReq doctorReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("DOCTOR,doctor_list_request,Request="+doctorReq.toString());
		DoctorService  doctorService= new DoctorService();
		Mapper mapper= new Mapper();
		List<UserWM> doctor =new ArrayList<UserWM>();
		List<UserInfo> userInfo = new ArrayList<UserInfo>();
		try{ 
			userInfo = doctorService.getDoctorList(doctorReq.getInstituteId());
		}catch(Exception exp){
			Log4JUtil.logger.info("DOCTOR,doctor_list_request,Request="+doctorReq.toString()+","+ exp.getMessage());
			throw new NoDoctorFoundException();
		}
		doctor = mapper.mapPatient(userInfo);
		if(doctor.size()==0) throw new NoDoctorFoundException();
		return 	doctor;	
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="doctor/save", method = RequestMethod.POST)
	public @ResponseBody int saveDoctor(HttpServletRequest request, @RequestBody Doctor doctor) throws Exception {
		
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
		Log4JUtil.logger.info("DOCTOR, doctor_save_request,Request="+doctor.toString());
		UserInfo doctorInfo = new UserInfo();
		DoctorService  doctorService= new DoctorService();
		Mapper mapper = new Mapper();
		doctorInfo = mapper.mapSaveDoctor(doctor);
		try{
			id = doctorService.saveDoctor(doctorInfo);
		}catch(Exception exp){
			Log4JUtil.logger.info("DOCTOR, doctor_save_request,Request="+doctor.toString()+","+ exp.getMessage());			
			throw new NoDoctorFoundException();
		}		
		
		return id;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="doctorExt/save",method=RequestMethod.POST) 
	public @ResponseBody  int saveDoctorExtended(HttpServletRequest request, @RequestBody DoctorProfileWM doctorProfileWM) throws Exception {
		
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
		Log4JUtil.logger.info("DOCTOR, doctor_saveExt_request,Request="+doctorProfileWM.toString());
		DoctorService service = new DoctorService();
		Mapper mapper= new Mapper();
		DoctorProfile doctorProfile = mapper.mapSaveDoctorExtended(doctorProfileWM);
		try{
			id = service.saveDoctorExtended(doctorProfile);
		}catch(Exception exp){
			Log4JUtil.logger.info("DOCTOR, doctor_saveExt_request,Request="+doctorProfileWM.toString()+","+ exp.getMessage());
			throw new NoDoctorFoundException();
		}
		
		return id;
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="doctorById/get", method= RequestMethod.POST) 
	public UserWM getDoctorById(HttpServletRequest request, @RequestBody UserWM wm) throws Exception {
		
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
    	
		UserWM userWM = new UserWM();
		UserInfo userInfo = new UserInfo();
		Log4JUtil.logger.info("DOCTOR, doctor_getExt_request,Request="+wm.toString());
		DoctorService  doctorService= new DoctorService();
		Mapper mapper = new Mapper();
		try{
			userInfo = doctorService.getDoctorById(wm.getId());
		}catch(Exception exp){
			Log4JUtil.logger.info("DOCTOR, doctor_getExt_request,Request="+userInfo.toString()+","+ exp.getMessage());
			throw new NoDoctorFoundException();
		}
		if(userInfo.getId()==0) throw new NoDoctorFoundException();
		userWM =mapper.mapUser(userInfo);
		
		return userWM;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="doctorExt/get", method= RequestMethod.POST) 
	public DoctorProfileWM getDoctorExt(HttpServletRequest request, @RequestBody DoctorProfileWM wm) throws Exception {
		
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
    	
		DoctorProfileWM doctorProfileWM = new DoctorProfileWM();
		DoctorProfile doctorProfile = new DoctorProfile();
		Log4JUtil.logger.info("DOCTOR, doctor_getExt_request,Request="+doctorProfileWM.toString());
		DoctorService service = new DoctorService();
		Mapper mapper = new Mapper();
		try{
			doctorProfile = service.getDoctorExt(wm.getId());
		}catch(Exception exp){
			Log4JUtil.logger.info("DOCTOR, doctor_getExt_request,Request="+doctorProfileWM.toString()+","+ exp.getMessage());
			throw new NoDoctorFoundException();
		}
		if(doctorProfile.getId()==0) throw new NoDoctorFoundException();
		doctorProfileWM =mapper.mapGetDoctorExtended(doctorProfile);
		
		return doctorProfileWM;
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value="doctor/upload",method=RequestMethod.POST, consumes = {"multipart/*"}, headers = "content-type=multipart/form-data")
	public ResponseEntity<FileUploadInfo> upload(HttpServletRequest request, @RequestParam("file") MultipartFile inputFile) throws Exception {
		
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
    	
		FileUploadInfo fileUploadInfo = new FileUploadInfo();
		Log4JUtil.logger.info("DOCTOR,doctor_profile_image_upload_request,Request="+inputFile.toString());
		HttpHeaders headers = new HttpHeaders();
		File destinationFile= null;
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				destinationFile = new File(System.getProperty("catalina.base")+ File.separator +"webapps" +File.separator+"epUat" +File.separator+"resources"+File.separator+"doctor"+File.separator+originalFilename);
				//File destinationFile = new File("http://bluevok.com/epServer/resources/wiki/"+originalFilename);
				inputFile.transferTo(destinationFile);
				fileUploadInfo.setName(originalFilename);
				//String fileUrl = "http://bluevok.com/epServer/resources/doctor/"+originalFilename; // for Live
				String fileUrl = "http://213.136.79.138:8080/epUat/resources/doctor/"+originalFilename; // for UAT
				//String fileUrl = "http://localhost:8080/epUat/resources/doctor/"+originalFilename; // for Local
				fileUploadInfo.setFilePath(fileUrl);
				headers.add("File Uploaded Successfully - ", originalFilename);
				String referenceId = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d").randomUUID().toString().replace("-", "").substring(0, 8);
				fileUploadInfo.setReferenceId(referenceId);
				return new ResponseEntity<FileUploadInfo>(fileUploadInfo, headers, HttpStatus.OK);
			} catch (Exception exp) {    
				Log4JUtil.logger.info("DOCTOR,doctor_profile_image_upload_request,Request="+destinationFile.getPath() +" "+exp.getMessage());
				return new ResponseEntity<FileUploadInfo>(HttpStatus.BAD_REQUEST);				
			}
		}else{
			Log4JUtil.logger.info("DOCTOR,doctor_profile_image_upload_request,Request="+"inputFile empty");
			return new ResponseEntity<FileUploadInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/doctorExt/getAll",method= RequestMethod.POST) 
	public List<DoctorProfileWM> getAllDoctorProfileExtend(HttpServletRequest request)throws Exception {
		
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
    	
		Log4JUtil.logger.info("DOCTOR, get_all_doctor_extended_request,Request="+"".toString());
		List<DoctorProfileWM> doctorProfileWMs = new ArrayList<DoctorProfileWM>();
		List<DoctorProfile> doctorProfiles = new ArrayList<DoctorProfile>();
		DoctorService service = new DoctorService();
		Mapper mapper= new Mapper();
		try{
			doctorProfiles = service.getAllDoctorProfileExtend();
		}catch(Exception exp){
			Log4JUtil.logger.info("DOCTOR,get_all_doctor_extended_request,Request="+"".toString()+","+ exp.getMessage());
			exp.printStackTrace();
		}
		if(doctorProfiles.size()!=0) doctorProfileWMs = mapper.mapGetDoctorExtendedList(doctorProfiles);
		
		return doctorProfileWMs;
	}
	
}
