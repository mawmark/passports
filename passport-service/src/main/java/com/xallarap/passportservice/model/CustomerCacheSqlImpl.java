package com.xallarap.passportservice.model;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class used to keep the collection of customers in database using hibernate.
 * 
 * @author Mark
 *
 */
public class CustomerCacheSqlImpl implements CustomerCache {

	private static final Logger log = LoggerFactory.getLogger(CustomerCacheSqlImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long addCustomer(Customer customer) {
		log.info("Adding new customer: {}", customer);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		log.info("Customer: {} added with id: {}", customer, customer.getId());
		return customer.getId();
	}

	@Override
	public Customer getCustomer(long id) {
		log.info("Request for customer with id: {}", id);
		Session session = sessionFactory.getCurrentSession();
		log.info(session.getTenantIdentifier());
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Customer> result = session.createQuery("from Customer").list();
		session.getTransaction().commit();
		return result;
	}

	@Override
	public void flush() {
		Session session = sessionFactory.getCurrentSession();
		log.info(session.getTenantIdentifier());
		session.flush();
		session.getTransaction().commit();
	}

}
