package com.vti.entity;

import utils.ScannerUtils;

public class Account {
	public static int COUNT = 0;
	private int id;
	private String email;
	private String userName;
	private String fullName;

	public Account() {
		super();
		System.out.println("Nhập thông tin Account: ");
		COUNT++;
		this.id = COUNT;
		System.out.print("Nhập Email: ");
		this.email = ScannerUtils.inputString();
		System.out.print("Nhập userName: ");
		this.userName = ScannerUtils.inputString();
		System.out.print("Nhập fullName: ");
		this.fullName = ScannerUtils.inputString();
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName + "]";
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUserName() {
		return userName;
	}

	public String getFullName() {
		return fullName;
	}
}