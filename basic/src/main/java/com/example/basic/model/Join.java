package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Join {
	//이같은 클래스를 DTO [ data transfer object ] , VO  [value object ] 라고함
@Id private int Number;

	private String name;
	private String email;
	private String id;
	private String password;
	
	

}