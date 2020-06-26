package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.basic.model.Emp;
import com.example.basic.repository.EmpRepository;

@Controller
public class EmpController {
	@Autowired
	EmpRepository empRepository;

	@GetMapping("/emp")
	public String emp(Model model) {
		List<Emp> list = empRepository.findAll();
		model.addAttribute("list", list);

// <È®ÀÎ¿ë >  for (Emp e : list) {
//	System.out.printf("%s, %s", 
//			e.getDept().getDname(),
//			e.getEname());
//	
//}

		return "emp"; // html template
	}
}
