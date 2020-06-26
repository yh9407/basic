package com.example.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home/")
public class HomeController {

	@GetMapping("/sign_in")
	public String sign_in() {
		return "sign_in";
	}

	@GetMapping("/sign_in2")
	public String sign_in2(Model model, String id, String pw) {
		if (id.equals("a") && pw.equals("1")) {
			// 로그인 성공
			model.addAttribute("msg", "success");
		} else {
			// 로그인 실패
			model.addAttribute("msg", "fail");
		}
		return "sign_in2";
	}

	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}

	@GetMapping("/test2")
	@ResponseBody
	public String test2() {
		return "내용";
	}

	@GetMapping("/free") // /free?title=OOO
	public String free(Model model, String title) {
		model.addAttribute("title", title);
		return "index";
	}

	// Log4J -> Slf4J
	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home() {
		System.out.println("print");
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info!");
		logger.warn("warn!");
		logger.error("error!");
		

		return "home";

	}
}