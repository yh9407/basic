package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Member {
	//이같은 클래스를 DTO [ data transfer object ] , VO  [value object ] 라고함
@Id private int num;
	private String name;
	private String email;
	private String phone;
	
	
	
	
	
	@Transient
	private String userId;
	@Transient
	private String userPassword;
}