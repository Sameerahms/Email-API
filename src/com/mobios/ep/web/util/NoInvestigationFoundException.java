/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoInvestigationFoundException extends EPException {
	private static String errorMessage = "No investigation found";
	private static int errorCode = EPExceptionCodes.NO_INVESTIGATION_FOUND;

	public NoInvestigationFoundException() {
		super(errorMessage, errorCode);
	}
}
