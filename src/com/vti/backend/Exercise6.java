package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;

public class Exercise6 {
	public void question1() {
		System.out.println("Question 1: In ra các số chẵn nguyên dương nhỏ hơn 10");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public void question2() {
		System.out.println("Question 2: In thông tin các account");
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daong1";
		acc1.userName = "daong1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.createDate = LocalDate.now();

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daong2";
		acc2.userName = "daong2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.createDate = LocalDate.of(2021, 3, 17);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daong3";
		acc3.userName = "daong3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.createDate = LocalDate.now();

		printAccount(acc1);
		printAccount(acc2);
		printAccount(acc3);
	}

	private void printAccount(Account account) {
		System.out.println("ID: " + account.id + " Email: " + account.email + " Username: " + account.userName
				+ " FullName: " + account.fullName + " CreateDate: " + account.createDate);
	}

	public void question3() {
		System.out.println("Question 3: In ra các số nguyên dương nhỏ hơn 10");
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}