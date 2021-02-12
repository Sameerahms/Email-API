/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialArray;

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
import com.mobios.ep.services.HealthWikiService;
import com.mobios.ep.web.models.FileUploadInfo;
import com.mobios.ep.web.models.HealthWikiResp;
import com.mobios.ep.web.models.HealthWikiSharedReq;
import com.mobios.ep.web.models.HealthWikiWM;
import com.mobios.ep.web.models.PatientListReq;
import com.mobios.ep.web.models.PatientReq;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoHealthWikiFoundException;
import com.ombios.ep.entity.model.HealthWiki;
import com.ombios.ep.entity.model.HealthWikiRespEM;
import com.ombios.ep.entity.model.HealthWikiShared;

/**
 * @author Nishantha
 *
 */
@RestController
public class HealthWikiController {
	@CrossOrigin(origins="*")
	@RequestMapping(value="healthWiki/save",method=RequestMethod.POST) 
	public int saveHealthWiki(HttpServletRequest request, @RequestBody HealthWikiWM healthWikiWM) throws Exception{
		
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
		Log4JUtil.logger.info("HEALTHWIKI,health_wiki_save_request,Request="+healthWikiWM.toString());
		HealthWikiService service = new HealthWikiService();
		Mapper mapper = new Mapper();
		HealthWiki healthWiki =  mapper.mapSaveHealthWiki(healthWikiWM);
		try{
			id = service.saveHealthWiki(healthWiki);
		}catch(Exception exp){
			Log4JUtil.logger.info("HEALTHWIKI,health_wiki_save_request,Request="+healthWikiWM.toString());
			throw new NoHealthWikiFoundException();
		}
		
		return id;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="healthWiki/list",method=RequestMethod.POST)
	public List<HealthWikiWM> getHealthWiki(HttpServletRequest request, @RequestBody HealthWikiWM healthWikiWM) throws Exception{
		
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
    	
		List<HealthWikiWM> wikiWMs = new ArrayList<HealthWikiWM>();
		List<HealthWiki>  healthWikis =new ArrayList<HealthWiki>();
		Log4JUtil.logger.info("HEALTHWIKI,health_wiki_get_request,Request="+healthWikiWM.toString());
		HealthWikiService service = new HealthWikiService();
		Mapper mapper = new Mapper();
		try{
			healthWikis = service.getHealthWiki(healthWikiWM.getDoctorId());
		}catch(Exception exp){
			Log4JUtil.logger.info("HEALTHWIKI,health_wiki_get_request,Request="+healthWikiWM.toString());
			throw new NoHealthWikiFoundException();
		}
		if(healthWikis.size()==0) throw new NoHealthWikiFoundException();
		wikiWMs = mapper.mapHealthWiki(healthWikis);
		
		return wikiWMs;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="healthWiki/delete",method=RequestMethod.POST)
	public boolean deleteHealthWiki(HttpServletRequest request, @RequestBody HealthWikiWM healthWikiWM) throws Exception{
		
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
    	
		boolean isDeletedSuccess= false;
		Log4JUtil.logger.info("HEALTHWIKI,health_wiki_delete_request,Request="+healthWikiWM.toString());
		HealthWikiService service = new HealthWikiService();
		try{
			isDeletedSuccess = service.deleteHealthWiki(healthWikiWM.getId());
		}catch(Exception exp){			
			Log4JUtil.logger.info("HEALTHWIKI,health_wiki_delete_request,Request="+healthWikiWM.toString());
			throw new NoHealthWikiFoundException();
		}
		return isDeletedSuccess;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="healthWiki/upload",method=RequestMethod.POST)
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
		Log4JUtil.logger.info("HEALTHWIKI,health_wiki_upload_request,Request="+inputFile.toString());
		HttpHeaders headers = new HttpHeaders();
		File destinationFile= null;
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				destinationFile = new File(System.getProperty("catalina.base")+ File.separator +"webapps" +File.separator+"epUat" +File.separator+"resources"+File.separator+"healthWiki"+File.separator+originalFilename);
				//File destinationFile = new File("http://bluevok.com/epServer/resources/wiki/"+originalFilename);
				inputFile.transferTo(destinationFile);
				fileUploadInfo.setName(originalFilename);
				//String fileUrl = "http://bluevok.com/epServer/resources/healthWiki/"+originalFilename; // for Live
				String fileUrl = "http://213.136.79.138:8080/epUat/resources/healthWiki/"+originalFilename; // for UAT
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
	@RequestMapping(value="/healthWiki/share", method=RequestMethod.POST)
	public int ShareHealthWiki(HttpServletRequest request, @RequestBody HealthWikiSharedReq req) throws Exception{
		
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
		Log4JUtil.logger.info("HEALTHWIKI,health_wiki_share_request,Request="+req.toString());
		HealthWikiShared wikiShared = new HealthWikiShared();
		HealthWikiService service = new HealthWikiService();
		Mapper mapper = new Mapper();		
		try{
			wikiShared = mapper.mapSaveHealthWikiShared(req);
			id = service.ShareHealthWiki(wikiShared);
		}catch(Exception exp){
			Log4JUtil.logger.info("HEALTHWIKI,health_wiki_shared_request,Request="+req.toString());
			throw new NoHealthWikiFoundException();
		}

		return id;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/healthWiki/listByPatientId", method= RequestMethod.POST)
	public List<HealthWikiWM> getHealthWikiSharedListByPatientId(HttpServletRequest request, @RequestBody PatientReq patientReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("HEALTHWIKI,get_health_wiki_shared_request,Request="+patientReq.toString());
		List<HealthWikiWM> healthWikiWMs = new ArrayList<>();
		List<HealthWiki> healthWikis = new ArrayList<>();		
		HealthWikiService service = new HealthWikiService();
		Mapper mapper = new Mapper();
		try{
			healthWikis = service.getHealthWikiSharedListByPatientId(patientReq.getPatientId());
			healthWikiWMs = mapper.mapHealthWiki(healthWikis);
		}catch(Exception exp){
			Log4JUtil.logger.info("HEALTHWIKI,get_health_wiki_shared_request,Request="+patientReq.toString()+" , "+ exp.getMessage());
			throw new NoHealthWikiFoundException();
		}
				
		return healthWikiWMs;
	} 
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/healthWiki/listByPatientIds", method= RequestMethod.POST)
	public List<HealthWikiResp> getHealthWikiSharedList(HttpServletRequest request, @RequestBody PatientListReq patientListReq)  throws Exception{
		
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
    	
		Log4JUtil.logger.info("HEALTHWIKI,get_health_wiki_list_request,Request="+patientListReq.toString());
		List<HealthWikiRespEM> healthWikiRespEMs = new ArrayList<>();
		List<HealthWikiResp> healthWikiResps = new ArrayList<>();
		HealthWikiService service = new HealthWikiService();
		Mapper mapper = new Mapper();		
		try{
			healthWikiRespEMs = service.getHealthWikiSharedList(patientListReq.getPatients());
			healthWikiResps = mapper.mapHealthWikiResp(healthWikiRespEMs);
		}catch(Exception exp){
			Log4JUtil.logger.info("HEALTHWIKI,get_health_wiki_list_request,Request="+patientListReq.toString()+" , "+ exp.getMessage());
			throw new NoHealthWikiFoundException();
		}
		
		return healthWikiResps;
	}
}
