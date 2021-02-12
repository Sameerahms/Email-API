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
import com.mobios.ep.services.FavouriteDrugService;
import com.mobios.ep.web.models.FavouriteDrugWM;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoFavouriteDrugFoundException;
import com.ombios.ep.entity.model.FavouriteDrugEM;

/**
 * Controller containing services for adding, removing drugs to doctor's favourite list
 * @author Nishantha
 *
 */
@RestController
public class FavouriteDrugController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="favouriteList/save", method= RequestMethod.POST)
	public @ResponseBody int addDrugToFavourite(HttpServletRequest request, @RequestBody FavouriteDrugWM favouriteDrugWM) throws Exception {
		
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
		Log4JUtil.logger.info("FAVOURITE_LIST,favourite_list_save,Request="+favouriteDrugWM.toString());		
		FavouriteDrugEM favouriteDrugEM = new FavouriteDrugEM();
		Mapper mapper= new Mapper();
		FavouriteDrugService service = new FavouriteDrugService();
		favouriteDrugEM = mapper.mapAddDrugToFav(favouriteDrugWM);		
		try{
			id = service.addDrugToFavourite(favouriteDrugEM);
			
		}catch(Exception exp){
			Log4JUtil.logger.info("FAVOURITE_LIST,favourite_list_save,Request="+favouriteDrugWM.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="favouriteList/list",method=RequestMethod.POST) 
	public @ResponseBody List<Integer> getFavouriteDrugList(HttpServletRequest request, @RequestBody FavouriteDrugWM favouriteDrugWM)throws Exception {
		
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
    	
		List<Integer> favouriteDrugs = new ArrayList<Integer>();
		Log4JUtil.logger.info("FAVOURITE_LIST,favourite_get_list,Request="+favouriteDrugWM.toString());
		FavouriteDrugService service = new FavouriteDrugService();
		try{
			favouriteDrugs = service.getFavouriteDrugList(favouriteDrugWM.getDoctorId());
		}catch(Exception exp){
			Log4JUtil.logger.info("FAVOURITE_LIST,favourite_get_list,Request="+favouriteDrugWM.toString()+","+ exp.getMessage());			
		}
		if(favouriteDrugs.size()==0) throw new NoFavouriteDrugFoundException();
		
		
		return favouriteDrugs;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="favouriteList/delete",method=RequestMethod.POST) 
	public boolean removeDrugFromFavourite(HttpServletRequest request, @RequestBody FavouriteDrugWM favouriteDrugWM) throws Exception{
		
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
    	
		boolean isDeletedSuccess=false;
		Log4JUtil.logger.info("FAVOURITE_LIST,favourite_list_delete,Request="+favouriteDrugWM.toString());
		FavouriteDrugService service = new FavouriteDrugService();
		try{
			isDeletedSuccess = service.removeDrugFromFavourite(favouriteDrugWM.getDrugId(),favouriteDrugWM.getDoctorId());
		}catch(Exception exp){
			Log4JUtil.logger.info("FAVOURITE_LIST,favourite_list_delete,Request="+favouriteDrugWM.toString()+","+ exp.getMessage());
		}
		
		return isDeletedSuccess;
	}

}
