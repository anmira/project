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
	
	// 자동 DI
	@Autowired
	private MemberService service;
	
	@GetMapping("/login.do")
	public String loginForm() throws Exception {
		log.info("login 폼으로 이동");
		return "member/login";
	}
	
	@PostMapping("/login.do")
	// 사용자가 id,pw 입력해서 보낸다. -> 받는다.
	public String login(LoginVO invo, HttpSession session) throws Exception {
		
		log.info("login 처리 - invo : " + invo);
		session.setAttribute("login", service.login(invo));
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		// logout 처리-session 정보 지움
		session.removeAttribute("login");
		
		log.info("로그아웃 처리");
		
		return "redirect:/board/list.do";
	}
}
