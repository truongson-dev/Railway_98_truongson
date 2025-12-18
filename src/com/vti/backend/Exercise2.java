package com.vti.backend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exercise2 {
	public void question1() {
		System.out.println(
				"Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó");
		int i = 5;
		System.out.printf("%d%n", i);
	}

	public void question2() {
		System.out.println(
				"Question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng 100,000,000");
		int ii = 100000000;
		System.out.printf(Locale.US, "%,d%n", ii);
	}

	public void question3() {
		System.out.println("---Question 3:---");
		float c = 5.567098f;
		System.out.printf("%5.4f%n", c);
	}

	public void question4() {
		System.out.println("---Question 4:---");
		String s = "Nguyễn Văn A";
		System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân%n", s);
	}

	public void question5() {
		System.out.println("---Question 5:---");
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
	}

	public void question6() {
		System.out.println("Question 6: In ra thông tin account theo định dạng table");
		// Cần có dữ liệu account để in
		System.out.println("Chưa implement đầy đủ");
	}
}