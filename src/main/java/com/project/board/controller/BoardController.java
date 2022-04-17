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
@Log4j //log 객체를 자동으로 만들어 줌.
public class BoardController {
	
	// private static final Logger log = LoggerFactory.getLogger(BoardController.class);  

	// 의존성 자동 주입(Dependency inject) -> 자동으로 하게 지정하는 어노테이션 : @Autowired, @Inject
	@Autowired
	private BoardService service;
	
	//1. list
	// 처리 결과를 request에 담아야 하는데 Spring에서는 request가 model에 존재. 
	// model에 넣어주면 request에 담기도록 프로그램 되어있음. 파라미터로 모델 객체를 전달 받아 사용.
	@GetMapping("/list.do")
	public String list(@ModelAttribute PageObject pageObject, Model model) throws Exception{
		// 페이지가 1보다 작으면 1페잉지로 세팅해 준다.
		if(pageObject.getPage() <1) pageObject.setPage(1);
		
		System.out.println("BoardController.list().pageObject -" + pageObject);
		
		// 로그 정보 출력
		log.info("log info 출력 - pageObject : " + pageObject);
		// 로그 경고 출력
		//log.warn("log warn 출력 - pageObject : " + pageObject);
		// 로그 에러 출력
		//log.error("log error 출력 - pageObject : " + pageObject);
		
		model.addAttribute("list", service.list(pageObject));
		return "/board/list";
	}
	
	//2. view
	// 처리 결과를 request에 담아야 하는데 Spring에서는 request가 model에 존재. 
	// model에 넣어주면 request에 담기도록 프로그램 되어있음. 파라미터로 모델 객체를 전달 받아 사용.
	@GetMapping("/view.do")
	public String view(int no, int inc, Model model) throws Exception{

		System.out.println("BoardController.view().no,inc -" + no + ","+ inc);
		// 글 내용 중 줄바꿈 처리 하기. \n -> <br>로 바꾸기
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
		model.addAttribute("vo", service.view(no, 0)); //0을 넘겨서 increase 하지 마라.
		return "board/update";
	}
	
	//4-1. update
	@PostMapping("/update.do")
	public String update(PageObject pageObject, BoardVO vo) throws Exception{
		
		System.out.println("BoardController.update().vo - " + vo);
		service.update(vo);
		return "redirect:view.do?no=" + vo.getNo() + "&inc=0"
				+ "&page=" + pageObject.getPage() + "&perPageNum=" + pageObject.getPerPageNum(); //증가 안하게 increase 하지 마라.
	}
	
	//5. delete
	@GetMapping("/delete.do")   // 삭제해도 perPage는 남게
	public String delete(int no, int perPageNum) throws Exception{
		System.out.println("BoardController.update().no - " + no);
		service.delete(no);
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
}
