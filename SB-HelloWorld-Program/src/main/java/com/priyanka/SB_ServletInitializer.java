package com.priyanka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;


//We need to extend the class SpringBootServletInitializer to support WAR file deployment.
//The code of Spring Boot Application class file is given below −


@SpringBootApplication
public class SB_ServletInitializer extends SpringBootServletInitializer{

		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(SB_ServletInitializer.class);
			
		}

		public static void main(String[] args) {
			SpringApplication.run(SB_ServletInitializer.class, args);
	}
		@RequestMapping(path = "/")
		public String hello() {
			return "hello world from tomcat";
			
			
		}
		

}

