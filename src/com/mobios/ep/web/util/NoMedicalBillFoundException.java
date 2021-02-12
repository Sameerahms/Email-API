/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoMedicalBillFoundException extends EPException{

	private static final long serialVersionUID = -2307214815616446329L;
	private static String errorMessage = "Medical bill not found";
	private static int errorCode = EPExceptionCodes.NO_MEDICAL_BILL_FOUND;

	public NoMedicalBillFoundException() {
		super(errorMessage, errorCode);
	}

}
