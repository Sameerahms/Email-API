/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class EPException extends Exception{
	
	private static final long serialVersionUID= 100L;
	
	private String errorMessage;
	private int errorCode;

	public String getErrorMessage() {
		return errorMessage;
	}
	public int getErrorCode(){
		return errorCode;
	}
	public EPException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public EPException(String errorMessage, int errorCode) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode=errorCode;
	}
	public EPException() {
		super();
	}


}
