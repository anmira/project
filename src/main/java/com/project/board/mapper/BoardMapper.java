package com.project.board.mapper;

import java.util.List;

import com.project.board.vo.BoardVO;
import com.webjjang.util.PageObject;

public interface BoardMapper {

	// interface�� ����� �θ� MyBatis ���̺귯������ DAO�� ��� ����� ��.
	// �ְ� �޴� ������ Ÿ�� ����, sql�� �ʿ�.
	
	// 1-1. ����Ʈ
	public List<BoardVO> list(PageObject pageObject) throws Exception;
	// 1-2. ��ü ������ ����
	public long getTotalRow(PageObject pageObject) throws Exception;
	// 2-1. ����
	public BoardVO view(int no) throws Exception;
	// 2-2. ��ȸ�� 1����
	public int increase(int no) throws Exception;
	// 3. �۾���
	public int write(BoardVO vo) throws Exception;
	// 4. ����
	public int update(BoardVO vo) throws Exception;
	// 5. ����
	public int delete(int no) throws Exception;
	
}
