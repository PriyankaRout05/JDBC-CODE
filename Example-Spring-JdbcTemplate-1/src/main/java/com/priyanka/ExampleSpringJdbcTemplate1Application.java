package com.priyanka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
@ImportResource({"classpath*:queries.xml"})
@SpringBootApplication
public class ExampleSpringJdbcTemplate1Application {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSpringJdbcTemplate1Application.class, args);
	}

}
