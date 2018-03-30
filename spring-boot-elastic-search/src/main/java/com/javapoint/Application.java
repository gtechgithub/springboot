package com.javapoint;


import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@SpringBootApplication
@ComponentScan(basePackages="com.javapoint")
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class Application implements CommandLineRunner {

 
    
    @Autowired
    private ElasticsearchConfiguration esconfig;

    @Autowired
    private BookService bookService;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();
/*
        bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));
*/
        
        bookService.save(new Book("1004", "Elasticsearch Basics", "Posa", "23-FEB-2017"));
        bookService.save(new Book("1005", "Apache Lucene Basics", "Posa", "13-MAR-2017"));
        bookService.save(new Book("1006", "Apache Solr Basics", "Posa", "21-MAR-2017"));
        
        //fuzzey search
        Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));

        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");

        books.forEach(x -> System.out.println(x));


    }

    //useful for debug, print elastic search details
    private void printElasticSearchInfo() throws Exception {

        System.out.println("--ElasticSearch--");
        
        //Client client = es.getClient();
        Client client = esconfig.elasticsearchTemplate().getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("--ElasticSearch--");
    }

}