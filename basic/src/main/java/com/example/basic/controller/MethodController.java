package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {
	@GetMapping("req/get")
	@RequestMapping(value = "req/get", method = RequestMethod.GET)
	
	
	
	//클라이언트의 요청을 받아주는 기능 ( 애노테이션 [@] ) 
	//1. @RequestParam
	//2. @ModelAttribute
	public String get(String page
			, @RequestParam(name = "page_no", defaultValue = "1") int pageNo ) {
		// requestparam 값은 반드시 url주소에 있어야 함.
		return "GET" + page;
	}

//get 방식 || HTML 주소창에 적어서 화면에 보여지는 방식들
	@GetMapping("req/post")
	public String post2() {
		return "POST_GET";
	}

//post 방식 || 일정한 다른 방식을 거쳐야만 출력할 수 있음. EX>form형식
	@PostMapping("req/post")
	public String post(String page) {
		return "POST" + page;
	}
}