
package com.imaginea.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class Customer.
 */
@Document
public class Customer {

	/** The id. */
	@Id
	public String id;

	/** The first name. */
	public String firstName;

	/** The last name. */
	public String lastName;

	/** The registration date. */
	public String registrationDate;

	/** The prod id. */
	public String prodId;

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param firstName            the first name
	 * @param lastName            the last name
	 * @param registrationDate            the registration date
	 * @param prodId the prod id
	 */
	public Customer(String firstName, String lastName, String registrationDate, String prodId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationDate = registrationDate;
		this.prodId = prodId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s', registrationDate = '%s']", id, firstName,
				lastName, registrationDate);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the registration date.
	 *
	 * @return the registration date
	 */
	public String getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Sets the registration date.
	 *
	 * @param registrationDate
	 *            the new registration date
	 */
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Gets the prod id.
	 *
	 * @return the prod id
	 */
	public String getProdId() {
		return prodId;
	}

	/**
	 * Sets the prod id.
	 *
	 * @param prodId the new prod id
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

}