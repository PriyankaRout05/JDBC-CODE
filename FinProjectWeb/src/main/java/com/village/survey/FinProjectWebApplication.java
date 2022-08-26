package com.village.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:administration-queries.xml")
public class FinProjectWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinProjectWebApplication.class, args);
	}

}
