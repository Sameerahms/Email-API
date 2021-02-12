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
import com.mobios.ep.services.TemplateService;
import com.mobios.ep.web.models.TemplateWM;
import com.mobios.ep.web.util.EPException;
import com.mobios.ep.web.util.Mapper;
import com.mobios.ep.web.util.NoPrescriptionTemplateFoundException;
import com.ombios.ep.entity.model.Template;
import com.ombios.ep.entity.model.TemplateEM;

/**
 * @author Nishantha
 *
 */
@RestController
public class TemplateController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="template/save", method=RequestMethod.POST)
	public @ResponseBody int savePrescriptionTemplate(HttpServletRequest request, @RequestBody TemplateWM templateWM ) throws Exception{
		
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
		Log4JUtil.logger.info("PRESCRIPTION_TEMPLATE,prescription_template_save,Request="+templateWM.toString());
		TemplateEM  template = new TemplateEM();
		Mapper mapper= new Mapper();
		TemplateService service = new TemplateService();
		template = mapper.mapSaveTemplate(templateWM);
		try{
			id =service.saveTemplate(template);
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION_TEMPLATE,prescription_template_save,Request="+templateWM.toString()+","+ exp.getMessage());
			throw new EPException();
		}					
		
		return id;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="template/list",method= RequestMethod.POST)
	public List<TemplateWM> getPrescriptionTemplateList(HttpServletRequest request, @RequestBody TemplateWM templateWM) throws Exception {
		
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
    	
		List<TemplateWM> templateWMs= new ArrayList<TemplateWM>();
		List<Template> templates= new ArrayList<Template>();
		Log4JUtil.logger.info("PRESCRIPTION_TEMPLATE,prescription_template_get_list,Request="+templateWM.toString());
		Mapper mapper= new Mapper();
		TemplateService service = new TemplateService();
		try{
			templates = service.getTemplateList(templateWM.getDoctorId());
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION_TEMPLATE,prescription_template_get_list,Request="+templateWM.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		templateWMs = mapper.mapTemplateList(templates); 
		if(templateWMs.size()==0) throw new NoPrescriptionTemplateFoundException();
		
		return templateWMs;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="template/delete",method=RequestMethod.POST)
	public @ResponseBody boolean deletePrescriptionTemplate(HttpServletRequest request, @RequestBody TemplateWM templateWM) throws Exception{
		
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
    	
		boolean isDeletedSuccess = false;
		Log4JUtil.logger.info("PRESCRIPTION_TEMPLATE,prescription_template_delete,Request="+templateWM.toString());
		TemplateService service = new TemplateService();
		try{
			isDeletedSuccess = service.deleteTemplate(templateWM.getId());
		}catch(Exception exp){
			Log4JUtil.logger.info("PRESCRIPTION_TEMPLATE,prescription_template_delete,Request="+templateWM.toString()+","+ exp.getMessage());
			throw new EPException();
		}
		
		return isDeletedSuccess;
	}

}
