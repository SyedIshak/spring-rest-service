package com.imaginea.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class Product.
 */
@Document
public class Product {

	/** The id. */
	@Id
	private String id;

	/** The prod id. */
	private String prodId;

	/** The product name. */
	private String productName;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param prodId
	 *            the prod id
	 * @param productName
	 *            the product name
	 */
	public Product(String prodId, String productName) {
		this.prodId = prodId;
		this.productName = productName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product = " + productName + " with prodId = " + prodId;

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
	 * @param prodId
	 *            the new prod id
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName
	 *            the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
