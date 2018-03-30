package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
	basePackageClasses= {SpringBootDateTimeApplication.class,Jsr310JpaConverters.class} 
)


@SpringBootApplication
public class SpringBootDateTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDateTimeApplication.class, args);
		
	}
}
