package com.mobios.ep.web.controllers;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mobios.ep.services.PrescriptionHistoryService;
import com.mobios.ep.services.PrescriptionImageService;
import com.mobios.ep.services.PrescriptionService;
import com.mobios.ep.web.models.Patient;
import com.mobios.ep.web.models.PatientByNicOrMoblieReq;
import com.mobios.ep.web.models.PatientReq;
import com.mobios.ep.web.models.PrescSaveResponseWM;
import com.mobios.ep.web.models.Prescription;
import com.mobios.ep.web.models.PrescriptionList;
import com.mobios.ep.web.models.PrescriptionListByNicMobileReq;
import com.mobios.ep.web.models.PrescriptionReq;
import com.mobios.ep.web.models.PrescriptionResp;
import com.mobios.ep.web.models.PrescriptionImage;
import com.mobios.ep.web.util.AppointmentNoAlreadyExistsException;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.PrescriptionNotFoundException;
import com.ombios.ep.entity.model.PrescriptionEM;
import com.ombios.ep.entity.model.PrescriptionHistory;
import com.ombios.ep.entity.model.PrescriptionImageEM;
import com.ombios.ep.entity.model.PrescriptionInfoEM;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;

/**
 * Controller for requests such as save/update prescription etc...
 * 
 * @author hasithakaushan
 *
 */
@RestController
public class PrescriptionController {

	/**
	 * 
	 * saves the prescription
	 * 
	 * @param prescription
	 * @throws Exception
	 * 
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/prescription/save", method = RequestMethod.POST)
	public @ResponseBody int save(HttpServletRequest request, @RequestBody Prescription prescription) throws Exception {
		
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
    	
    	
//        ObjectMapper map = new ObjectMapper();
//        
//        String json = map.writeValueAsString(prescription);
//        
//        
//        System.out.println("ResultingJSONstring = " + json);
    	

    	
		Log4JUtil.logger.info("PRESCRIPTION,prescription_save_request,Request="+prescription.toString());
		
		System.out.println(prescription.getPatient().getPassportNo());
		
		int id=0;	
	
		Mapper mapper = new Mapper();
		PrescriptionEM mappedPrescription = mapper.mapPrescription(prescription);
		
    	Gson gson = new Gson();
    	String json = gson.toJson(mappedPrescription); 
    	System.out.println("ResultingJSONstring = " + json);

		PrescriptionService ps = new PrescriptionService();
		PrescriptionHistoryService phs = new PrescriptionHistoryService();
		try{
			id =ps.savePrescription(mappedPrescription, prescription.getSessionId(), prescription.getsendSMS(), prescription.isSendEmail()
					, prescription.getDoctor().getFirstName()+" "+prescription.getDoctor().getLastName()
					, prescription.getDoctor().getInfo().getQualifications());
			
			//id1 = phs.savePrescriptionHistory(ph);
			
			PrescriptionInfoEM prescriptionInfoEM =null;
			prescriptionInfoEM = ps.getPrescription(id);
			Prescription pres = mapper.mapRetrievedPrescription(prescriptionInfoEM);
			
			Gson gsn=new Gson();
			json = gsn.toJson(pres); 
	    	System.out.println("ResultingJSONstring out = " + json);
			
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now)); // 2016/11/16 12:08:43
			String dateTime = dtf.format(now).toString();
			
	    	PrescriptionHistoryService prescriptionHistoryService=new PrescriptionHistoryService();
			//PrescriptionHistory
			PrescriptionHistory prescriptionHistory=new PrescriptionHistory();
			prescriptionHistory.setPrescription(json);
			prescriptionHistory.setPrescriptionId(id);
			prescriptionHistory.setCreatedDate(dateTime);
			prescriptionHistory.setUserCreated(pres.getDoctor().getId());
			
			prescriptionHistoryService.savePrescriptionHistory(prescriptionHistory);
			
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION,prescription_save_request,Request="+prescription.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(id==-1){
			throw new AppointmentNoAlreadyExistsException();
		}
		return id;
	}

	/**
	 * 
	 * retrieves a prescription
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/prescription/get", method = RequestMethod.POST)
	public Prescription retreive(HttpServletRequest _request, @RequestBody Prescription request) throws Exception {
		
    	String authKey = _request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
    	
		Log4JUtil.logger.info("PRESCRIPTION,prescription_get_request,Request="+request.toString());

		PrescriptionService ps = new PrescriptionService();
		Mapper mapper = new Mapper();
		PrescriptionInfoEM prescriptionInfoEM =null;
		try{
			 prescriptionInfoEM = ps.getPrescription(request.getId());
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION,prescription_get_request,Request="+request.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(prescriptionInfoEM == null) throw new PrescriptionNotFoundException();
		Prescription prescription = mapper.mapRetrievedPrescription(prescriptionInfoEM);
		
		return prescription;

	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/prescription/getByUuid", method = RequestMethod.POST)
	public Prescription retriveByUuid(HttpServletRequest _request, @RequestBody Prescription request) throws Exception{
		
    	String authKey = _request.getHeader("Auth-Key");
    	System.out.println("Auth Key ===> "+authKey);
    
    	AuthTokenValidate authTokenValidate = new AuthTokenValidate();
    	com.mobios.ep.common.util.AuthToken isValid = authTokenValidate.TokenValidate(authKey);
    	
    	System.out.println(isValid.getUsername());
    	System.out.println(isValid.getToken());
    	
    	if(isValid.getToken().equals("false")) {
    		System.out.println("12345");
    		throw new Exception("token invalid");
    	}
    	
		Log4JUtil.logger.info("PRESCRIPTION,prescription_getByUUID_request,Request="+request.toString());
		PrescriptionService ps = new PrescriptionService();
		Mapper mapper = new Mapper();
		PrescriptionInfoEM prescriptionInfoEM =null;
		try{
			 prescriptionInfoEM = ps.getPrescriptionByUuid(request.getUuid());
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION,prescription_getByUuid_request,Request="+request.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(prescriptionInfoEM.getId() == 0) throw new PrescriptionNotFoundException();
		Prescription prescription = mapper.mapRetrievedPrescriptionByUuid(prescriptionInfoEM);
		
		return prescription;
	}
		
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/prescription/listByMobileNo", method = RequestMethod.POST)
	public List<Prescription> retreiveList(HttpServletRequest request, @RequestBody PrescriptionReq prescriptionReq) throws Exception {
		
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
    	
		Log4JUtil.logger.info("PRESCRIPTION,prescription_list_request,Request="+prescriptionReq.toString());
		PrescriptionService ps = new PrescriptionService();
		List<PrescriptionInfoEM> prescriptionInfoEMs = new ArrayList<PrescriptionInfoEM>();
		List<Prescription> prescriptions = new ArrayList<Prescription>();
		Mapper mapper = new Mapper();
		try{
			prescriptionInfoEMs = ps.getPrescriptionList(prescriptionReq.getMobileNo());
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION,prescription_list_request,Request="+prescriptionReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(prescriptionInfoEMs.size() == 0) throw new PrescriptionNotFoundException();
		prescriptions = mapper.mapPrescriptionList(prescriptionInfoEMs);
		
		return prescriptions;
	}
	

	/**
	 * 
	 * Controller for retrieving last prescription
	 * 
	 * @param patient
	 * @return
	 * @throws Exception 
	 */
	
	@CrossOrigin(origins = "*")
	@Transactional
	@RequestMapping(value = "/prescription/getLast", method = RequestMethod.POST)
	public Prescription getLastPrescription(HttpServletRequest request, @RequestBody PatientReq patientReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("PRESCRIPTION,prescription_getLast_request,Request="+patientReq.toString());
		PrescriptionService prescriptionService = new PrescriptionService();
		Mapper mapper = new Mapper();
		PrescriptionInfoEM prescriptionInfoEM =null;
		try{
			 prescriptionInfoEM = prescriptionService.getLastPrescription(patientReq.getPatientId());
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION,prescription_getLast_request,Request="+patientReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(prescriptionInfoEM == null) throw new PrescriptionNotFoundException();
		Prescription prescription = mapper.mapRetrievedPrescription(prescriptionInfoEM);
		
		return prescription;
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/prescription/listByPatientId", method = RequestMethod.POST)
	public List<Prescription> retreiveListByPatientId(HttpServletRequest request, @RequestBody PatientReq patientReq) throws Exception {
		
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
    	
		Log4JUtil.logger.info("PRESCRIPTION,prescription_list_request,Request="+patientReq.toString());
		PrescriptionService ps = new PrescriptionService();
		List<PrescriptionInfoEM> prescriptionInfoEMs = new ArrayList<PrescriptionInfoEM>();
		List<Prescription> prescriptions = new ArrayList<Prescription>();
		Mapper mapper = new Mapper();
		try{
			prescriptionInfoEMs = ps.getPrescriptionByPatientId(patientReq.getPatientId());
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION,prescription_list_request,Request="+patientReq.toString()+","+ exp.getMessage());
			throw new PrescriptionNotFoundException();
		}
		if(prescriptionInfoEMs.size()==0) throw new PrescriptionNotFoundException();
		prescriptions = mapper.mapPrescriptionList(prescriptionInfoEMs);
		
		return prescriptions;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/prescription/getByNicOrMobile", method = RequestMethod.POST)
	public Prescription getPrescriptionByMobileOrNIC(HttpServletRequest request, @RequestBody PatientByNicOrMoblieReq req) throws JsonParseException, Exception{
		
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
    	
		Log4JUtil.logger.info("PRESCRIPTION,prescription_get_by_NIC_or_mobile_request,Request="+req.toString());
		Prescription prescription  = new Prescription();
		PrescriptionInfoEM prescriptionInfoEM = new PrescriptionInfoEM();		
		PrescriptionService ps = new PrescriptionService();
		Mapper mapper = new Mapper();
		try {
			prescriptionInfoEM = ps.getPrescriptionByMobileOrNIC(req.getInstituteId(), req.getNic(), req.getMobile());
		} catch (Exception exp) {
			Log4JUtil.logger
					.info("PRESCRIPTION,prescription_get_by_NIC_or_mobile_request,Request="
							+ req.toString() + "," + exp.getMessage());
			throw new PrescriptionNotFoundException();
		}
		if(prescriptionInfoEM.getId()==0 ) throw new PrescriptionNotFoundException();
		prescription = mapper.mapRetrievedPrescription(prescriptionInfoEM);
		
		return prescription;
		
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/prescription/listByNicMobile", method = RequestMethod.POST)
	public List<PrescriptionResp> getPrescriptionlistByNicMobile(HttpServletRequest request, @RequestBody PrescriptionListByNicMobileReq req) throws JsonParseException, Exception{
		
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
    	
		List<PrescriptionResp> prescriptionResps = new ArrayList<>();
		Log4JUtil.logger.info("PRESCRIPTION,get_prescription_list_by_NIC_or_mobile_request,Request="+req.toString());
		List<PrescriptionInfoEM> prescriptionInfoEMs = new ArrayList<>();
		HashMap<PrescriptionInfoEM, Boolean> mapPresc = new HashMap<>();
		PrescriptionService service = new PrescriptionService();
		Mapper mapper= new Mapper();
		try{
			mapPresc = service.getPrescriptionlistByNicMobile(req.getInstituteId(), req.getNic(), req.getMobile(), req.getDate());
			prescriptionResps = mapper.mapPrescriptionRespList(mapPresc);
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION,get_prescription_list_by_NIC_or_mobile_request,Request="+ req.toString() + "," + exp.getMessage());
			throw new PrescriptionNotFoundException();
		}
		if(prescriptionResps.size()==0) throw new PrescriptionNotFoundException();
				
		return prescriptionResps;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/prescription/images", method = RequestMethod.POST)
	public List<PrescriptionImage> getImages(HttpServletRequest request, @RequestBody PrescriptionImage patiant) throws JsonParseException, Exception{
		
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
		
		List<PrescriptionImage> images = new ArrayList<>();
		Log4JUtil.logger.info("PRESCRIPTION,getImages,Request="+patiant.getPatientId());
		System.out.println(""+patiant.getPatientId());
		int id =patiant.getPatientId();
		List<PrescriptionImageEM> dbImages = new ArrayList<>();
		PrescriptionImageService service = new PrescriptionImageService();
		Mapper mapper= new Mapper();
		try{
			dbImages = service.get(patiant.getPatientId());
			images = mapper.mapPrescriptionImageEM(dbImages);
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION,getImages,Request="+ patiant.getPatientId() + "," + exp.getMessage());
			throw new PrescriptionNotFoundException();
		}
		if(images.size()==0) throw new PrescriptionNotFoundException();
				
		return images;
	}
}
