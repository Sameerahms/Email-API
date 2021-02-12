/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class SessionAlreadyExistsException extends EPException{
	private static String errorMessage = "Session already exists";
	private static int errorCode = EPExceptionCodes.SESSION_ALREADY_EXISTS;
	
	public SessionAlreadyExistsException(){
		super(errorMessage,errorCode);
	}

}
