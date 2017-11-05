package com.imaginea.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.exception.ImagineaRestException;
import com.imaginea.model.Product;
import com.imaginea.repository.ProductRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author ishaks
 * 
 *         The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

	/** The product repository. */
	@Autowired
	ProductRepository productRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imaginea.service.ProductService#addNewProduct(com.imaginea.model.Product)
	 */
	@Override
	public void addNewProduct(Product product) {
		productRepository.save(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imaginea.service.ProductService#listAllAvailableProducts()
	 */
	@Override
	public List<Product> listAllAvailableProducts() {
		return productRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imaginea.service.ProductService#dropNullProducts()
	 */
	@Override
	public void dropNullProducts() throws ImagineaRestException {
		System.out.println("Deleting any new null productID . . .");
		
		try (MongoClient client = new MongoClient("localhost", 27017)) {
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("prodId");
			collection.deleteMany(new Document("prodId", null));
		}
	}

}
