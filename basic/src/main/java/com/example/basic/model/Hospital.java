package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Hospital {
	@Id   //프라이빗키
	int id;
	String sido;
	String name;
	int medical;
	int room;
	String tel;
	String address;
	double lat;
	double lng;
	

}
