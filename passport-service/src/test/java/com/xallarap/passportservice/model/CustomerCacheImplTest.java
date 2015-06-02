package com.xallarap.passportservice.model;

import static com.xallarap.passportservice.model.Customer.Gender.MALE;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class CustomerCacheImplTest {

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

}
