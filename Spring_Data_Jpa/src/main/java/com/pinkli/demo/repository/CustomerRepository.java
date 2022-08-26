package com.pinkli.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinkili.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	

}
