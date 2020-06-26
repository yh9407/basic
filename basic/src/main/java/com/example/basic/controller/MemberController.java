package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Member;
import com.example.basic.repository.MemberRepository;


@Controller
public class MemberController {
	@Autowired
	MemberRepository mr;
	
	@GetMapping("/sign_in")
	public String signIn() {
		return "sign_in";
	}
	
	
//	@PostMapping("/sign_in")
//	@ResponseBody
//	//json으로 리턴하려면 map 이나 response를 사용해야 한다.
//	public Member signIn2(
//			@ModelAttribute Member member) {
//		System.out.println(member);
//		Member result = mr.findByNumAndName(
//				member.getNum(), member.getName());
//		
//		System.out.println("result " + result);
//		
//		return result;
//		//jpa의 결과인 result를 리턴.
//	}
	@PostMapping("/sign_in")
	@ResponseBody
	
	public Map<String, Object> signIn2(
			@ModelAttribute Member member) {
		System.out.println(member);
		Member result = mr.findByNumAndName(
				member.getNum(), member.getName());
		
		System.out.println("result " + result);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "성공");
		
		return map;
		//jpa의 결과인 result를 리턴.
	}
	

	
	
	
	
	
	
	@GetMapping("/sign_up")
	public String signUp() {
		return "sign_up";
	}
	@PostMapping("/sign_up")
	@ResponseBody
	public Member signUpPost(
			@ModelAttribute Member member) {
		return mr.save(member);
		
	}
}
