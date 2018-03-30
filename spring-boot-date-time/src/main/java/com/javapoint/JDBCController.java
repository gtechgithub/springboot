package com.javapoint;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class JDBCController {
	@Autowired
	JdbcTemplate jdbc;
	
	 @Autowired
	 DataSource dataSource;
	
	@RequestMapping(value="/Select" ,method = RequestMethod.GET)
	public String methodSelect() {
		
		System.out.println("datasource:" + dataSource);
        jdbc.execute("insert into customer(name,created_date)values('Gopal','2017-08-20 15:23:25')");  
        return "data inserted successfully";
	}
}

