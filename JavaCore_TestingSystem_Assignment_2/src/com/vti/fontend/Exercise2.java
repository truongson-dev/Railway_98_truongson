package com.vti.fontend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vti.entity.Account;

public class Exercise2 {

	// Question 1
	public static void question1() {
		System.out
				.println("Question 1:Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó");
		int i = 5;
		System.out.printf("%d%n", i);
	}

	// Question 2
	public static void question2() {
		System.out.println(
				"Question 2:Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó ");
		int ii = 100000000;
		System.out.printf(Locale.US, "%d%n", ii);
	}

	// Question 3
	public static void question3() {
		System.out.println("---Question 3:---");
		float c = 5.567098f;
		System.out.printf("%5.4f%n", c);
	}

	// Question 4
	public static void question4() {
		System.out.println("---Question 4:---");
		String s = "Nguyễn Văn A";
		System.out.printf("Tên tôi là \"" + s + "\" và tôi đang độc thân\n");
	}

	// Question 5
	public static void question5() {
		System.out.println("---Question 5:---");
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
	}

	// Question 6
	public static void question6() {
		// Tạo dữ liệu tạm
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daonq1";
		acc1.userName = "daonq1";
		acc1.fullName = "Dao Nguyen 1";

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daonq2";
		acc2.userName = "daonq2";
		acc2.fullName = "Dao Nguyen 2";

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daonq3";
		acc3.userName = "daonq3";
		acc3.fullName = "Dao Nguyen 3";

		Account[] accArray = { acc1, acc2, acc3 };

		System.out.println("+----+----------+-------------+");
		System.out.println("| ID |  Email   |   FullName  |");
		System.out.println("+----+----------+-------------+");
		for (Account account : accArray) {
			System.out.printf("| %2d | %8s | %11s |%n", account.id, account.email, account.fullName);
		}
		System.out.println("+----+----------+-------------+");
	}
}