package com.xallarap.passportservice.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Customer class.
 * 
 * @author Mark
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	/** Gender */
	public enum Gender {
		MALE, FEMALE;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "FIRST")
	private String firstName;
	@Column(name = "LAST")
	private String lastName;
	@Column(name = "DOB")
	private Date dateOfBirth;
	@Column(name = "LOB")
	private String locationOfBirth;
	@Column(name = "GENDER")
	private Gender gender;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	@MapKey(name = "number")
	private Map<String, Passport> passports = new HashMap<String, Passport>();

	/**
	 * Create a new customer.
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @param dateOfBirth date of birth
	 * @param locationOfBirth location of birth
	 * @param gender gender
	 */
	@JsonCreator
	public Customer(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
			@JsonProperty("dateOfBirth") Date dateOfBirth, @JsonProperty("locationOfBirth") String locationOfBirth,
			@JsonProperty("gender") Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.locationOfBirth = locationOfBirth;
		this.gender = gender;
	}

	/**
	 * Empty constructor used for persistence
	 */
	public Customer() {
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
	 * @return customer id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id new id
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @param firstName first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param dateOfBirth date of birth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @param locationOfBirth location of birth
	 */
	public void setLocationOfBirth(String locationOfBirth) {
		this.locationOfBirth = locationOfBirth;
	}

	/**
	 * @param gender gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return this customers passports
	 */
	public Collection<Passport> getPassportCollection() {
		return passports.values();
	}

	public Map<String, Passport> getPassports() {
		return passports;
	}

	public void setPassports(Map<String, Passport> passports) {
		this.passports = passports;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", locationOfBirth="
				+ locationOfBirth + ", gender=" + gender + ", passports=" + passports + "]";
	}

}
