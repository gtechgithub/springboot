package com.javapoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationPropertiesValue {

	private String email;


	@Value("${thread-pool}")
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
