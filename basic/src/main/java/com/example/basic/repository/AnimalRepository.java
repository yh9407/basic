package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}