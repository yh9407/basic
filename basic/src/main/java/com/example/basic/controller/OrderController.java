package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.basic.model.Order;
import com.example.basic.repository.OrderRepository;

@Controller
public class OrderController {
	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/order")
	public String order(Model model) {
		List<Order> list = orderRepository.findAll();
		model.addAttribute("list", list);

// <È®ÀÎ¿ë >  for (Order e : list) {
//	System.out.printf("%s, %s", 
//			e.getDept().getDname(),
//			e.getEname());
//	
//}

		return "order"; // html template
	}
}
