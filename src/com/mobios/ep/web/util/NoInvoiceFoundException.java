/**
 * 
 */
package com.mobios.ep.web.util;

/**
 * @author Nishantha
 *
 */
public class NoInvoiceFoundException extends EPException {
	private static String errorMessage = "Invoice not found";
	private static int errorCode = EPExceptionCodes.NO_INVOICE_FOUND;

	public NoInvoiceFoundException() {
		super(errorMessage, errorCode);
	}


}
