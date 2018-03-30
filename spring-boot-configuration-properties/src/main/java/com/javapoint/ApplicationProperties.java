package com.javapoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class ApplicationProperties {

	private String email;

	private int threadPool;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(int threadPool) {
		this.threadPool = threadPool;
	}
	
	@Override
	public String toString() {
		return "email:" + email + " thread pool:" + threadPool;
	}
}
