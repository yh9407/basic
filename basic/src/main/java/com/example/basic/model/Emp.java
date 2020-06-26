package com.example.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Emp {
	@Id
	@Column(name = "EMPNO")
	int empno;
	@Column(name = "ENAME")	
	
		String ename;
		String job;
		int mgr;
		String hiredate;
		int sal;
		int comm;
		@ManyToOne
		@JoinColumn(name = "deptno")
		Dept dept;
		
}
