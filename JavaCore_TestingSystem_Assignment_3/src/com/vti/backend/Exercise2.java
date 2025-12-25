package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;

public class Exercise2 {

	public void question1() {
		System.out.println("Khởi tạo mảng Account gồm 5 phần tử sử dụng For");
		Account[] accArray = new Account[5];

		for (int i = 0; i < accArray.length; i++) {
			Account acc = new Account();
			acc.id = i + 1;
			acc.email = "Email " + (i + 1);
			acc.userName = "User name " + (i + 1);
			acc.fullName = "Full name " + (i + 1);
			acc.createDate = LocalDate.now();
			accArray[i] = acc;

			System.out.println("Thông tin Account " + (i + 1) + " Email: " + accArray[i].email + " UserName: "
					+ accArray[i].userName + " FullName: " + accArray[i].fullName + " CreateDate: "
					+ accArray[i].createDate);
		}
	}
}