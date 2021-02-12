/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.MedicalBillHistoryService;
import com.mobios.ep.services.MedicalBillService;
import com.mobios.ep.web.models.MedicalBillWM;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoAppointmentFoundException;
import com.mobios.ep.web.util.NoMedicalBillFoundException;
import com.ombios.ep.entity.model.MedicalBill;

/**
 * @author Nishantha
 *
 */

@Controller
public class MedicalBillController {
	/**
	 * method to save medical bill
	 * @param medicalBillWM
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/medical/bill/save", method = RequestMethod.POST)
	public @ResponseBody int saveMedicalBill(HttpServletRequest request, @RequestBody MedicalBillWM medicalBillWM) throws Exception {
		
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
		Log4JUtil.logger.info("MEDICALBILL,medical_bill_save_request,Request="+medicalBillWM.toString());
		MedicalBillService service = new MedicalBillService();
		Mapper mapper= new Mapper();
		MedicalBill medicalBill = new MedicalBill();
		MedicalBillWM wm = new MedicalBillWM();
		try{
			medicalBill = mapper.mapMedicalBill(medicalBillWM);
			id = service.saveMedicalBill(medicalBill);		
			
			medicalBill=service.getMedicalBillById(id);
			wm=mapper.mapMedicalBill(medicalBill);
			
			Gson gsn=new Gson();
			String json = gsn.toJson(wm); 
			
			MedicalBillHistoryService medicalBillHistoryService=new MedicalBillHistoryService();
			medicalBillHistoryService.saveMedicalBillHistory(json, id, medicalBill.getDoctorId());
			
		}catch(Exception exp){
			Log4JUtil.logger.info("MEDICALBILL,medical_bill_save_request,Request="+medicalBillWM.toString()+","+ exp.getMessage());
			throw new NoMedicalBillFoundException();
		}
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/medical/bill/list", method = RequestMethod.POST)
	public @ResponseBody List<MedicalBillWM> getMedicalBill(HttpServletRequest request, @RequestBody int patientId) throws Exception {
		
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
		Log4JUtil.logger.info("MEDICALBILL,medical_bill_save_request,Request="+patientId);
		MedicalBillService service = new MedicalBillService();
		Mapper mapper= new Mapper();
		List<MedicalBill> medicalBills = new ArrayList<MedicalBill>();
		List<MedicalBillWM> wms = new ArrayList<MedicalBillWM>();
		try{
			medicalBills = service.getMedicalBill(patientId);	
			for (MedicalBill medicalBill : medicalBills) {
				wms.add(mapper.mapMedicalBill(medicalBill));
			}
		}catch(Exception exp){
			Log4JUtil.logger.info("MEDICALBILL,medical_bill_list_request,Request="+patientId+","+ exp.getMessage());
			throw new NoMedicalBillFoundException();
		}
		
		return wms;
	}

}
