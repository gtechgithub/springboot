package com.javapoint;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;


@Component
@Configuration
@EnableElasticsearchRepositories(basePackages="com.javapoint")
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class ElasticsearchConfiguration {
	
	@Value("${elasticsearch.host}")
	private String EsHost;
	
    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;
    
    public ElasticsearchConfiguration() {
    	System.out.println("inside constructor ElasticsearchConfiguration ");
    }
    
    @Bean
    public Client client() throws Exception {
    	System.out.println("inside ElasticsearchConfiguration client ");

    	Settings.Builder builder = Settings.settingsBuilder();
    	builder.put("cluster.name",EsClusterName);
    	Settings esSettings = builder.build();
    	
    	System.out.println("inside ElasticsearchConfiguration before transport client");
    	TransportClient.Builder transportClientBuilder  = TransportClient.builder();
    	System.out.println("inside ElasticsearchConfiguration before setting");
    	transportClientBuilder.settings(esSettings);
    	System.out.println("inside ElasticsearchConfiguration before build");
    	TransportClient transportClient = transportClientBuilder.build();
    	System.out.println("inside ElasticsearchConfiguration before addTransportAddress");
    	transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost),EsPort));
    	
    	System.out.println("EsClusterName:"+ EsClusterName + " EsHost:" + EsHost + "EsPort:" + EsPort);
    	return transportClient;
    	
    }
    
    @Bean
    public ElasticsearchOperations  elasticsearchTemplate() throws Exception {
    	System.out.println("inside ElasticsearchConfiguration elasticsearchTemplate ");
    	ElasticsearchTemplate  elasticsearchTemplate1 = new ElasticsearchTemplate(client());
    	return elasticsearchTemplate1;
    	
    }
}
