package com.travelfed.travelsdk;

/**
 * Travel SDK exception class. Contains errorCode for the reason of throwing exception.
 * 
 * @author krumstoilov
 *
 */
public class TravelSDKException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;

	public TravelSDKException(String errorCode) {
		super("Travel SDK error code: " + errorCode);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	protected void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
