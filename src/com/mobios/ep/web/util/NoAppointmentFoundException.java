package com.mobios.ep.web.util;

public class NoAppointmentFoundException extends EPException {
	private static String errorMessage = "No appointment found";
	private static int errorCode = EPExceptionCodes.NO_APPOINTMENT_FOUND;
	
	public NoAppointmentFoundException(){ 
		super(errorMessage, errorCode);
	}
}