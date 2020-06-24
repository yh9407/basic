package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Member;
import com.example.basic.repository.Sign_UpRepository;

@Controller
public class Sign_UpController {
	@Autowired
	Sign_UpRepository mr;
	
	
	
	@GetMapping("/sign_up")
	public String signUp() {
		return "sign_up";
	}
	@PostMapping("/sign_up")
	@ResponseBody
	public Member signUpPost(@ModelAttribute Member member) {
		return mr.save(member);
	}



}
