package com.project.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.member.mapper.MemberMapper;
import com.project.member.vo.LoginVO;

@Service
public class MemberService {

	// �ڵ� DI
	@Inject
	private MemberMapper mapper;
	
	// �α���
	public LoginVO login(LoginVO invo) throws Exception{
		return mapper.login(invo); 
	}
}
