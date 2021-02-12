/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoDiagnosisFoundException extends EPException{
	private static String errorMessage = "No diagnosis found";
	private static int errorCode = EPExceptionCodes.NO_DIAGNOSIS_FOUND;
	
	public NoDiagnosisFoundException(){ 
		super(errorMessage, errorCode);
	}

}
