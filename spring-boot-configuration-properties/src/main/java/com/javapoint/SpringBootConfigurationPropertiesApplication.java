package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses=WelcomeController.class)
public class SpringBootConfigurationPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigurationPropertiesApplication.class, args);
		
	}
}
