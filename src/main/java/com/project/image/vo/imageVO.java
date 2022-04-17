package com.project.image.vo;

import java.util.Date;

import lombok.Data;

// lombok 라이브러리가 저장할 당시(컴파일 할 때) - 생성자, setter(), getter(), toString()을 자동으로 만들어줌.
@Data
public class imageVO {
	
	private int no;
	private String title;
	private String content;
	private String id;
	private String name;
	private Date writeDate;
	private String fileName;
	
}
