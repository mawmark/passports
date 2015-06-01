package com.xallarap.passportservice.model;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Customer class.
 * 
 * @author Mark
 *
 */
public class Customer {

	/** Gender */
	public enum Gender {
		MALE, FEMALE;
	}

	private final String firstName;
	private final String lastName;
	private final Date dateOfBirth;
	private final String locationOfBirth;
	private final Gender gender;

	private final Map<String, Passport> passports = new ConcurrentHashMap<String, Passport>();

	/**
	 * Create a new customer.
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @param dateOfBirth date of birth
	 * @param locationOfBirth location of birth
	 * @param gender gender
	 */
	public Customer(String firstName, String lastName, Date dateOfBirth, String locationOfBirth, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.locationOfBirth = locationOfBirth;
		this.gender = gender;
	}

	/**
	 * Add a new passport to our collection.
	 * 
	 * @param passport
	 */
	public void addPassport(Passport passport) {
		passports.put(passport.getNumber(), passport);
	}

	public void deletePassport(String passportNumber) {
		passports.remove(passportNumber);
	}

	/**
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return date of birth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return location of birth
	 */
	public String getLocationOfBirth() {
		return locationOfBirth;
	}

	/**
	 * @return gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @return this customers passports
	 */
	public Collection<Passport> getPassports() {
		return passports.values();
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", locationOfBirth="
				+ locationOfBirth + ", gender=" + gender + ", passports=" + passports + "]";
	}

}
