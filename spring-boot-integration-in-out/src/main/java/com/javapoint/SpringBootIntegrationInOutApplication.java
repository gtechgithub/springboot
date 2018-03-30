package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
public class SpringBootIntegrationInOutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntegrationInOutApplication.class, args);
	}
}
