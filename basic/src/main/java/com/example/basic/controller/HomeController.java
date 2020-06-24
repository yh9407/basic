package com.example.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	@GetMapping("/free") //free?title=???? <- 호출시 
	public String free (
			Model model, String title) {
		model.addAttribute("title", title);
		return "index";
		//----타임리프문법------
		//index.html 에서 [[${title}]] 적어서  동적으로 변환시킨것.
	}
	
	//Log 4j [for Java] => slf4j
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		System.out.println("print");
		logger.trace("trace!");
		logger.debug("debug!");
		logger.info("info!");
		logger.warn("warn!");
		logger.error("error!");
					
		return "home";
		//리턴 값에 적혀 있는 home이라는 파일을 찾아서 리턴하게 된다. 
		//예제에서는 템플릿에 있는 home이라는 HTML 파일을 리턴.
		
		
		
		
		
	}
}
