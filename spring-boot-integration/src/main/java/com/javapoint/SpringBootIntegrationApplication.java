package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
@ComponentScan(basePackages="com.javapoint")
public class SpringBootIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntegrationApplication.class, args);
	}
}
