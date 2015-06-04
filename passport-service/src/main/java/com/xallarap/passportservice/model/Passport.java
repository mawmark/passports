package com.xallarap.passportservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Passport class.
 * 
 * @author Mark
 *
 */
@Entity
@Table(name = "PASSPORTS")
// Needed otherwise circular dependency madness occurs
@JsonIgnoreProperties({ "customer" })
public class Passport {

	@Id
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "ISSUE")
	private Date issue;
	@ManyToOne
	private Customer customer;

	/**
	 * Create a new passport.
	 * 
	 * @param number passport number
	 * @param issue date of issue
	 */
	@JsonCreator
	public Passport(@JsonProperty("number") String number, @JsonProperty("issue") Date issue) {
		this.number = number;
		this.issue = issue;
	}

	/**
	 * Empty constructor used for persistence
	 */
	public Passport() {
	}

	/**
	 * @return passport number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @return date of issue
	 */
	public Date getIssue() {
		return issue;
	}

	/**
	 * @param number passport number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @param issue issue date
	 */
	public void setIssue(Date issue) {
		this.issue = issue;
	}

	/**
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Passport [number=" + number + ", issue=" + issue + "]";
	}

}
