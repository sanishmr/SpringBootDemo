package com.san.SpringBootDemo.service;

import java.util.List;

import com.san.SpringBootDemo.model.Product;

public interface ProductService {

	public List<Product> findAllProducts();

	public Product searchById(Long id);

	public void createProduct(Product product);

	public void removeProduct(Long id);
//
//	public void updateProductr(Product product);
}
