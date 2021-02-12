package com.mobios.ep.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mobios.ep.web.models.VersionModel;


/**
 * Home controller for basic requests such as application version..etc
 * @author chandimal
 *
 */
@RestController
public class HomeController {
	
	
	/**
	 * Basic index file - server stats
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView index() {		
		return new ModelAndView("index");
	}

	
	/**
	 * Get the version of the application. This will be used to indicate new client version
	 * to be download from the server in case of a upgrade. 
	 * @return
	 */
	@RequestMapping(value="/version")
	public  VersionModel getVersion(){
		return new VersionModel();
	}

}
