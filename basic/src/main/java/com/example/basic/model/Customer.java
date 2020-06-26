package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	String id;
	String name;
	int age;
	String grade;
	String job;
	int point;

}
