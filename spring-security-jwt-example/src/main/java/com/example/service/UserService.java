package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public void saveOrUpdate(Users user) {
		userRepository.save(user);
		
	}

}
