package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.Tree;

// DDD - Domain Driven Development
public interface TreeRepository extends JpaRepository<Tree, Long>{

}
