package com.mobios.ep.web.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DrugNotFoundException extends EPException{	
	private static String errorMessage = "Drug not found";
	private static int errorCode = EPExceptionCodes.NO_DRUG_FOUND;

	public DrugNotFoundException() {
		super(errorMessage, errorCode);
	}
}
