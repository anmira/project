package com.project.board.vo;

import java.util.Date;

import lombok.Data;

@Data //�ڵ����� getter setter �������.
public class BoardVO {

	private int no;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int hit;
	
}
