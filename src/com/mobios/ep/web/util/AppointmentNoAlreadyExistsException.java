/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class AppointmentNoAlreadyExistsException extends EPException{
	private static String errorMessage = "AppointmentNo already exists";
	private static int errorCode = EPExceptionCodes.APPOINTMENTNO_ALREADY_EXISTS;
	
	public AppointmentNoAlreadyExistsException(){
		super(errorMessage,errorCode);
	}
}
