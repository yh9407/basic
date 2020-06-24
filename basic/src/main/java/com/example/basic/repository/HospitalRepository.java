package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
	public Hospital findByName(String name);//추상메소드
	
	

	public List<Hospital> findAllByAddressContainingOrderByIdDesc(String address);
	
	
	
}