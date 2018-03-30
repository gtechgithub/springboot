package com.javapoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingApplication {
	
	private static Logger log = LoggerFactory.getLogger(SpringBootLoggingApplication.class);

	public static void main(String[] args) {
		System.out.println("hello logging");
		log.debug("hello logging");
		SpringApplication.run(SpringBootLoggingApplication.class, args);
	}
}
