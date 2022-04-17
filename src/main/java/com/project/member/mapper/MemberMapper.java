package com.project.member.mapper;

import java.util.List;

import com.project.board.vo.BoardVO;
import com.project.member.vo.LoginVO;
import com.webjjang.util.PageObject;

public interface MemberMapper {

	// interface만 만들어 두면 MyBatis 라이브러리에서 DAO를 대신 만들어 줌.
	// 주고 받는 데이터 타입 정의, sql문과 처리 명령문 필요-> Mapper.xml
	
	// 1-1. 리스트
	public List<BoardVO> list(PageObject pageObject) throws Exception;
	// 1-2. 전체 데이터 개수
	public long getTotalRow(PageObject pageObject) throws Exception;
	// 2-1. 보기
	public BoardVO view(int no) throws Exception;
	// 3. 회원가입
	public int write(BoardVO vo) throws Exception;
	// 4. 수정
	public int update(BoardVO vo) throws Exception;
	// 5. 탈퇴
	public int delete(int no) throws Exception;
	// 6. 로그인
	public LoginVO login(LoginVO invo) throws Exception;
}
