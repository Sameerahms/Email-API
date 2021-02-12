/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoPatientFoundException extends EPException {
	private static String errorMessage = "No patient found";
	private static int errorCode = EPExceptionCodes.NO_PATIENTS_FOUND;

	public NoPatientFoundException() {
		super(errorMessage, errorCode);
	}
}
