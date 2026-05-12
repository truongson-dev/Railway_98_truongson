package com.vti.entity;

import java.util.Date;

public class Exam {
	public String code;
	public Date createDate;

	public Exam() {
	}

	public Exam(String code, Date createDate) {
		this.code = code;
		this.createDate = createDate;
	}
}