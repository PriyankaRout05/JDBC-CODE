package com.pinkily.pagination.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.pinkily.pagination.entity.Product;
import com.pinkily.pagination.repository.ProductRepository;

public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@PostConstruct
	public void initDB() {
		List<Product> products = IntStream.rangeClosed(1, 200)
			.mapToObj(i -> new Product("product" + i,new Random().nextInt(100), new Random().nextInt(50000)))
			.collect(Collectors.toList());
		repository.saveAll(products); 
		}
		
//		List<Product> products = IntStream.rangeClosed(1, 200)
//				.mapToObj(i -> new Product(i.name + i,new Random().nextInt(bound:100), new Random().nextInt(50000)))
//				.collect(Collectors.toList());
//			repository.saveAll(t);
//			}
	
	public List<Product> findAllProducts(){
		return repository.findAll();
	}

}
