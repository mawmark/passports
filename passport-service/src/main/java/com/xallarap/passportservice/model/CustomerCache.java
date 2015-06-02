package com.xallarap.passportservice.model;

import java.util.Map;

/**
 * Interface used to support the REST api providing the features needed.
 * 
 * @author Mark
 *
 */
public interface CustomerCache {

	/**
	 * Add a new customer
	 * 
	 * @param customer new customer
	 * @return the new customer id;
	 */
	public long addCustomer(Customer customer);

	/**
	 * Retrieve a customer.
	 * 
	 * @param id to find
	 * @return customer
	 */
	public Customer getCustomer(long id);

	/**
	 * @return customer map
	 */
	public Map<Long, Customer> getCustomers();
}
