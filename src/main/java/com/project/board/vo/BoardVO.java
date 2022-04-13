package com.project.board.vo;

import java.util.Date;

import lombok.Data;

@Data //자동으로 getter setter 만들어줌.
public class BoardVO {

	private int no;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int hit;
	
}
