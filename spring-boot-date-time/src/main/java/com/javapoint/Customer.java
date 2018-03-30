package com.javapoint;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(sequenceName="customer_seq", allocationSize=1, name="cust_seq")
	long id;
	
	@Column(name="name")
	String name;
	
	@Column(name="created_date")
	LocalDate time;
}
