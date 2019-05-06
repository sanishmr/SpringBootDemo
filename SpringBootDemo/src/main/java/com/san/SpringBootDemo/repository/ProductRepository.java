package com.san.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.san.SpringBootDemo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
