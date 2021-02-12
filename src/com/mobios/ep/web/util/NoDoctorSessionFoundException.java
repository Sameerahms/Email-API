/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoDoctorSessionFoundException  extends EPException{
	
	private static final long serialVersionUID = -2307214815616446329L;
	private static String errorMessage = "Doctor session not found";
	private static int errorCode = EPExceptionCodes.NO_DOCTOR_SESSION_FOUND;

	public NoDoctorSessionFoundException() {
		super(errorMessage, errorCode);
	}

}
