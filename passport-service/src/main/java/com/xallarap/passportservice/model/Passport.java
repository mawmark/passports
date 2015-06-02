package com.xallarap.passportservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Passport class.
 * 
 * @author Mark
 *
 */
public class Passport {

	private final String number;
	private final Date issue;

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

	@Override
	public String toString() {
		return "Passport [number=" + number + ", issue=" + issue + "]";
	}

}
