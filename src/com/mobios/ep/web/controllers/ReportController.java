/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.ReportService;
import com.mobios.ep.web.models.DateRangeReq;
import com.mobios.ep.web.models.DrugsAndInvestigationReq;
import com.mobios.ep.web.models.PrescriptionSummaryReq;
import com.ombios.ep.entity.model.DrugsAndInvestigationEM;
import com.ombios.ep.entity.model.MedicineInvestigationUsageReportEM;
import com.ombios.ep.entity.model.PrescriptionSummaryByDoctorEM;
import com.ombios.ep.entity.model.PrescriptionSummaryByInstitutesEM;
import com.ombios.ep.entity.model.PrescriptionSummaryEM;

/**
 * @author Nishantha
 *
 */
@RestController
public class ReportController {
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="report/listDrugsAndInvestigation",method = RequestMethod.POST)
	public List<DrugsAndInvestigationEM> getDrugsAndInvestigation(HttpServletRequest request, @RequestBody DrugsAndInvestigationReq req) throws Exception{
		
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
    	
		List<DrugsAndInvestigationEM> resp = new ArrayList<DrugsAndInvestigationEM>();
		Log4JUtil.logger.info("REPORT,get_drugs_investigation_report_list__request,Request="+req.toString());
		ReportService service = new ReportService();
		try{
			resp = service.getDrugsAndInvestigation(req.getDoctorId(), req.getStartDate(),req.getEndDate());
		}catch(Exception exp){
			Log4JUtil.logger.info("REPORT,get_drugs_investigation_report_list__request,Request="+req.toString()+" , "+ exp.getMessage());
			exp.printStackTrace();
		}
				
		return resp;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="report/prescriptionSummary", method=RequestMethod.POST)
	public List<PrescriptionSummaryEM> getPrescriptionSummary(HttpServletRequest request, @RequestBody DateRangeReq dateRangeReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("REPORT,get_prescription_summary_request,Request="+dateRangeReq.toString());
		List<PrescriptionSummaryEM> prescriptionSummaryEMs = new ArrayList<>();
		ReportService service = new ReportService();
		try{
			prescriptionSummaryEMs = service.getPrescriptionSummary(dateRangeReq.getStartDate(), dateRangeReq.getEndDate());
		}catch(Exception exp){
			Log4JUtil.logger.info("REPORT,get_prescription_summary_request,Request="+dateRangeReq.toString()+" , " +exp.getMessage());
			exp.printStackTrace();
		}
		
		return prescriptionSummaryEMs;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="report/prescriptionSummaryByDoctorId", method=RequestMethod.POST)
	public List<PrescriptionSummaryByDoctorEM> getPrescriptionSummaryByDoctor(HttpServletRequest request, @RequestBody PrescriptionSummaryReq summaryReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("REPORT,get_prescription_summary_by_doctor_request,Request="+summaryReq.toString());
		List<PrescriptionSummaryByDoctorEM> prescriptionSummaryByDoctorEMs = new ArrayList<>();
		ReportService service = new ReportService();
		try {
			prescriptionSummaryByDoctorEMs = service
					.getPrescriptionSummaryByDoctor(summaryReq.getStartDate(),
							summaryReq.getEndDate(), summaryReq.getDoctorId(),
							summaryReq.getInstitutes());
		} catch (Exception exp) {
			Log4JUtil.logger
					.info("REPORT,get_prescription_summary_by_doctor_request,Request="
							+ summaryReq.toString() + " , " + exp.getMessage());
			exp.printStackTrace();
		}
		
		return prescriptionSummaryByDoctorEMs;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/report/prescriptionSummaryByInstitutes", method= RequestMethod.POST)
	public List<PrescriptionSummaryByInstitutesEM> getPrescriptionSummaryByInstitutes(HttpServletRequest request, @RequestBody PrescriptionSummaryReq summaryReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("REPORT,get_prescription_summary_by_institutes_request,Request="+summaryReq.toString());
		List<PrescriptionSummaryByInstitutesEM> prescriptionSummaryByInstitutesEMs = new ArrayList<>();
		ReportService service = new ReportService();
		try {
			prescriptionSummaryByInstitutesEMs = service
					.getPrescriptionSummaryByInstitutes(
							summaryReq.getStartDate(), summaryReq.getEndDate(),
							summaryReq.getInstitutes());
		} catch (Exception exp) {
			Log4JUtil.logger
					.info("REPORT,get_prescription_summary_by_institutes_request,Request="
							+ summaryReq.toString() + " , " + exp.getMessage());
			exp.printStackTrace();
		}	
		
		return prescriptionSummaryByInstitutesEMs;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/report/listdrugTestQuantity", method=RequestMethod.POST)
	public MedicineInvestigationUsageReportEM getMedicalInvestigationUsage(HttpServletRequest request, @RequestBody PrescriptionSummaryReq req) throws Exception{
		
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
    	
		Log4JUtil.logger.info("REPORT,get_medical_investigation_usage_request,Request="+req.toString());
		List<MedicineInvestigationUsageReportEM>  usageReportEMs = new  ArrayList<>();
		MedicineInvestigationUsageReportEM usageReportEM = new MedicineInvestigationUsageReportEM();
		ReportService service= new ReportService();
		try{
			usageReportEM= service.getMedicalInvestigationUsage(req.getDoctorId(), req.getStartDate(), req.getEndDate());
		}catch(Exception exp){
			Log4JUtil.logger.info("REPORT,get_medical_investigation_usage_request,Request="+ req.toString() + " , " + exp.getMessage());
			exp.printStackTrace();
		}
		 
		return usageReportEM;
	}
}
