package com.project.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.member.service.MemberService;
import com.project.member.vo.LoginVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j

public class MemberController {
	
	// �ڵ� DI
	@Autowired
	private MemberService service;
	
	@GetMapping("/login.do")
	public String loginForm() throws Exception {
		log.info("login ������ �̵�");
		return "member/login";
	}
	
	@PostMapping("/login.do")
	// ����ڰ� id,pw �Է��ؼ� ������. -> �޴´�.
	public String login(LoginVO invo, HttpSession session) throws Exception {
		
		log.info("login ó�� - invo : " + invo);
		session.setAttribute("login", service.login(invo));
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		// logout ó��-session ���� ����
		session.removeAttribute("login");
		
		log.info("�α׾ƿ� ó��");
		
		return "redirect:/board/list.do";
	}
}
