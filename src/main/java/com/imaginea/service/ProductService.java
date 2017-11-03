package com.imaginea.service;

import java.util.List;

import com.imaginea.model.Product;

/**
 * The Interface ProductService.
 *
 * @author ishaks
 * 
 * The Interface ProductService.
 */
public interface ProductService {
	
	/**
	 * Adds the new product.
	 *
	 * @param product the product
	 */
	public void addNewProduct(Product product);
	
	/**
	 * List all available products.
	 *
	 * @return the list
	 */
	public List<Product> listAllAvailableProducts();
	
	/**
	 * Drop null products.
	 */
	public void dropNullProducts();
}
