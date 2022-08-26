package com.pinkily.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinkily.pagination.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
}
