package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyportalApplication {
	
	@GetMapping("/access")
	public String greeting() {
		return "Welecome to this portal";
		
	}
	


	public static void main(String[] args) {
		SpringApplication.run(MyportalApplication.class, args);
	}

}
