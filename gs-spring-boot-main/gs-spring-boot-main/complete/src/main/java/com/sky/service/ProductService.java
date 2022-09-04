package com.sky.service;

import java.util.List;

import com.sky.domain.Product;

public interface ProductService {
	public void addProduct(Product product);
	public List<Product> getProduct();
	public void deleteProduct(Product product);
	public Product getProductById(String productID);
	public Product updateProduct(Product product);

}
