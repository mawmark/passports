package com.xallarap.passportservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xallarap.passportservice.model.CustomerCache;
import com.xallarap.passportservice.model.CustomerCacheImpl;

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
		CustomerCache cache = new CustomerCacheImpl();
		// Populate the cache
		// TODO add some cache population
		return cache;
	}

}
