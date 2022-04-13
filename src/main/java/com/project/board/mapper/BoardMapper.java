package com.project.board.mapper;

import java.util.List;

import com.project.board.vo.BoardVO;
import com.webjjang.util.PageObject;

public interface BoardMapper {

	// interface만 만들어 두면 MyBatis 라이브러리에서 DAO를 대신 만들어 줌.
	// 주고 받는 데이터 타입 정의, sql문 필요.
	
	// 1-1. 리스트
	public List<BoardVO> list(PageObject pageObject) throws Exception;
	// 1-2. 전체 데이터 개수
	public long getTotalRow(PageObject pageObject) throws Exception;
	// 2-1. 보기
	public BoardVO view(int no) throws Exception;
	// 2-2. 조회수 1증가
	public int increase(int no) throws Exception;
	// 3. 글쓰기
	public int write(BoardVO vo) throws Exception;
	// 4. 수정
	public int update(BoardVO vo) throws Exception;
	// 5. 삭제
	public int delete(int no) throws Exception;
	
}
