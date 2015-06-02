package com.xallarap.passportservice.model;

import static com.xallarap.passportservice.model.Customer.Gender.MALE;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class CustomerAndPassportTest {

	private CustomerCache cache;
	private DateFormat formatter = new SimpleDateFormat("dd-MM-yy");

	@Before
	public void setUp() throws Exception {
		cache = new CustomerCacheImpl();
	}

	@Test
	public void testAddAndGetCustomer() throws ParseException {
		Customer customer = new Customer("mark", "wimpory", formatter.parse("26-10-65"), "farnborough", MALE);
		long id = cache.addCustomer(customer);
		assertThat(id, notNullValue());
		Customer retrieved = cache.getCustomer(id);
		assertThat(customer, equalTo(retrieved));
	}

	@Test
	public void testAddAndGetPassportForCustomer() throws ParseException {
		Customer customer = new Customer("mark", "wimpory", formatter.parse("26-10-65"), "farnborough", MALE);
		Passport passport = new Passport("101", formatter.parse("1-1-2015"));
		customer.addPassport(passport);
		assertThat(customer.getPassports(), hasItem(passport));
	}

	@Test
	public void testAddAndDeletePassportForCustomer() throws ParseException {
		Customer customer = new Customer("mark", "wimpory", formatter.parse("26-10-65"), "farnborough", MALE);
		Passport passport = new Passport("101", formatter.parse("1-1-2015"));
		customer.addPassport(passport);
		assertThat(customer.getPassports(), hasItem(passport));
		customer.deletePassport("101");
		assertThat(customer.getPassports(), not(hasItem(passport)));
	}
}
