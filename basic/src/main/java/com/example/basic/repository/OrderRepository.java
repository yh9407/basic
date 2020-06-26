package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
}