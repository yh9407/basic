package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.model.Member;

@Controller
public class HtmlController {
	@GetMapping("html/string")
	// ===>> view�� ������ ����
	public String html(Model model) {
		model.addAttribute("msg", "�̰� ���ñ�??");
		//key(msg) �� value(�ڹ�)
		
		Map map = new HashMap();
		map.put("name", "ȫ�浿");
		map.put("address", "JEJUisland");
		model.addAttribute("person", map);
		
		return "html/string";
		
	}
//HTML ���� �����ô� �� ���� ��θ� �ǹ���.
	@GetMapping("html/void")
	public void htmlVoid() {
	}

	@GetMapping("html/map")
	public Map<String, Object> htmlMap(Map<String, Object> map) {
		Map<String, Object> map2 = new HashMap<String, Object>();
		return map2;
	}

	@GetMapping("html/model")
	public Model htmlModel(Model model) {
		return model;
	}

	@GetMapping("html/model_and_view")
	public ModelAndView htmlModel() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("html/model_and_view");
		return mav;
	}

	@GetMapping("html/object")
	public Member htmlObject() {
		Member member = new Member();
		member.setName("kim");
		return member;
	}
}