package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Dept {
	@Id
	int deptno;
	String dname;
	String loc;
	

}
