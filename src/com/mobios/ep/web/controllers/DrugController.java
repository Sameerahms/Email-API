package com.mobios.ep.web.controllers;
  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mobios.ep.common.util.AuthTokenValidate;

//import sun.print.resources.serviceui;

import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.DrugService;
import com.mobios.ep.web.models.AuthToken;
import com.mobios.ep.web.models.DrugRejectReq;
import com.mobios.ep.web.models.DrugWM;
import com.mobios.ep.web.util.DrugNotFoundException;
import com.mobios.ep.web.util.DrugSaveException;
import com.mobios.ep.web.util.Mapper;
import com.ombios.ep.entity.model.Drug;
import com.ombios.ep.entity.model.NotVerifiedDrugsEM;


/**
 * Drug controller for requests such as drug list..etc
 * @author chandimal
 *
 */
@RestController
public class DrugController {
	
	
	/**
	 * Synch drug list with the latest updates
	 * @return
	 * @throws DrugNotFoundException 
	 * @throws IOException 
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/drug/list", method = RequestMethod.POST)
	public List<DrugWM> synch(HttpServletRequest request, @RequestBody DrugWM drugWM) throws DrugNotFoundException, IOException, Exception {	
		Log4JUtil.logger.info("DRUG,drug_sync_request,Request="+drugWM.toString());
		
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
    		
    	
		DrugService ds = new DrugService();
		Mapper mapper = new Mapper();
		
		List<Drug> drugsList = ds.getDrugList(drugWM.getLastUpdatedTime());
		if(drugsList == null) throw new DrugNotFoundException();
		List<DrugWM> mappedDrugList = mapper.mapData(drugsList);
		// covert to DrugWM models and sennd the reply
		
		return mappedDrugList;
	}

	
	/**
	 * Initialize the  drug list with all the drugs in the database
	 * @return
	 * @throws Exception 
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/init")
	public  List<DrugWM> init(HttpServletRequest request) throws Exception{
		
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
		
		DrugService ds = new DrugService();
		Mapper mapper = new Mapper();
		
		List<Drug> drugsList = ds.getDrugList();
		if(drugsList == null) throw new DrugNotFoundException();
		List<DrugWM> mappedDrugList = mapper.mapData(drugsList);
		
		return mappedDrugList;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/save", method = RequestMethod.POST)
	public int save(HttpServletRequest request, @RequestBody DrugWM drugWM) throws Exception{
		Log4JUtil.logger.info("DRUG,drug_save_request,Request="+drugWM.toString());
		
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
    	
		int drugId = 0;
		try{
			Mapper mapper = new Mapper();
			Drug drug = mapper.mapSavingDrug(drugWM);
			
			DrugService ds = new DrugService();
			drugId = ds.saveDrug(drug);
		}catch(Exception e){
			Log4JUtil.logger.info("DRUG,drug_save_request,Request="+drugWM.toString()+e.getMessage());
			throw new DrugSaveException();
		}
		
		
		return drugId;
	}
	
	/**
	 * Search drugs using trade name, generic name and category
	 * @param drugWM
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/search", method= RequestMethod.POST)
	public List<DrugWM> searchDrugs(HttpServletRequest request, @RequestBody DrugWM drugWM) throws Exception{
		
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
    	
		List<Drug> drugs = new ArrayList<>();
		List<DrugWM> drugWMs = new ArrayList<>();
		Log4JUtil.logger.info("DRUG,drug_search_request,Request="+drugWM.toString());
		Mapper mapper = new Mapper();
		DrugService service = new DrugService();
		try{
			drugs = service.searchDrugs(drugWM.getTradeName(), drugWM.getGenericName(), drugWM.getCategory()); 
		}catch(Exception exp){
			Log4JUtil.logger.info("DRUG,drug_search_request,Request="+drugWM.toString()+exp.getMessage());
			throw new DrugSaveException();
		}
		if(drugs.size()==0) throw new DrugNotFoundException();
		drugWMs = mapper.mapData(drugs);
		
		return drugWMs;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/verify", method = RequestMethod.POST)
	public boolean verifyDrug(HttpServletRequest request, @RequestBody DrugWM drugWM)throws Exception{
		
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
    	
		boolean hasVerified= false;
		Log4JUtil.logger.info("DRUG,drug_verify_request,Request="+drugWM.toString());
		DrugService service = new DrugService();
		try{
			hasVerified = service.verifyDrug(drugWM.getId());
		}catch(Exception exp){
			Log4JUtil.logger.info("DRUG,drug_verify_request,Request="+drugWM.toString());
			exp.printStackTrace();
		}	
		
		return hasVerified;
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/enable", method= RequestMethod.POST)
	public boolean enableDrug(HttpServletRequest request, @RequestBody DrugWM drugWM) throws Exception {
		
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
    	
		boolean hasEnabled =false;
		Log4JUtil.logger.info("DRUG,drug_enable_request,Request="+drugWM.toString());
		DrugService service = new DrugService();
		try{
			hasEnabled = service.enableDrug(drugWM.getId());
		}catch(Exception exp){
			Log4JUtil.logger.info("DRUG,drug_enable_request,Request="+drugWM.toString());
			exp.printStackTrace();
		}
		
		return hasEnabled;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/disable", method = RequestMethod.POST) 
	public boolean disableDrug(HttpServletRequest request, @RequestBody DrugWM drugWM) throws Exception{
		
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
    	
		boolean hasDisabled = false;
		Log4JUtil.logger.info("DRUG,drug_disable_request,Request="+drugWM.toString());
		DrugService service = new DrugService();
		try{
			hasDisabled = service.disableDrug(drugWM.getId());
		}catch(Exception exp){
			Log4JUtil.logger.info("DRUG,drug_disable_request,Request="+drugWM.toString()); 
			exp.printStackTrace();
		}
		
		return hasDisabled;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/notVerifiedList", method = RequestMethod.POST)
	public List<NotVerifiedDrugsEM> getNotVerifiedDrugs(HttpServletRequest request) throws Exception{
		
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
		Log4JUtil.logger.info("DRUG,drug_not_verified_drugs_request,Request=");
		List<NotVerifiedDrugsEM> notVerifiedDrugsEMs = new ArrayList<>();
		DrugService service = new DrugService();
		try{
			notVerifiedDrugsEMs = service.getNotVerifiedDrugs();
		}catch(Exception exp){
			Log4JUtil.logger.info("DRUG,drug_not_verified_drugs_request,Request="+exp.getMessage()); 
			exp.printStackTrace();
		}
		
		return notVerifiedDrugsEMs;		
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/reject", method = RequestMethod.POST)
	public boolean rejectDrug(HttpServletRequest request, @RequestBody DrugRejectReq req)throws Exception{
		
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
    	
		boolean isRejected =false;
		Log4JUtil.logger.info("DRUG,drug_reject_request,Request=");
		DrugService service  = new DrugService();
		try{
			isRejected = service.rejectDrug(req.getId(), req.getRejectReason());
		}catch(Exception exp){
			Log4JUtil.logger.info("DRUG,drug_reject_request,Request="+exp.getMessage()); 
			exp.printStackTrace();
		}
		
		return isRejected;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/drug/get", method= RequestMethod.POST)
	public DrugWM getDrug(HttpServletRequest request, @RequestBody DrugWM wm) throws Exception{
		
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
    	
		Log4JUtil.logger.info("DRUG,get_drug_request,Request="+wm.toString());
		DrugWM drugWM = new DrugWM();
		Drug drug = new Drug();
		DrugService service = new DrugService();
		Mapper mapper = new Mapper();
		try{
			drug = service.getDrug(wm.getId());
			drugWM = mapper.mapDrug(drug);
		}catch(Exception exp){
			Log4JUtil.logger.info("DRUG,get_drug_request,Request="+exp.getMessage()); 
			exp.printStackTrace();
			throw new DrugNotFoundException();
		}	
		if(drug.getId()==0) throw new DrugNotFoundException();
		
		return drugWM;
	}
	
	}
