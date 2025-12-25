package com.vti.backend;

import java.util.Scanner;

public class Exercise1 {

	public void question_1() {
		float salary1 = 5240.5f;
		float salary2 = 10970.055f;

		System.out.println("Salary1: " + salary1 + " || Salary2: " + salary2);

		int roundSalary1 = (int) salary1;
		int roundSalary2 = (int) salary2;

		System.out.println("roundSalary1: " + roundSalary1 + " || roundSalary2: " + roundSalary2);
	}

	public void question2() {
		int min = 0;
		int max = 99999;
		int a = (int) (Math.random() * max) + min;
		while (a < 10000) {
			a = a * 10;
		}
		System.out.println("Số ngẫu nhiên: " + a);
	}

	public void question3() {
		// Tạo số ngẫu nhiên như Question2
		int min = 0;
		int max = 99999;
		int a = (int) (Math.random() * max) + min;
		while (a < 10000) {
			a = a * 10;
		}
		System.out.println("===Question2=====");
		System.out.println("Số ngẫu nhiên: " + a);

		System.out.println("=====Question3=======");
		// Cách 1: Dùng String
		String b = String.valueOf(a);
		System.out.println("Hai số cuối (String): " + b.substring(b.length() - 2));

		// Cách 2: Dùng toán tử %
		System.out.println("Hai số cuối (Math): " + (a % 100));
	}

	public void question4() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập a = ");
		int a = scanner.nextInt();

		int b;
		do {
			System.out.print("Nhập b = ");
			b = scanner.nextInt();
			if (b == 0) {
				System.out.println("Vui lòng nhập b khác 0!");
			}
		} while (b == 0);

		float thuong = (float) a / b;
		System.out.println("Thương: " + thuong);
	}

	public void question1() {
		// TODO Auto-generated method stub

	}
}