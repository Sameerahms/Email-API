/**
 * 
 */
package com.mobios.ep.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobios.ep.common.util.AuthTokenValidate;
import com.mobios.ep.common.util.Log4JUtil;
import com.mobios.ep.services.AdvertisementService;
import com.mobios.ep.web.models.AdvertisementResp;
import com.mobios.ep.web.util.Mapper;
import com.ombios.ep.entity.model.AdvertisementInfo;

/**
 * @author Supun Madara
 *
 */
@RestController
public class AdvertisementController {
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/advertisement/getAdvertisements", method= RequestMethod.POST)
	public List<AdvertisementResp> getAdvertisments(HttpServletRequest request) throws Exception {
		Log4JUtil.logger.info("ADVERTISEMENT,get_advertisement_list_request");
		
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
    	
		List<AdvertisementInfo> advertisementInfo = new ArrayList<>();
		List<AdvertisementResp> advertisementResp = new ArrayList<>();
		AdvertisementService service = new AdvertisementService();
		Mapper mapper = new Mapper();		
		try{
			advertisementInfo = service.getAdvertisementList();
			advertisementResp = mapper.mapAdvertisementResp(advertisementInfo);
		}catch(Exception exp){
			Log4JUtil.logger.info("ADVERTISEMENT,get_advertisement_list_request, "+ exp.getMessage());
		}
		
		return advertisementResp;
	}
}
