/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class UserInfoNotFoundException extends EPException{
	private static String errorMessage = "UserInfo not found";
	private static int errorCode = EPExceptionCodes.NO_USERINFO_FOUND;

	public UserInfoNotFoundException() {
		super(errorMessage, errorCode);
	}

}
