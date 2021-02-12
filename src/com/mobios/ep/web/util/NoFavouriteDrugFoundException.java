/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoFavouriteDrugFoundException extends EPException {
	private static final long serialVersionUID = -2307214815616446329L;
	private static String errorMessage = "Favourite drug not found";
	private static int errorCode = EPExceptionCodes.NO_FAVOURITE_DRUG_FOUND;

	public NoFavouriteDrugFoundException() {
		super(errorMessage, errorCode);
	}

}
