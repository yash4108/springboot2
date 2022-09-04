package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sky.domain.Product;
import com.sky.repository.ProductRepository;
@Service
public class ProducrServiceImpl implements ProductService {
	@Autowired
	@Qualifier(" productRepositoryDBImpl")
	private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		System.out.println("In Service");	
		if(product.getPrice()>20) 
		productRepository.addProduct(product);
	}

	@Override
	public List<Product> getProduct() {
		
		return productRepository.getProduct();
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.deleteProduct(product);
		
	}

	@Override
	public Product getProductById(String productID) {
		// TODO Auto-generated method stub
		return productRepository.getProductById(productID);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.updateProduct(product);
	}
	
	


}
