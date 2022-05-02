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

// �ڵ� ���� ������̼� -@Controller : url mapping
@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	// url�� jsp ������ �� ������. �׷� �� ���� Ÿ���� String ��� void ��� ����.
	public void uploadForm() throws Exception {
		log.info("uploadForm()");
	}
	
				// jsp form action �̸��� ����
	@PostMapping("/uploadFormAction")		   //jsp name�� ����
	public void uploadFormAction(MultipartFile uploadFile, HttpServletRequest request, Model model) throws Exception {
		// ���� �޸�(RAM)�̳� �ӽ� ������ ����� ����. - ���� ������ ���� ����
		log.info(uploadFile);
		log.info(uploadFile.getOriginalFilename());
		
		// ���� ��ġ - ���� ������ ��� ��ġ. -> ������ ������ ���� ������ġ �ʿ�.
		String path = "/upload";
		
		// request�� �̿��ؼ� ���� ��ġ ���Ѵ�. -> request �Ķ���ͷ� �޴´�.
		String savePath = request.getServletContext().getRealPath(path);
		log.info(savePath);
		
		// ���� ����. ���� ���ϸ����� ����. ���ϸ��� ������ ����� ��.
		uploadFile.transferTo(new File(savePath, uploadFile.getOriginalFilename()));
		 
		// DB�� ���� �� ���� ���� 
		String fileName = path + "/" + uploadFile.getOriginalFilename();
		log.info(fileName);
		
		model.addAttribute("fileName", fileName);
	}
	
	// ���� ÷�� ������.
	@GetMapping("/uploadForms")
	// url�� jsp ������ �� ������. �׷� �� ���� Ÿ���� String ��� void ��� ����.
	public void uploadForms() throws Exception {
		log.info("uploadForms()"); 
	}
	
				// jsp form action �̸��� ����
	@PostMapping("/uploadFormActions")		   //jsp name�� ����
	public void uploadFormActions(List<MultipartFile> uploadFiles, HttpServletRequest request, Model model) throws Exception {
		// ���� �޸�(RAM)�̳� �ӽ� ������ ����� ����. - ���� ������ ���� ����
		log.info(uploadFiles);
		
		// ������ ��� ���� �̸� ���
		for(MultipartFile uploadFile : uploadFiles) {
			log.info(uploadFile.getOriginalFilename());
		}
		
		// ���� ��ġ - ���� ������ ��� ��ġ. -> ������ ������ ���� ������ġ �ʿ�.
		String path = "/upload";
		
		// request�� �̿��ؼ� ���� ��ġ ���Ѵ�. -> request �Ķ���ͷ� �޴´�.
		String savePath = request.getServletContext().getRealPath(path);
		log.info(savePath);
		
		/*
		 * // ���� ����. ���� ���ϸ����� ����. ���ϸ��� ������ ����� ��. uploadFiles.transferTo(new
		 * File(savePath, uploadFiles.getOriginalFilename()));
		 * 
		 * // DB�� ���� �� ���� ���� String fileName = path + "/" +
		 * uploadFiles.getOriginalFilename(); log.info(fileName);
		 * 
		 * model.addAttribute("fileName", fileName);
		 */
	}
}
