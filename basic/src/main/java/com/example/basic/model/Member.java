package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Member {
	//�̰��� Ŭ������ DTO [ data transfer object ] , VO  [value object ] �����
@Id private int num;
	private String name;
	private String email;
	private String phone;
	
	
	
	
	
	@Transient
	private String userId;
	@Transient
	private String userPassword;
}