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
import com.mobios.ep.services.StatsService;
import com.mobios.ep.web.models.StatsWM;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoAppointmentFoundException;
import com.mobios.ep.web.util.NoMedicalStatsFoundException;
import com.ombios.ep.entity.model.Stats;

/**
 * Controller for requests with regards to stats 
 * @author Nishantha
 *
 */
@RestController
public class StatsController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="stats/save", method= RequestMethod.POST)
	public int saveStats(HttpServletRequest request, @RequestBody StatsWM statsWM) throws Exception{
		
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
		Log4JUtil.logger.info("STATS,stats_save_request,Request="+statsWM.toString());
		Mapper mapper = new Mapper();
		Stats stats = mapper.mapSaveStats(statsWM);		
		StatsService statsService= new StatsService();
		try{
			id= statsService.saveStats(stats);
		}catch(Exception exp){
			Log4JUtil.logger.info("STATS,stats_save_request,Request="+statsWM.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		return id;		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="stats/list",method=RequestMethod.POST)
	public List<StatsWM> getStatsList(HttpServletRequest request, @RequestBody StatsWM statsWM) throws Exception{
		
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
    	
		List<StatsWM> statsWMs= new ArrayList<>();
		List<Stats> stats = new ArrayList<>();
		Log4JUtil.logger.info("STATS,stats_get_list_request,Request="+statsWM.getId());
		Mapper mapper=new Mapper();
		StatsService statsService= new StatsService();
		try{
			stats = statsService.getStatsList(statsWM.getPatientId());
		}catch(Exception exp){
			Log4JUtil.logger.info("STATS,stats_get_list_request,Request="+statsWM.toString()+","+ exp.getMessage());
			throw new EPException();
		}	
		if(stats.size()==0) throw new NoMedicalStatsFoundException();	
		statsWMs =mapper.mapStatsList(stats);
		
		return statsWMs;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="stats/get", method= RequestMethod.POST)
	public StatsWM getStats(HttpServletRequest request, @RequestBody StatsWM statsWM ) throws Exception{
		
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
    	
		StatsWM wm = new StatsWM();
		Stats stats = new Stats();
		Log4JUtil.logger.info("STATS,stats_get_request,Request="+statsWM.getId());
		Mapper mapper = new Mapper();
		StatsService statsService= new StatsService();
		try{
			stats = statsService.getStats(statsWM.getPatientId());
		}catch(Exception exp){
			Log4JUtil.logger.info("STATS,stats_get_request,Request="+statsWM.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		if(stats.getId()==0) throw new NoMedicalStatsFoundException();	
		wm= mapper.mapStats(stats);
		
		return wm;
	}
}
