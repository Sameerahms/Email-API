/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoInstituteFoundException extends EPException {
	private static String errorMessage = "Institute not found";
	private static int errorCode = EPExceptionCodes.NO_INSTITUTE_FOUND;

	public NoInstituteFoundException() {
		super(errorMessage, errorCode);
	}
}
