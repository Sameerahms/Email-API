/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoTestFoundException extends EPException {
	private static String errorMessage = "No medical test found" ;
	private static  int errorCode = EPExceptionCodes.NO_NEW_MEDICAL_TEST_FOUND;		
	
	public NoTestFoundException() {
		super(errorMessage,errorCode);
	}	
		
}
