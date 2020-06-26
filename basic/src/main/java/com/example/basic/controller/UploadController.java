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
	 * 추가해야하는 기능 . 1. 저장장치에 파일을 저장 2. 파일의 정보를 DB에 저장
	 */
//			if (!ext.toLowerCase().equals(".jpg") && !ext.toLowerCase().equals(".gif")
//					&& !ext.toLowerCase().equals(".png"))
//				continue;
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		String result = "";
		List<MultipartFile> mFilelist = mRequest.getFiles("file");// html 의 form의 name
		for (int i = 0; i < mFilelist.size(); i++) {
			MultipartFile mFile = mFilelist.get(i);

			String oName = mFile.getOriginalFilename();

			int idx = oName.lastIndexOf(".");
			String name = oName.substring(0, idx);
			String ext = oName.substring(idx);


			// 파일명 중복 검사
			File file = new File("c:/dev/" + oName);// 경로

			String saveName = "";// 중복검사 후 실제 저장될 파일명

			if (file.exists()) { // 파일이 존재하는 경우 (중복파일인 경우)
				// 확장자랑 파일명을 나눈다 < last index of

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
