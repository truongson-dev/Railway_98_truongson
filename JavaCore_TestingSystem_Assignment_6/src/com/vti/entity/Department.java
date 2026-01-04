package com.vti.entity;

import utils.ScannerUtils;

public class Department {
	public static int COUNT = 0;
	private int id;
	private String name;

	// Constructor có tham số
	public Department(String name) {
		super();
		COUNT++;
		this.id = COUNT;
		this.name = name;
	}

	// Constructor không tham số - tự động nhập
	public Department() {
		super();
		COUNT++;
		this.id = COUNT;
		System.out.print("Nhập tên phòng: ");
		this.name = ScannerUtils.inputString();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}