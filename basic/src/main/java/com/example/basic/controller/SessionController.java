package com.example.basic.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.basic.model.User;

@Controller
public class SessionController {
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션의 모든 내용 삭제
		session.removeAttribute("user"); // 세션의 내용 중 user 삭제
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(User user, HttpSession session) {
		session.setAttribute("user", user);
		return "redirect:/main";
	}

	@GetMapping("/main")
	public String main() {
		return "main";
	}
}