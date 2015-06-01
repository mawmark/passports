package com.xallarap.passportservice.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Class used to keep the collection of customers.
 * 
 * @author Mark
 *
 */
public class CustomerCacheImpl implements CustomerCache {

	private AtomicLong customerId = new AtomicLong();
	private Map<Long, Customer> customers = new ConcurrentHashMap<Long, Customer>();

	@Override
	public long addCustomer(Customer customer) {
		long id = customerId.incrementAndGet();
		customers.put(id, customer);
		return id;
	}

	@Override
	public Customer getCustomer(long id) {
		return customers.get(id);
	}

}
