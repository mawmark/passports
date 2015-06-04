package com.xallarap.passportservice;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xallarap.passportservice.model.CustomerCache;
import com.xallarap.passportservice.model.CustomerCacheSqlImpl;

/**
 * Boot application class
 * 
 * @author Mark
 *
 */
@SpringBootApplication
@Configuration
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	/**
	 * Start up
	 * 
	 * @param args to pass
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CustomerCache customerCache() {
		// Create an empty cache
		log.info("Creating customer cache");
		CustomerCache cache = new CustomerCacheSqlImpl();
		return cache;
	}

	@Bean
	public SessionFactory sessionFactory() {
		log.info("Creating hibernate session factory");
		return new org.hibernate.cfg.Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
	}
}
