package com.project.board;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

// 자동 생성 어노테이션 -@Controller : url mapping
@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	// url에 jsp 정보가 다 존재함. 그럴 때 리턴 타입을 String 대신 void 사용 가능.
	public void uploadForm() throws Exception {
		log.info("uploadForm()");
	}
	
				// jsp form action 이름과 같게
	@PostMapping("/uploadFormAction")		   //jsp name과 같게
	public void uploadFormAction(MultipartFile uploadFile, HttpServletRequest request, Model model) throws Exception {
		// 메인 메모리(RAM)이나 임시 폴더에 저장된 상태. - 아직 저장은 하지 않음
		log.info(uploadFile);
		log.info(uploadFile.getOriginalFilename());
		
		// 저장 위치 - 서버 기준의 상대 위치. -> 실제로 저장할 때는 절대위치 필요.
		String path = "/upload";
		
		// request를 이용해서 절대 위치 구한다. -> request 파라미터로 받는다.
		String savePath = request.getServletContext().getRealPath(path);
		log.info(savePath);
		
		// 파일 저장. 원래 파일명으로 저장. 파일명이 같으면 덮어쓰기 됨.
		uploadFile.transferTo(new File(savePath, uploadFile.getOriginalFilename()));
		 
		// DB에 저장 될 파일 정보 
		String fileName = path + "/" + uploadFile.getOriginalFilename();
		log.info(fileName);
		
		model.addAttribute("fileName", fileName);
	}
	
	// 파일 첨부 여러개.
	@GetMapping("/uploadForms")
	// url에 jsp 정보가 다 존재함. 그럴 때 리턴 타입을 String 대신 void 사용 가능.
	public void uploadForms() throws Exception {
		log.info("uploadForms()"); 
	}
	
				// jsp form action 이름과 같게
	@PostMapping("/uploadFormActions")		   //jsp name과 같게
	public void uploadFormActions(List<MultipartFile> uploadFiles, HttpServletRequest request, Model model) throws Exception {
		// 메인 메모리(RAM)이나 임시 폴더에 저장된 상태. - 아직 저장은 하지 않음
		log.info(uploadFiles);
		
		// 들어오는 모든 파일 이름 출력
		for(MultipartFile uploadFile : uploadFiles) {
			log.info(uploadFile.getOriginalFilename());
		}
		
		// 저장 위치 - 서버 기준의 상대 위치. -> 실제로 저장할 때는 절대위치 필요.
		String path = "/upload";
		
		// request를 이용해서 절대 위치 구한다. -> request 파라미터로 받는다.
		String savePath = request.getServletContext().getRealPath(path);
		log.info(savePath);
		
		/*
		 * // 파일 저장. 원래 파일명으로 저장. 파일명이 같으면 덮어쓰기 됨. uploadFiles.transferTo(new
		 * File(savePath, uploadFiles.getOriginalFilename()));
		 * 
		 * // DB에 저장 될 파일 정보 String fileName = path + "/" +
		 * uploadFiles.getOriginalFilename(); log.info(fileName);
		 * 
		 * model.addAttribute("fileName", fileName);
		 */
	}
}
