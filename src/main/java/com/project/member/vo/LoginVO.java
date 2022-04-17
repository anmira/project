package com.project.member.vo;

import java.util.Date;

import lombok.Data;

@Data //자동으로 getter setter 만들어줌.
public class LoginVO {

	private String gradeName;
	private int gradeNo;
	private String id;
	private String name;
	private String photo;
	private String pw;
	
}
