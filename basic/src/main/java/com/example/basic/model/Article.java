package com.example.basic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String title;
	String content;
	String owner;
	int hit;
	String creDate;
	
	
	
	
	String sFileName;
	String oFileName;
	

	
	
}
