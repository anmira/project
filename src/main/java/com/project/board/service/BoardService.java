package com.project.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.board.mapper.BoardMapper;
import com.project.board.vo.BoardVO;
import com.webjjang.util.PageObject;

@Service
public class BoardService {

	@Inject
	private BoardMapper mapper;

	// 1. list
	public List<BoardVO> list(PageObject pageObject) throws Exception{
		// ��ü ������ ���� �������� ó���� �ؾ� ���� �ٰ� ���� ��� ��. ������ �����͸� �Ȱ�����.
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		System.out.println("BoardService.list().pageObject - " +pageObject);
		return mapper.list(pageObject);
	}
	
	// 2. view
	public BoardVO view (int no, int inc) throws Exception{
		System.out.println("BoardService.list().no, inc - " +no + ","+ inc);
		if(inc == 1) mapper.increase(no);
		return mapper.view(no);
	}
	
	// 3. write
	public int write(BoardVO vo) throws Exception{
		return mapper.write(vo);
	}
	
	
}
