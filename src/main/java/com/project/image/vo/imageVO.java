package com.project.image.vo;

import java.util.Date;

import lombok.Data;

// lombok ���̺귯���� ������ ���(������ �� ��) - ������, setter(), getter(), toString()�� �ڵ����� �������.
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
