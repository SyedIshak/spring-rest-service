package com.imaginea.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imaginea.constants.Constants;
import com.imaginea.model.Customer;
import com.imaginea.model.Product;
import com.imaginea.model.Response;
import com.imaginea.service.CustomerService;
import com.imaginea.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerControllerTest {

	private Customer customerMock;

	private Product productMock;

	private List<Customer> mockCustomerList;

	private List<Product> mockProductList;

	@Mock
	private CustomerService customerServiceMock;

	@Mock
	private ProductService productServiceMock;

	@InjectMocks
	CustomerController controller = new CustomerController();

	@Before
	public void setUp() {
		mockCustomerList = new ArrayList<Customer>();
		mockCustomerList.add(new Customer("FN1", "LN1", "01/01/2018", "WM"));
		mockCustomerList.add(new Customer("FN2", "LN2", "01/01/2018", "WM"));
		customerMock = new Customer("FN1", "LN1", "01/01/2018", "WM");
		mockProductList = new ArrayList<Product>();
		mockProductList.add(new Product("WM", "WaveMaker"));
		productMock = new Product("WM", "WaveMaker");

	}

	@SuppressWarnings("unchecked")
	@Test
	public void retrieveAllCustomers() {
		Mockito.when(customerServiceMock.retrieveAllCustomers()).thenReturn(mockCustomerList);
		ResponseEntity<List<Customer>> response = (ResponseEntity<List<Customer>>) controller.retrieveAllCustomers();
		Assert.assertEquals("FN1", response.getBody().get(0).getFirstName());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testEmptyCustomerListRetrieval() {
		Mockito.when(customerServiceMock.retrieveAllCustomers()).thenReturn(new ArrayList<Customer>());
		ResponseEntity<List<Customer>> response = (ResponseEntity<List<Customer>>) controller.retrieveAllCustomers();
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAddCustomerToProduct() {
		Mockito.doNothing().when(customerServiceMock).registerCustomer(customerMock);
		ResponseEntity<Response> response = (ResponseEntity<Response>) controller.addCustomerToProduct(customerMock);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(Constants.SUCCESS, response.getBody().getStatus());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testAddCustomerToProductWithNull() {
		ResponseEntity<Response> response = (ResponseEntity<Response>) controller.addCustomerToProduct(null);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		Assert.assertEquals("customer object cannot be Null", response.getBody().getMessage());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testAddNewProduct() {
		Mockito.doNothing().when(productServiceMock).addNewProduct(productMock);
		ResponseEntity<Response> response = (ResponseEntity<Response>) controller.addNewProduct(productMock);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(Constants.SUCCESS, response.getBody().getStatus());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testAddNewProductWithNullProduct() {
		ResponseEntity<Response> response = (ResponseEntity<Response>) controller.addNewProduct(null);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		Assert.assertEquals("Product cannot be null", response.getBody().getMessage());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testListAllProductsSucessfully() {
		Mockito.when(productServiceMock.listAllAvailableProducts()).thenReturn(mockProductList);
		ResponseEntity<List<Product>> reponse = (ResponseEntity<List<Product>>) controller.listAllProducts();
		Assert.assertEquals("WaveMaker", reponse.getBody().get(0).getProductName());
		Assert.assertEquals(HttpStatus.OK, reponse.getStatusCode());
	}

}
