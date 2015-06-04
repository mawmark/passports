package com.xallarap.passportservice.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xallarap.passportservice.model.Customer;
import com.xallarap.passportservice.model.CustomerCache;
import com.xallarap.passportservice.model.CustomerNotFoundException;
import com.xallarap.passportservice.model.Passport;

/**
 * This class forms the REST service for our application. It uses a cache which
 * is injected.
 * 
 * @author Mark
 *
 */
@RestController
public class PassportController {

	private static final Logger log = LoggerFactory.getLogger(PassportController.class);

	@Autowired
	private CustomerCache cache;

	public PassportController() {
		log.info("Passport controller construction with cache: {}", cache);
	}

	@RequestMapping(value = "/passports", method = RequestMethod.GET)
	public Collection<Passport> getPassports(@RequestParam(value = "customerId") long customerId) throws CustomerNotFoundException {
		log.info("Request for passports with customerId: {}", customerId);
		Customer customer = cache.getCustomer(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException(customerId);
		}
		return customer.getPassportCollection();
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public Collection<Customer> getCustomers() {
		log.info("Request for all customers");
		return cache.getCustomers();
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public long addCustomer(@RequestBody Customer input) {
		log.info("Call to add customer with: {}", input);
		return cache.addCustomer(input);
	}

	@RequestMapping(value = "/passports", method = RequestMethod.POST)
	public void addPassport(@RequestParam(value = "customerId") long customerId, @RequestBody Passport input) throws CustomerNotFoundException {
		log.info("Call to add passport with: {} to: {}", input, customerId);
		Customer customer = cache.getCustomer(customerId);
		if (customer != null) {
			customer.addPassport(input);
			input.setCustomer(customer);
			cache.flush();
		} else {
			throw new CustomerNotFoundException(customerId);
		}
	}

	@RequestMapping(value = "/passports", method = RequestMethod.DELETE)
	public void deletePassport(@RequestParam(value = "customerId") long customerId, @RequestParam String number) throws CustomerNotFoundException {
		log.info("Call to delete passport with: {} from: {}", number, customerId);
		Customer customer = cache.getCustomer(customerId);
		if (customer != null) {
			customer.deletePassport(number);
			cache.flush();
		} else {
			throw new CustomerNotFoundException(customerId);
		}
	}
}
