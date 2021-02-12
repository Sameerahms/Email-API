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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.DoctorSessionService;
import com.mobios.ep.web.models.SessionReq;
import com.mobios.ep.web.models.SessionResp;
import com.mobios.ep.web.models.SessionSummaryWM;
import com.mobios.ep.web.models.SessionWM;
import com.mobios.ep.web.util.AppointmentNoAlreadyExistsException;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoDoctorSessionFoundException;
import com.mobios.ep.web.util.SessionAlreadyExistsException;
import com.ombios.ep.entity.model.SessionEM;
import com.ombios.ep.entity.model.SessionSummary;

/**
 * @author Nishantha
 *
 */
@RestController
public class DoctorSessionController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/session/list",method= RequestMethod.POST)
	public List<SessionWM> getSessionList(HttpServletRequest request, @RequestBody SessionReq sessionReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("SESSION,session_list_request,Request="+sessionReq.toString());
		List<SessionWM> sessionWMs= new ArrayList<SessionWM>();
		List<SessionEM> sessionEMs= new ArrayList<SessionEM>();
		Mapper mapper = new Mapper();
		DoctorSessionService sessionService= new DoctorSessionService();
		try{
			sessionEMs = sessionService.getSessionList(sessionReq.getInstituteId(),sessionReq.getDoctorId());
		}catch(Exception exp){
			throw new NoDoctorSessionFoundException();
		}
		sessionWMs = mapper.mapSession(sessionEMs);
		if(sessionWMs.size()==0) throw new NoDoctorSessionFoundException();
		
		return sessionWMs;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/session/listByDate", method=RequestMethod.POST)
	public List<SessionWM> getSessionListByDate(HttpServletRequest request, @RequestBody SessionReq sessionReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("SESSION,session_list_bySessionDate_request,Request="+sessionReq.toString());
		List<SessionWM> sessionWMs= new ArrayList<SessionWM>();
		List<SessionEM> sessionEMs= new ArrayList<SessionEM>();
		Mapper mapper = new Mapper();
		DoctorSessionService sessionService= new DoctorSessionService();
		
		try{
			sessionEMs = sessionService.getSessionListByDate(sessionReq.getDoctorId(),sessionReq.getDate(),sessionReq.getInstituteId(),sessionReq.getCount(),sessionReq.getIsSessionList());
		}catch(Exception exp){
			throw new NoDoctorSessionFoundException();
		}
		sessionWMs = mapper.mapSession(sessionEMs);
		if(sessionWMs.size()==0) throw new NoDoctorSessionFoundException();
		
		return sessionWMs;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/session/save",method=RequestMethod.POST )
	public int saveDoctorSession(HttpServletRequest request, @RequestBody SessionReq sessionReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("SESSION,session_save_request,Request="+sessionReq.toString());
		int id=0;
		DoctorSessionService sessionService= new DoctorSessionService();
		Mapper mapper = new Mapper();
		SessionEM sessionEM = mapper.mapSessionSave(sessionReq);
		try{
			id= sessionService.saveDoctorSession(sessionEM);
			
		}catch(Exception exp){
			throw new NoDoctorSessionFoundException();			
		}
		if(id== -1){
			throw new SessionAlreadyExistsException();
		}
				
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/session/delete", method= RequestMethod.POST)
	public boolean deleteSession(HttpServletRequest request, @RequestBody SessionReq sessionReq)throws Exception {
		
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
    	
		Log4JUtil.logger.info("SESSION,session_delete_request,Request="+sessionReq.toString());
		boolean status=false;
		DoctorSessionService sessionService= new DoctorSessionService();
		try{
			status =sessionService.deleteSession(sessionReq.getId());
		}catch(Exception exp){
			throw new NoDoctorSessionFoundException();	
		}
				
		return status;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/session/summary", method=RequestMethod.POST) 
	public SessionSummaryWM getSummary(HttpServletRequest request, @RequestBody SessionReq sessionReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("SESSION_SUMMERY,session_summery_request,Request="+sessionReq.toString());
		SessionSummary summary= new SessionSummary();
		SessionSummaryWM summaryWM=new SessionSummaryWM();
		DoctorSessionService sessionService= new DoctorSessionService();
		Mapper mapper = new Mapper();
		try{
			summary = sessionService.getSummary(sessionReq.getId());
		}catch(Exception exp){
			throw new NoDoctorSessionFoundException();
		}
		summaryWM= mapper.mapSummary(summary);
		
		return summaryWM;
	}
	
	/**
	 * Get doctor session list by using date and doctorId
	 * @param sessionId
	 * @return
	 * @exception Exception
	 */	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="session/listByDateAndDoctorId", method= RequestMethod.POST)
	public List<SessionResp> getSessionListByDateAndDoctorId(HttpServletRequest request, @RequestBody SessionReq sessionReq) throws Exception {
		
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
    	
		Log4JUtil.logger.info("SESSION,get_session_list_by_date&doctorId_request,Request="+sessionReq.toString());
		List<SessionEM> sessionEMs = new ArrayList<SessionEM>();
		List<SessionResp> sessionResps = new ArrayList<SessionResp>();
		Mapper mapper =  new Mapper();
		DoctorSessionService service = new DoctorSessionService();
		try{
			sessionEMs = service.getSessionListByDateAndDoctorId(sessionReq.getDate(), sessionReq.getDoctorId());
		}catch(Exception exp){
			Log4JUtil.logger.info("SESSION,get_session_list_by_date&doctorId_request,Request="+sessionReq.toString() + ": "+exp.getMessage());
			throw new NoDoctorSessionFoundException();			
		}
		sessionResps = mapper.mapSessionResp(sessionEMs);
		if(sessionEMs.size()==0) new NoDoctorSessionFoundException();	
		
		
		return sessionResps;
	}
	
	/**
	 * Get doctor session list by date range
	 * @param startDate
	 * @param endDate
	 * @param doctorId
	 * @return
	 * @exception Exception
	 */	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="session/listByDateRange", method = RequestMethod.POST)
	public List<SessionResp> getSessionSummeryByDate(HttpServletRequest request, @RequestBody SessionReq sessionReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("SESSION,get_session_list_by_date_range_request,Request="+sessionReq.toString());
		List<SessionResp> summeryResps = new ArrayList<SessionResp>();
		List<SessionEM> sessionEMs = new ArrayList<SessionEM>();
		Mapper mapper = new Mapper();
		DoctorSessionService service = new DoctorSessionService();
		try{
			sessionEMs = service.getListByDateRange(sessionReq.getDoctorId(), sessionReq.getStartTime(), sessionReq.getEndTime());
		}catch(Exception exp){
			Log4JUtil.logger.info("SESSION,get_session_list_by_date_range_request,Request="+sessionReq.toString() + ": "+exp.getMessage());
			throw new NoDoctorSessionFoundException();	
		}
		if(sessionEMs.size()==0) new NoDoctorSessionFoundException();	
		summeryResps = mapper.mapSessionResp(sessionEMs);
		
		 return summeryResps;
	}
}
