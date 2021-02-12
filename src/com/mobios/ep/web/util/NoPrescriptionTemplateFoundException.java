/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoPrescriptionTemplateFoundException  extends EPException{
	private static final long serialVersionUID = -2307214815616446329L;
	private static String errorMessage = "Prescription template not found";
	private static int errorCode = EPExceptionCodes.NO_PRESCRIPTION_TEMPLATE_FOUND;

	public NoPrescriptionTemplateFoundException() {
		super(errorMessage, errorCode);
	}

}
