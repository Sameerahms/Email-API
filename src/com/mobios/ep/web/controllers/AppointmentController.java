package com.mobios.ep.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.AppointmentService;
import com.mobios.ep.services.StatsService;
import com.mobios.ep.web.models.AppoinmentWM;
import com.mobios.ep.web.models.AppointmentReq;
import com.mobios.ep.web.models.AppointmentStats;
import com.mobios.ep.web.models.Info;
import com.mobios.ep.web.util.AppointmentNoAlreadyExistsException;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoAppointmentFoundException;
import com.ombios.ep.entity.model.Appointment;
import com.ombios.ep.entity.model.Stats;


/**
 * 
 * Controller for requests with regards to appointments 
 * @author hasithakaushan
 *
 */
@RestController
@ComponentScan({"com.mobios.ep.services","com.ombios.ep.entity.factory"})
public class AppointmentController {
	/*@Autowired 
	private SessionFactory SessionFactory;
	@Autowired
	private AppointmentService service;*/
	@CrossOrigin(origins = "*")
	@RequestMapping(value="appointment/get", method=RequestMethod.POST)
	public AppoinmentWM getApointmentById(HttpServletRequest request, @RequestBody AppointmentReq appointment) throws Exception{
		
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
    	
		System.out.println(appointment.getDoctorId());
		Log4JUtil.logger.info("APPOINTMENT,appointment_get_request,Request="+appointment.toString());
		AppointmentService appoinmentService = new AppointmentService();
		StatsService statsService = new StatsService();
		Stats stats = new Stats();
		Mapper mapper = new Mapper();
		Appointment appointmentEM = new Appointment();
		AppoinmentWM gotAppointment = null;
		try{
			appointmentEM = appoinmentService.getAppoinmentById(appointment.getDoctorId(),appointment.getInstituteId(),appointment.getNoOfAppointment(),appointment.getSessionId());
			stats = statsService.getStats(appointmentEM.getPatient().getId());
			gotAppointment = mapper.mapAppointment(appointmentEM, stats);
			
		}catch(Exception exp){
			Log4JUtil.logger.info("APPOINTMENT,appointment_get_request,Request="+appointment.toString()+","+ exp.getMessage());
			throw new NoAppointmentFoundException();
		}
		//if(gotAppointment.getId()==0) throw new NoAppointmentFoundException();
		
		return gotAppointment; 
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="appointment/getLast",method= RequestMethod.POST)
	public int getLastAppointment(HttpServletRequest request, @RequestBody AppointmentReq appointment) throws Exception{
		
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
    	
		Log4JUtil.logger.info("APPOINTMENT,appointment_get_last_request,Request="+appointment.toString());
		AppointmentService appointmentService= new AppointmentService();
		StatsService statsService = new StatsService();
		Stats stats = new Stats();
		Mapper mapper=new Mapper();
		Appointment appointmentEM = new Appointment();
		AppoinmentWM appoinmentWM=null;
		try{
			appointmentEM = appointmentService.getLastAppointment(appointment.getDoctorId(), appointment.getInstituteId(), appointment.getAppointmentDate(), appointment.getNoOfAppointment(),appointment.getSessionId());
			stats = statsService.getStats(appointmentEM.getPatient().getId());
			appoinmentWM = mapper.mapAppointment(appointmentEM, stats);
		}catch(Exception exp){
			Log4JUtil.logger.info("APPOINTMENT,appointment_get_last_request,Request="+appointment.toString()+","+ exp.getMessage());
			throw new NoAppointmentFoundException();			
		}
		if(appoinmentWM.getId()==0) throw new NoAppointmentFoundException();
		
		return appoinmentWM.getAppointmentNo();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="appointment/list",method = RequestMethod.POST)
	public List<AppoinmentWM> getAppointmentList(HttpServletRequest request, @RequestBody AppointmentReq appointmentReq) throws Exception{
		
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
    	
		Log4JUtil.logger.info("APPOINTMENT,appointment_list_request,Request="+appointmentReq.toString());
		List<AppoinmentWM> appoinmentWMs = new ArrayList<AppoinmentWM>();
		List<Appointment> appoinments= new ArrayList<Appointment>();
		List<Stats> stats = new ArrayList<>();
		AppointmentService appointmentService= new AppointmentService();
		StatsService statsService = new StatsService();		
		Mapper mapper=new Mapper();		
		try{			
			appoinments = appointmentService.getAppointmentList(appointmentReq.getDoctorId(),appointmentReq.getInstituteId(),appointmentReq.getSessionId());
			for(Appointment a: appoinments){
				Stats s = new Stats();
				s = statsService.getStats(a.getPatient().getId());
				stats.add(s);					
			}
		}catch(Exception exp){
			Log4JUtil.logger.info("APPOINTMENT,appointment_get_list_request,Request="+appointmentReq.toString()+","+ exp.getMessage());
			throw new NoAppointmentFoundException();
		}
		if(appoinments.size()==0) throw new NoAppointmentFoundException();		
		appoinmentWMs = mapper.mapAppointmentList(appoinments, stats);
		
				
		return appoinmentWMs;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="appointment/save", method= RequestMethod.POST)
	public @ResponseBody int saveAppointment(HttpServletRequest request, @RequestBody AppointmentReq appointmentReq) throws Exception{
		
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
		Log4JUtil.logger.info("APPOINTMENT,appointment_save_request,Request="+appointmentReq.toString());
		Mapper mapper = new Mapper(); 
		Appointment appointment= mapper.mapSaveAppointment(appointmentReq);
		Stats stats = new Stats();
		AppointmentStats appointmentStats = new AppointmentStats();
		
		AppointmentService appointmentService = new AppointmentService();
		try{
			appointmentStats = appointmentReq.getStats();
			stats = mapper.mapStatReq(appointmentStats);
			id = appointmentService.saveAppointment(appointment, stats, appointmentReq.getSessionId());
		}
		catch(Exception exp){
			Log4JUtil.logger.info("APPOINTMENT,appointment_save_request,Request="+appointmentReq.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(id== -1){
			throw new AppointmentNoAlreadyExistsException();
		}
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="appointment/getNext", method=RequestMethod.POST)
	public AppoinmentWM getNextAppointment(HttpServletRequest request, @RequestBody AppointmentReq appointmentReq) throws Exception{
		
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
    	
		AppoinmentWM wm = new AppoinmentWM();
		Log4JUtil.logger.info("APPOINTMENT,appointment_get_next,Request="+appointmentReq.toString());
		Mapper mapper= new Mapper();
		AppointmentService service= new AppointmentService();
		StatsService statsService = new StatsService();
		Stats stats = new Stats();
		Appointment appointmentEM = new Appointment();		
		try{
			appointmentEM = service.getNextAppointment(appointmentReq.getDoctorId(),appointmentReq.getInstituteId(),appointmentReq.getNoOfAppointment(),appointmentReq.getSessionId());
			stats = statsService.getStats(appointmentEM.getPatient().getId());
			wm = mapper.mapAppointment(appointmentEM, stats);
		}catch(Exception exp){
			Log4JUtil.logger.info("APPOINTMENT,appointment_get_next,Request="+appointmentReq.toString()+","+ exp.getMessage());
			throw new NoAppointmentFoundException();
		}
		if(wm.getId()==0) throw new NoAppointmentFoundException();
		
		return wm;
	}

}
