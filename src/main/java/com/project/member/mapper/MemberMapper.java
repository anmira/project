package com.project.member.mapper;

import java.util.List;

import com.project.board.vo.BoardVO;
import com.project.member.vo.LoginVO;
import com.webjjang.util.PageObject;

public interface MemberMapper {

	// interface�� ����� �θ� MyBatis ���̺귯������ DAO�� ��� ����� ��.
	// �ְ� �޴� ������ Ÿ�� ����, sql���� ó�� ��ɹ� �ʿ�-> Mapper.xml
	
	// 1-1. ����Ʈ
	public List<BoardVO> list(PageObject pageObject) throws Exception;
	// 1-2. ��ü ������ ����
	public long getTotalRow(PageObject pageObject) throws Exception;
	// 2-1. ����
	public BoardVO view(int no) throws Exception;
	// 3. ȸ������
	public int write(BoardVO vo) throws Exception;
	// 4. ����
	public int update(BoardVO vo) throws Exception;
	// 5. Ż��
	public int delete(int no) throws Exception;
	// 6. �α���
	public LoginVO login(LoginVO invo) throws Exception;
}
