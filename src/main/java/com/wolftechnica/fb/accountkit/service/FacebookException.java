package com.wolftechnica.fb.accountkit.service;

/**
 * The FacebookException wraps all checked standard Java exception and enriches
 * them with a custom error code. You can use this code to retrieve localized
 * error messages and to link to our online documentation.
 * 
 * @author Hem Chand
 */
public class FacebookException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7718828512143293558L;

	private FacebookExceptionCodes exceptionCodes;

	public FacebookException() {
		super();

	}

	public FacebookException(FacebookExceptionCodes exceptionCodes) {
		super();
		this.setExceptionCodes(exceptionCodes);
	} 

	public FacebookExceptionCodes getExceptionCodes() {
		return exceptionCodes;
	}

	public void setExceptionCodes(FacebookExceptionCodes exceptionCodes) {
		this.exceptionCodes = exceptionCodes;
	}

}
