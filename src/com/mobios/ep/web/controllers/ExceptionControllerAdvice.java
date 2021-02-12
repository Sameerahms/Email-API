/**
 * 
 */
package com.mobios.ep.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.http.ResponseEntity;
import com.mobios.ep.web.util.EPException;
import com.ombios.ep.entity.model.ErrorResponse;
/**
 * Global Exception Handler
 * @author Nishantha
 *
 */
@EnableWebMvc
@ControllerAdvice
public class ExceptionControllerAdvice {	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exception(Exception e){
		
		ErrorResponse error= new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EPException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(EPException ex){	
		
		ErrorResponse error= new ErrorResponse();
		error.setErrorCode(ex.getErrorCode());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}	
	
}

