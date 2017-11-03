package com.imaginea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginea.constants.Constants;
import com.imaginea.exception.ImagineaRestException;
import com.imaginea.exception.VerifyException;
import com.imaginea.model.Customer;
import com.imaginea.model.Product;
import com.imaginea.model.Response;
import com.imaginea.service.CustomerService;
import com.imaginea.service.ProductService;
import com.imaginea.utils.Verifier;

/**
 *
 * @author ishaks
 * 
 *         The Class CustomerController.
 */
@RestController
public class CustomerController {

	/** The service. */
	@Autowired
	CustomerService customerService;

	/** The product service. */
	@Autowired
	ProductService productService;

	/**
	 * Adds the customer to product.
	 *
	 * @param customer
	 *            the customer
	 * @return the response entity
	 */
	@RequestMapping(value = "/addCustomerToProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCustomerToProduct(@RequestBody Customer customer) {
		try {
			Verifier.verifyNull(customer, "customer object cannot be Null");
			customerService.registerCustomer(customer);
			Response response = new Response();
			response.setMessage("Customer " + customer.getFirstName() + " successfully Registered");
			response.setStatus(Constants.SUCCESS);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (VerifyException exception) {
			return getFailureResponse(exception.getMessage());
		}
	}

	/**
	 * Retrieve all customers.
	 *
	 * @return the response entity
	 */
	@RequestMapping(value = "/retrieveAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> retrieveAllCustomers() {
		try {
			List<Customer> customers = customerService.retrieveAllCustomers();
			Verifier.verifyEmptyCollection(customers, "No products available in database");
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (VerifyException exception) {
			return getFailureResponse(exception.getMessage());
		}
	}

	/**
	 * Adds the new product.
	 *
	 * @param product
	 *            the product
	 * @return the response entity
	 */
	@RequestMapping(value = "/addNewProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
		Response response = new Response();
		try {
			Verifier.verifyNull(product, "Product cannot be null");
			productService.addNewProduct(product);
			response.setMessage("Product added Successfuly");
			response.setStatus(Constants.SUCCESS);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (VerifyException exception) {
			return getFailureResponse(exception.getMessage());
		}
	}

	/**
	 * List all products.
	 *
	 * @return the response entity
	 */
	@RequestMapping(value = "/listAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllProducts() {
		try {
			List<Product> products = productService.listAllAvailableProducts();
			Verifier.verifyEmptyCollection(products, "No products available in database");
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (ImagineaRestException | VerifyException exception) {
			return getFailureResponse(exception.getMessage());
		}
	}

	/**
	 * Generates the failure response.
	 *
	 * @param message
	 *            the message
	 * @return the failure response
	 */
	private static ResponseEntity<?> getFailureResponse(String message) {
		Response response = new Response();
		response.setMessage(message);
		response.setStatus(Constants.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
