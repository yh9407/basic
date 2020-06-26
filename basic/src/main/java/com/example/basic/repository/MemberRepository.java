package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.Member;
 
// DDD - Domain Driven Development
public interface MemberRepository 
    extends JpaRepository<Member, Integer>{

	public Member findByNumAndName(int num, String name);
}




