package com.imaginea.utils;

import java.util.List;

import com.imaginea.exception.VerifyException;

/**
 * The Class Verifier.
 */
public class Verifier {

	/**
	 * Verify null.
	 *
	 * @param object the object
	 * @param message the message
	 */
	public static void verifyNull(Object object, String message) {
		if (object == null) {
			throw new VerifyException(message);
		}
	}
	
	/**
	 * Verify empty collection.
	 *
	 * @param collection the collection
	 * @param message the message
	 */
	public static void verifyEmptyCollection(List<?> collection,String message) {
		if(collection.isEmpty()) {
			throw new VerifyException(message);
		}
	}

}
