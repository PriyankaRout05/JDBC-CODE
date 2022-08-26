package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class DemoApplicationSchedulingApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplicationSchedulingApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplicationSchedulingApplication.class, args);
	}

	//@Scheduled(initialDelay = 1000L, fixedDelayString = "${someJob.delay}")
	//@Scheduled(initialDelay = 1000L, cron = "0 0 18 * * *MON-FRI")

	@Scheduled(fixedRate = 1000L)
	void someJob() throws InterruptedException {
		log.info("someJob Now is " + new Date());
		//System.out.println("somejob Now is" + new Date());
		Thread.sleep(1000L);
	}
	@Scheduled(fixedRate = 1000L)
	void someJob2() throws InterruptedException {
		log.info("someJOb2 Now is " + new Date());
	
		//System.out.println("somejob2 Now is" + new Date());
		
	}

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration {

}