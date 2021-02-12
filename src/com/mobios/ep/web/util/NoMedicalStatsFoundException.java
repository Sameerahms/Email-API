/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoMedicalStatsFoundException extends EPException{
	
	private static final long serialVersionUID = -2307214815616446329L;
	private static String errorMessage = "Medical stats not found";
	private static int errorCode = EPExceptionCodes.NO_MEDICAL_STATS_FOUND;

	public NoMedicalStatsFoundException() {
		super(errorMessage, errorCode);
	}

}
