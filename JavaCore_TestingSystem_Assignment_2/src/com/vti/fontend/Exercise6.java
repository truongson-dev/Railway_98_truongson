package com.vti.fontend;

import java.time.LocalDate;

import com.vti.entity.Account;

public class Exercise6 {

	// Question 1
	public static void question1() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	// Question 2
	public static void question2() {
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daonq1";
		acc1.userName = "daonq1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.createDate = LocalDate.now();

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daonq2";
		acc2.userName = "daonq2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.createDate = LocalDate.of(2021, 3, 17);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daonq3";
		acc3.userName = "daonq3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.createDate = LocalDate.now();

		printAccount(acc1);
		printAccount(acc2);
		printAccount(acc3);
	}

	private static void printAccount(Account account) {
		System.out.println("ID: " + account.id + " Email: " + account.email + " Username: " + account.userName
				+ " FullName: " + account.fullName + " CreateDate: " + account.createDate);
	}

	// Question 3
	public static void question3() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}