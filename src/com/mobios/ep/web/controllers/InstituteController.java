/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.InstituteService;
import com.mobios.ep.web.models.EmailReq;
import com.mobios.ep.web.models.FileUploadInfo;
import com.mobios.ep.web.models.IdsReq;
import com.mobios.ep.web.models.InstituteReq;
import com.mobios.ep.web.models.InstituteWM;
import com.mobios.ep.web.models.InvestigationEmailReq;
import com.mobios.ep.web.models.SessionReq;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoInstituteFoundException;
import com.ombios.ep.entity.model.Institute;

/**
 * Controller for getting institutes
 * 
 * @author Nishantha
 *
 */
@RestController
public class InstituteController {
	@CrossOrigin(origins="*")
	@RequestMapping(value="institute/get", method=RequestMethod.POST)
	public InstituteWM getInstitute(HttpServletRequest request, @RequestBody InstituteReq instituteReq) throws Exception{
		
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
		InstituteWM  instituteWM = new InstituteWM();
		Log4JUtil.logger.info("INSTITUTE,institute_get,Request="+instituteReq.toString());
		Institute institute = new Institute();
		Mapper mapper = new Mapper();
		InstituteService service = new InstituteService();		
		try{
			institute = service.getInstitute(instituteReq.getId());
		}catch(Exception exp){
			Log4JUtil.logger.info("INSTITUTE,institute_get,Request="+instituteReq.toString()+","+ exp.getMessage());
			throw new EPException();
		} 
		if(institute.getId()==0) throw new NoInstituteFoundException();
		instituteWM = mapper.mapInstitute(institute);
		
		return instituteWM;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="institute/listByType", method =RequestMethod.POST)
	public List<InstituteWM> getInstituteList(HttpServletRequest request, @RequestBody InstituteReq instituteReq) throws Exception{
		
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
    	
		List<Institute>  institutes = new ArrayList<Institute>();
		List<InstituteWM>  instituteWMs = new ArrayList<InstituteWM>();
		Log4JUtil.logger.info("INSTITUTE,institute_get_list,Request="+instituteReq.toString());
		Mapper mapper = new Mapper();
		InstituteService service = new InstituteService();
		try{
			institutes = service.getInstituteList(instituteReq.getType());
		}catch(Exception exp){
			Log4JUtil.logger.info("INSTITUTE,institute_get_list,Request="+instituteReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(institutes.size()==0 ) throw new NoInstituteFoundException();
		instituteWMs = mapper.mapInstitutes(institutes);
		
		return instituteWMs;
	}	

	@CrossOrigin(origins="*")
	@RequestMapping(value="institute/sendEmail",method = RequestMethod.POST)
	public int sendEmail(HttpServletRequest request, @RequestBody EmailReq emailReq) throws Exception {
		
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
		Log4JUtil.logger.info("INSTITUTE,send_email_to_institutes_request,Request="+emailReq.toString());
		InstituteService service = new InstituteService();
		try{
			id = service.sendEmail(emailReq.getDoctorId(),emailReq.getInstituteIds(),emailReq.getMessage(), emailReq.getReason(), emailReq.getFromDate(), emailReq.getToDate(), emailReq.getDoctorName());
		}catch(Exception exp){
			Log4JUtil.logger.info("INSTITUTE,send_email_to_institutes_request,Request="+emailReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		return id;		
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="institute/listByDoctorId", method=RequestMethod.POST)
	public List<InstituteWM> getInstituteListByDoctorId(HttpServletRequest request, @RequestBody SessionReq sessionReq) throws Exception{
		
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
    	
		List<InstituteWM> instituteWMs = new ArrayList<InstituteWM>();
		List<Institute> institutes = new ArrayList<Institute>();
		Log4JUtil.logger.info("INSTITUTE,get_institutes_request,Request="+sessionReq.toString());
		Mapper mapper = new Mapper();
		InstituteService service = new InstituteService(); 
		try{
			institutes = service.getInstituteListByDoctorId(sessionReq.getDoctorId());
			instituteWMs = mapper.mapInstitutes(institutes);
		}catch(Exception exp){
			Log4JUtil.logger.info("INSTITUTE,get_institutes_request,Request="+sessionReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		
		return instituteWMs;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/institute/upload",method =RequestMethod.POST)
	public ResponseEntity<FileUploadInfo> uploadLogo(HttpServletRequest request, @RequestParam("file") MultipartFile inputFile) throws Exception {
		
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
		Log4JUtil.logger.info("INSTITUTE,institute_logo_upload_request,Request="+inputFile.toString());
		HttpHeaders headers = new HttpHeaders();
		File destinationFile =null;
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				destinationFile = new File(System.getProperty("catalina.base")+ File.separator +"webapps" +File.separator+"epUat" +File.separator+"resources"+File.separator+"institute"+File.separator+originalFilename);
				//File destinationFile = new File("http://bluevok.com/epServer/resources/institute/"+originalFilename);
				inputFile.transferTo(destinationFile);
				fileUploadInfo.setName(originalFilename);
				//String fileUrl = "http://bluevok.com/epServer/resources/institute/"+originalFilename; // for Live
				String fileUrl = "http://213.136.79.138:8080/epUat/resources/institute/"+originalFilename; // for UAT
				
				fileUploadInfo.setFilePath(fileUrl);
				headers.add("File Uploaded Successfully - ", originalFilename);
				String referenceId = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d").randomUUID().toString().replace("-", "").substring(0, 8);
				fileUploadInfo.setReferenceId(referenceId);
				return new ResponseEntity<FileUploadInfo>(fileUploadInfo, headers, HttpStatus.OK);
			} catch (Exception exp) {    
				Log4JUtil.logger.info("HEALTHWIKI,health_wiki_upload_request,Request="+destinationFile.getPath() +" "+exp.getMessage());
				return new ResponseEntity<FileUploadInfo>(HttpStatus.BAD_REQUEST);				
			}
		}else{
			Log4JUtil.logger.info("HEALTHWIKI,health_wiki_upload_request,Request="+"inputFile empty");
			return new ResponseEntity<FileUploadInfo>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="institute/save",method=RequestMethod.POST)
	public @ResponseBody int saveInstitute(HttpServletRequest request, @RequestBody InstituteWM instituteWM) throws Exception {
		
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
    	
		int id= 0;
		Log4JUtil.logger.info("INSTITUTE,save_institute_request,Request="+instituteWM.toString());
		Institute institute = new Institute();
		Mapper mapper = new Mapper();
		InstituteService service = new InstituteService();
		institute = mapper.mapSaveInstitute(instituteWM);
		try{
			id = service.saveInstitute(institute);
		}catch(Exception exp ){
			Log4JUtil.logger.info("INSTITUTE,save_institute_request,Request="+instituteWM.toString()+" , "+ exp.getMessage());
			exp.printStackTrace();
			throw new NoInstituteFoundException();
		}
				
		return id;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/institute/list",method= RequestMethod.POST) 
	public List<InstituteWM> getAllInstitutes(HttpServletRequest request)throws Exception{
		
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
    	
		List<InstituteWM> instituteWMs = new ArrayList<>();
//		Log4JUtil.logger.info("INSTITUTE,getAll_institute_request");
		List<Institute > institutes = new ArrayList<Institute>();
		Mapper mapper = new Mapper();
		InstituteService service = new InstituteService();
		try{
			institutes = service.getAllInstitutes();
//			instituteWMs = mapper.mapInstitutes(institutes);
		}catch(Exception exp){
			Log4JUtil.logger.info("INSTITUTE,getAll_institute_request,Request="+" , "+ exp.getMessage());
			exp.printStackTrace();
			throw new NoInstituteFoundException();
		}
		if(institutes.size() == 0) throw new NoInstituteFoundException();
		instituteWMs = mapper.mapInstitutes(institutes);
		
		return instituteWMs;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/institute/listByIds", method= RequestMethod.POST)
	public List<InstituteWM> getInstitutesByIds(HttpServletRequest request, @RequestBody IdsReq req) throws Exception{
		
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
    	
		List<InstituteWM> instituteWMs = new ArrayList<>();
		Log4JUtil.logger.info("INSTITUTE,get_institutes_by_ids_request,Request=");
		List<Institute > institutes = new ArrayList<Institute>();
		Mapper mapper =new Mapper();
		InstituteService service = new InstituteService();
		try{
			institutes = service.getInstitutesByIds(req.getIds());
		}catch(Exception exp){
			Log4JUtil.logger.info("INSTITUTE,get_institutes_by_ids_request,Request="+" , "+ exp.getMessage());
			exp.printStackTrace();
			throw new NoInstituteFoundException();
		}
		if(institutes.size()==0)  throw new NoInstituteFoundException();
		instituteWMs = mapper.mapInstitutes(institutes);
		
		return instituteWMs;
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value="institute/sendInvestigationEmail",method = RequestMethod.POST)
	public int sendInvestigationEmail(HttpServletRequest request, @RequestBody InvestigationEmailReq emailReq) throws Exception {
		
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
		Log4JUtil.logger.info("INSTITUTE,send_email_to_institutes_request,Request="+emailReq.toString());
		InstituteService service = new InstituteService();
		try{
			id = service.sendInvestigationEmail(emailReq.getDoctorId(),emailReq.getInstituteIds(),emailReq.gettest(), emailReq.getdiagnosis(), emailReq.getpName(), emailReq.getpAge(), emailReq.getgender(),emailReq.getDoctorName(),emailReq.getdoctorEmail(),emailReq.getdoctorHospitalName(),emailReq.getdoctorHospitalAddress1(),emailReq.getdoctorHospitalAddress2(),emailReq.getdoctorMobile(),emailReq.getImage(),emailReq.getinsEmailId());
		}catch(Exception exp){
			Log4JUtil.logger.info("INSTITUTE,send_email_to_institutes_request,Request="+emailReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		return id;		
	}
}
