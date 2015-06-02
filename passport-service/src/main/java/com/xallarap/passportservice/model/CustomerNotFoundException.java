package com.xallarap.passportservice.model;

/**
 * Simple exception class
 * 
 * @author Mark
 *
 */
public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param id of customer
	 */
	public CustomerNotFoundException(long id) {
		super("No customer with id: " + id);
	}
}
