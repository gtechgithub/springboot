package com.javapoint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
public class BaseballCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
 	@Field
    private String name;
    
    @Field
    private String rarityLevel;
    
    @Field
    private int year;
    
    public int getId() {
 		return id;
 	}

 	public void setId(int id) {
 		this.id = id;
 	}

 	public String getName() {
 		return name;
 	}

 	public void setName(String name) {
 		this.name = name;
 	}

 	public String getRarityLevel() {
 		return rarityLevel;
 	}

 	public void setRarityLevel(String rarityLevel) {
 		this.rarityLevel = rarityLevel;
 	}

 	public int getYear() {
 		return year;
 	}

 	public void setYear(int year) {
 		this.year = year;
 	}
}
