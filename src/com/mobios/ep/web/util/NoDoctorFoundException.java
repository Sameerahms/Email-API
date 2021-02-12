/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Administrator
 *
 */
public class NoDoctorFoundException extends EPException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1640590884996061150L;
	private static String errorMessage = "Doctor not found";
	private static int errorCode = EPExceptionCodes.NO_DOCTOR_FOUND;

	public NoDoctorFoundException() {
		super(errorMessage, errorCode);
	}

}
