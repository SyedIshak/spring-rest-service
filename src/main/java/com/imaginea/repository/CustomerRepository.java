package com.imaginea.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.imaginea.model.Customer;

/**
 * @author ishaks
 *
 *The Interface CustomerRepository.
 *
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	/**
	 * Find by prod id.
	 *
	 * @param prodId the prod id
	 * @return the list
	 */
	public List<Customer> findByProdId(String prodId);
	

}
