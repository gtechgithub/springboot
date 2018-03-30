package com.javapoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties("server")
public class ServerProperties {

	private String email;
	private List<Cluster> cluster = new ArrayList<>();

	public List<Cluster> getCluster() {
		return cluster;
	}


	public void setCluster(List<Cluster> cluster) {
		this.cluster = cluster;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	@Override
    public String toString() {
        return "ServerProperties{" +
                "email='" + email + '\'' +
                ", cluster=" + cluster +
                '}';
    }


	public static class Cluster{
		
		private String ip;
		private String path;

		
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}

		@Override
		public String toString() {
			return "Cluster{" + "ip='" + ip + '\'' + ", path='" + path + '\'' + '}';
		}
	}
}



