package com.vti.entity;

import com.vti.backend.InvalidAgeInputingException;

import utils.ScannerUtils;

public class AccountQues11 {
	public static int COUNT = 0;
	private int id;
	private String email;
	private String userName;
	private int age;

	public AccountQues11() throws InvalidAgeInputingException {
		super();
		System.out.println("Mời bạn nhập thông tin account cần tạo mới.");
		COUNT++;
		this.id = COUNT;
		System.out.print("Email: ");
		this.email = ScannerUtils.inputString();
		System.out.print("UserName: ");
		this.userName = ScannerUtils.inputString();
		this.age = inputAccountAge();
	}

	private int inputAccountAge() throws InvalidAgeInputingException {
		System.out.print("Age: ");
		while (true) {
			int ageInput = ScannerUtils.inputInt("Vui lòng nhập số tuổi hợp lệ: ");
			if (ageInput <= 0) {
				throw new InvalidAgeInputingException("The age must be greater than 0, please input again.");
			} else {
				if (ageInput < 18) {
					System.err.println("Your age must be greater than 18, input again: ");
				} else {
					return ageInput;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "AccountQues11 [id=" + id + ", email=" + email + ", userName=" + userName + ", age=" + age + "]";
	}
}