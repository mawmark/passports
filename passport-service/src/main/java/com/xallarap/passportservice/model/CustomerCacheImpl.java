package com.xallarap.passportservice.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class used to keep the collection of customers.
 * 
 * @author Mark
 *
 */
public class CustomerCacheImpl implements CustomerCache {

	private static final Logger log = LoggerFactory.getLogger(CustomerCacheImpl.class);

	private AtomicLong customerId = new AtomicLong();
	private Map<Long, Customer> customers = new ConcurrentHashMap<Long, Customer>();

	@Override
	public long addCustomer(Customer customer) {
		log.info("Adding new customer: {}", customer);
		long id = customerId.incrementAndGet();
		customers.put(id, customer);
		log.info("Customer: {} added with id: {}", customer, id);
		return id;
	}

	@Override
	public Customer getCustomer(long id) {
		log.info("Request for customer with id: {}", id);
		return customers.get(id);
	}

	@Override
	public Map<Long, Customer> getCustomers() {
		return customers;
	}

}
