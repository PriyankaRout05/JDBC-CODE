package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AuthRequest;
import com.example.entity.Users;
import com.example.service.UserService;
import com.example.util.JwtUtil;

@RestController
public class WelcomeController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/hi")
	public String welcome() {
		return"welcome to office!!";
	}
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(authRequest.getUserNmae(), authRequest.getPassword()));
//		} catch (Exception ex) {
//			throw new Exception("inavalid username/password");
//		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

	@GetMapping("/user")
	private List<Users> getAllUser() {
		return userService.getAllUsers();
	}

	@PostMapping("/create")
	private int saveUser(@RequestBody Users user) {
		userService.saveOrUpdate(user);
		return user.getId();
	}
}

