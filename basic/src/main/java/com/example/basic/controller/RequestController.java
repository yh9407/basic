package com.example.basic.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.basic.model.Member;

@RestController
//html을 쓰지않고 return에 쓴 문장이 그대로 프린트되어 나온다.
public class RequestController {
//	@Requestparam Map => Mybatis
//	@ModelAttribute DTO => JPA
	
	
	
	@GetMapping("req/model")
	public String model(@ModelAttribute Member member) {
		return member.toString();
	}
	
	@GetMapping("req/path/{path1}/{path2}")
	public String path(
			HttpServletRequest request,
	@PathVariable("path1") String path1,
	@PathVariable("path2") String path2) {
		String uri = request.getRequestURI();
		System.out.println(uri);				
	return path1 + ", " + path2;
	}
	
	@GetMapping("req/param2")
	public Map<String, Object>param2(@RequestParam Map<String, Object> map) {
		return map;
	}

	@GetMapping("req/http")
	public String http(HttpServletRequest request) {
		String name = request.getParameter("name");
		String pageNum = request.getParameter("pageNum");
		return name + ", " + pageNum;
	}
}