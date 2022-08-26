package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByUserName(String username);
	

}