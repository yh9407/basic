package com.example.basic.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.basic.model.Animal;
import com.example.basic.model.Article;
import com.example.basic.model.Tree;
import com.example.basic.repository.AnimalRepository;
import com.example.basic.repository.ArticleRepository;
import com.example.basic.repository.TreeRepository;

@Controller
public class JpaController {
	@Autowired
	ArticleRepository articleRepository;

	@GetMapping("/write")
	public String write() {
		return "write";
	}

	@PostMapping("/write")
	@ResponseBody
	public Article writePost(@ModelAttribute Article article, MultipartHttpServletRequest mRequest) {
		String result = "";
		List<MultipartFile> mFiles = mRequest.getFiles("file");

		String oName = "";
		String saveName = ""; // �ߺ��˻� �� ���� ����� ���ϸ�

		for (int i = 0; i < mFiles.size(); i++) {
			MultipartFile mFile = mFiles.get(i);

			oName = mFile.getOriginalFilename();

			// ggoreb.jpg

			int idx = oName.lastIndexOf(".");
			String name = oName.substring(0, idx);
			String ext = oName.substring(idx);

			// �̹��� ������ �ƴϸ�....
			if (!ext.toLowerCase().equals(".jpg") && !ext.toLowerCase().equals(".gif")
					&& !ext.toLowerCase().equals(".png")) {
				continue;
			}

			// ���ϸ� �ߺ� �˻�
			File file = new File("c:/dev/" + oName);

			// css1.html -> css1_17828218123.html
			if (file.exists()) { // ������ �����ϴ� ��� (�ߺ� ����)

				saveName = name + "_" + System.currentTimeMillis() + ext;
			} else {
				saveName = oName;
			}

			try {
				mFile.transferTo(new File("c:/dev/" + saveName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			result += oName + "\n";
		}
		article.setOFileName(oName);
		article.setSFileName(saveName);
		Article result2 = articleRepository.save(article);
		return result2;
	}

	// TreeRepository �������� (������ �������� ���)
	@Autowired
	TreeRepository tr;
	@Autowired
	AnimalRepository ar;

//	@Autowired
//	Animal animal;
//	
//	@Autowired
//	User user;

	// �����ε� Overloading - �޼ҵ���� ����, ������ ����/����/������ �ٸ� ����
	@GetMapping("/animal_html")
	public String animal(Model model, HttpSession session) {
//		String id = (String) session.getAttribute("user");
//		if(id == null) {
//			return "redirect:/login";
//		}
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
		tree.setName("�ҳ���");
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
