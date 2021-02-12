package com.mobios.ep.web.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class MedicalStatNotFoundException extends EPException {
	private static String errorMessage = "No medical history found";
	private static int errorCode = EPExceptionCodes.NO_MEDICAL_HISTORY_FOUND;

	public MedicalStatNotFoundException() {
		super(errorMessage, errorCode);
	}
}
