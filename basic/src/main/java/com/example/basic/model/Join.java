package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Join {
	//�̰��� Ŭ������ DTO [ data transfer object ] , VO  [value object ] �����
@Id private int Number;

	private String name;
	private String email;
	private String id;
	private String password;
	
	

}