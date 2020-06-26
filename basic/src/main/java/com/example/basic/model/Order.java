package com.example.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Order {
	@Id
	@Column(name = "id")
	int id;	
	@Column(name = "name")
		
		String name;
		int count;
		String dest;
		String ord_date;
		@ManyToOne
		@JoinColumn(name = "customer_id")
		Customer customer;
		
}
