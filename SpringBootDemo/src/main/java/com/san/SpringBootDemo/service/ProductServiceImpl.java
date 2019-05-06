package com.san.SpringBootDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.SpringBootDemo.model.Product;
import com.san.SpringBootDemo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	@Override
	public Product searchById(Long id) {
		
		return productRepository.findById(id).get();
	}




	@Override
	public void createProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void removeProduct(Long id) {
		productRepository.deleteById(id);
	}




}
