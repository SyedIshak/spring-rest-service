package com.imaginea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.imaginea.model.Product;

/**
 * @author ishaks
 * 
 * The Interface ProductRepository.
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	/**
	 * Find by product id.
	 *
	 * @param prodId the product id
	 * @return the product
	 */
	public Product findByProdId(String prodId);
	
	/**
	 * Find by product name.
	 *
	 * @param prodName the product name
	 * @return the product
	 */
	public Product findByProductName(String productName);

}
