package com.priyanka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbHelloWorldProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbHelloWorldProgramApplication.class, args);
	}
	@RequestMapping(path = "/")
	public String hello() {
		return"This is your spring hello world progarm";
	}

		
	}

