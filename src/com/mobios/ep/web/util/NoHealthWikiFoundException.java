/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoHealthWikiFoundException extends EPException{
	private static String errorMessage = "No health wiki found";
	private static int errorCode = EPExceptionCodes.NO_HEALTH_WIKI_FOUND;

	public NoHealthWikiFoundException() {
		super(errorMessage, errorCode);
	}
}
