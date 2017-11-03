package com.imaginea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.model.Customer;
import com.imaginea.repository.CustomerRepository;

/**
 * The Class CustomerServiceImpl.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/** The repository. */
	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imaginea.service.CustomerService#registerCustomer(com.imaginea.model.
	 * Customer)
	 */
	@Override
	public void registerCustomer(Customer c) {
		customerRepository.save(c);
		System.out.println(c.getFirstName() + " registered Sucessfully !!!");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imaginea.service.CustomerService#retrieveAllCustomers()
	 */
	@Override
	public List<Customer> retrieveAllCustomers() {
		System.out.println("returning all Customers");
		return customerRepository.findAll();
	}

}
