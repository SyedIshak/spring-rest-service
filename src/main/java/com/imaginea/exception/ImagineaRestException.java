package com.imaginea.exception;

/**
 * The Class ImagineaRestException.
 */
public class ImagineaRestException extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new imaginea rest exception.
	 *
	 * @param message the message
	 */
	public ImagineaRestException(String message) {
		super(message);
	}
}
