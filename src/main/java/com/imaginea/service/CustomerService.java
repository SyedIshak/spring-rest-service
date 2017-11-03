package com.imaginea.service;

import java.util.List;

import com.imaginea.model.Customer;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {

	/**
	 * Register customer.
	 *
	 * @param customer
	 *            the customer
	 */
	public void registerCustomer(Customer customer);

	/**
	 * Retrieve all customers.
	 *
	 * @return the list
	 */
	public List<Customer> retrieveAllCustomers();

}
