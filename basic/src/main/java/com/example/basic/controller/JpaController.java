package com.example.basic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Animal;
import com.example.basic.model.Tree;
import com.example.basic.model.User;
import com.example.basic.repository.AnimalRepository;
import com.example.basic.repository.TreeRepository;

@Controller
public class JpaController {
	// TreeRepository 가져오기 (스프링 내에서만 사용)
	@Autowired
	TreeRepository tr;
	@Autowired
	AnimalRepository ar;

//	@Autowired
//	Animal animal;
//	
//	@Autowired
//	User user;

	// 오버로딩 Overloading - 메소드명은 같고, 인자의 개수/종류/순서가 다른 형태
	@GetMapping("/animal_html")
	public String animal(Model model, HttpSession session) {
		String id = (String) session.getAttribute("user");
		if (id == null) {
			return "redirect:/login";
		}
		List<Animal> list = ar.findAll();
		model.addAttribute("list", list);
		return "animal";
	}

	@GetMapping("/animal")
	@ResponseBody
	public List<Animal> animal() {
		List<Animal> list = ar.findAll();
		return list;
	}

	@GetMapping("/tree_add")
	@ResponseBody
	public String tree_add() {
		Tree tree = new Tree();
		tree.setColor("RED");
		tree.setName("소나무");
		tr.save(tree);
		return "ok";
	}

	@GetMapping("/tree")
	@ResponseBody
	public String tree() {
		List<Tree> list = tr.findAll(); // select ALL

		return list.toString();
	}
}
