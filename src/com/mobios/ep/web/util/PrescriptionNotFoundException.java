package com.mobios.ep.web.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Prescription is not found")
public class PrescriptionNotFoundException extends EPException {
	
	private static String errorMessage = "Prescription not found" ;
	private static  int errorCode = EPExceptionCodes.NO_PRESCRIPTION_FOUND;		
	
	public PrescriptionNotFoundException() {
		super(errorMessage,errorCode);
	}	
}
