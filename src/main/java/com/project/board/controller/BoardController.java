package com.project.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVO;
import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j //log ��ü�� �ڵ����� ����� ��.
public class BoardController {
	
	// private static final Logger log = LoggerFactory.getLogger(BoardController.class);  

	// ������ �ڵ� ����(Dependency inject) -> �ڵ����� �ϰ� �����ϴ� ������̼� : @Autowired, @Inject
	@Autowired
	private BoardService service;
	
	//1. list
	// ó�� ����� request�� ��ƾ� �ϴµ� Spring������ request�� model�� ����. 
	// model�� �־��ָ� request�� ��⵵�� ���α׷� �Ǿ�����. �Ķ���ͷ� �� ��ü�� ���� �޾� ���.
	@GetMapping("/list.do")
	public String list(@ModelAttribute PageObject pageObject, Model model) throws Exception{
		// �������� 1���� ������ 1�������� ������ �ش�.
		if(pageObject.getPage() <1) pageObject.setPage(1);
		
		System.out.println("BoardController.list().pageObject -" + pageObject);
		
		// �α� ���� ���
		log.info("log info ��� - pageObject : " + pageObject);
		// �α� ��� ���
		//log.warn("log warn ��� - pageObject : " + pageObject);
		// �α� ���� ���
		//log.error("log error ��� - pageObject : " + pageObject);
		
		model.addAttribute("list", service.list(pageObject));
		return "/board/list";
	}
	
	//2. view
	// ó�� ����� request�� ��ƾ� �ϴµ� Spring������ request�� model�� ����. 
	// model�� �־��ָ� request�� ��⵵�� ���α׷� �Ǿ�����. �Ķ���ͷ� �� ��ü�� ���� �޾� ���.
	@GetMapping("/view.do")
	public String view(int no, int inc, Model model) throws Exception{

		System.out.println("BoardController.view().no,inc -" + no + ","+ inc);
		// �� ���� �� �ٹٲ� ó�� �ϱ�. \n -> <br>�� �ٲٱ�
		BoardVO vo = service.view(no, inc);
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		model.addAttribute("vo", vo);
		
		return "board/view";
	}
	
	//3-1. writeForm
	@GetMapping("/write.do")
	public String writeForm() throws Exception{
		return "board/write";
	}
	
	//3-2. write
	@PostMapping("/write.do")
	public String write(BoardVO vo, int perPageNum) throws Exception{
		
		System.out.println("BoardController.write().vo - " + vo);
		service.write(vo);
		return "redirect:list.do?page=1&perPageNum=" + perPageNum;
	}
	
	//4-1. updateForm
	@GetMapping("/update.do")
	public String updateForm(int no, Model model) throws Exception{
		
		System.out.println("BoardController.updateForm().no - " + no);
		model.addAttribute("vo", service.view(no, 0)); //0�� �Ѱܼ� increase ���� ����.
		return "board/update";
	}
	
	//4-1. update
	@PostMapping("/update.do")
	public String update(PageObject pageObject, BoardVO vo) throws Exception{
		
		System.out.println("BoardController.update().vo - " + vo);
		service.update(vo);
		return "redirect:view.do?no=" + vo.getNo() + "&inc=0"
				+ "&page=" + pageObject.getPage() + "&perPageNum=" + pageObject.getPerPageNum(); //���� ���ϰ� increase ���� ����.
	}
	
	//5. delete
	@GetMapping("/delete.do")   // �����ص� perPage�� ����
	public String delete(int no, int perPageNum) throws Exception{
		System.out.println("BoardController.update().no - " + no);
		service.delete(no);
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
}
