package com.example.basic.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {
	@GetMapping("/upload1")
	public String upload1() {
		return "upload1";
	}

	@PostMapping("/upload1")
	@ResponseBody
	/*
	 * �߰��ؾ��ϴ� ��� . 1. ������ġ�� ������ ���� 2. ������ ������ DB�� ����
	 */
//			if (!ext.toLowerCase().equals(".jpg") && !ext.toLowerCase().equals(".gif")
//					&& !ext.toLowerCase().equals(".png"))
//				continue;
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		String result = "";
		List<MultipartFile> mFilelist = mRequest.getFiles("file");// html �� form�� name
		for (int i = 0; i < mFilelist.size(); i++) {
			MultipartFile mFile = mFilelist.get(i);

			String oName = mFile.getOriginalFilename();

			int idx = oName.lastIndexOf(".");
			String name = oName.substring(0, idx);
			String ext = oName.substring(idx);


			// ���ϸ� �ߺ� �˻�
			File file = new File("c:/dev/" + oName);// ���

			String saveName = "";// �ߺ��˻� �� ���� ����� ���ϸ�

			if (file.exists()) { // ������ �����ϴ� ��� (�ߺ������� ���)
				// Ȯ���ڶ� ���ϸ��� ������ < last index of

				saveName = name + "_" + System.currentTimeMillis() + ext;
			} else {
				saveName = oName;
			}

			try {

				mFile.transferTo(new File("c:/dev/" + saveName));

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result += oName + "\n";
		}

		return result;
	}
//	String oName = mFile.getOriginalFilename();
//	result += oName + "\n";
//	return result;
}
