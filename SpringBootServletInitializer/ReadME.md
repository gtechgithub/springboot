# SpringBootServletInitializer 

The SpringBootApplication, current trend is to to deploy Spring Boot Application from jar.

**Spring is a popular Java application framework.**

**Spring Boot is an effort to create stand-alone, 

production-grade Spring based applications with minimal effort.**


SpringBootServletInitializer
---
SpringBootServletInitializer is an interface to run SpringApplication from a traditional WAR deployment. 
It binds Servlet, Filter and ServletContextInitializer beans from the application context to the server.

This is the Maven build file. The spring-boot-starter-web is starter for building web, including RESTful,
applications using Spring MVC.
The application is packaged into a WAR file.


The Application sets up the Spring Boot application.
It extends from SpringBootServletInitializer so that it can be deployed as a WAR.
The application can be run both by deploying the WAR on a Tomcat server and executing 
it as a self-executable web archive with embedded Tomcat.
