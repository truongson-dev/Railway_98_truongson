package com.vti.backend;

import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
	private Random random = new Random();

	public void question1() {
		System.out.println("---Question 1: In ngẫu nhiên ra 1 số nguyên---");
		int n = random.nextInt();
		System.out.println("Số ngẫu nhiên: " + n);
	}

	public void question2() {
		System.out.println("---Question 2: In ngẫu nhiên ra 1 số thực---");
		float f = random.nextFloat();
		System.out.println("Số ngẫu nhiên: " + f);
	}

	public void question3() {
		System.out.println("---Question 3: In ngẫu nhiên ra tên của 1 bạn---");
		String[] nameArr = { "A", "B", "D", "E", "F" };
		int i = random.nextInt(nameArr.length);
		System.out.println("Tên ngẫu nhiên 1 bạn trong lớp: " + nameArr[i]);
	}

	public void question4() {
		System.out.println("---Question 4: Lấy ngẫu nhiên 1 ngày trong khoảng 24-07-1995 tới 20-12-1995---");
		long minDay = LocalDate.of(1995, 7, 24).toEpochDay();
		long maxDay = LocalDate.of(1995, 12, 20).toEpochDay();
		long randomDay = minDay + random.nextInt((int) (maxDay - minDay));
		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		System.out.println("Ngày ngẫu nhiên: " + randomDate);
	}

	public void question5() {
		System.out.println("---Question 5: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây---");
		long now = LocalDate.now().toEpochDay();
		long randomDate = now - random.nextInt(365);
		LocalDate resultDate = LocalDate.ofEpochDay(randomDate);
		System.out.println("Ngày ngẫu nhiên là: " + resultDate);
	}

	public void question6() {
		System.out.println("---Question 6: Lấy ngẫu nhiên 1 ngày trong quá khứ---");
		long maxDay = LocalDate.now().toEpochDay();
		long randomDay = random.nextInt((int) maxDay);
		LocalDate resultDate = LocalDate.ofEpochDay(randomDay);
		System.out.println("1 Ngày ngẫu nhiên trong quá khứ: " + resultDate);
	}

	public void question7() {
		System.out.println("---Question 7: Lấy ngẫu nhiên 1 số có 3 chữ số---");
		int z = random.nextInt(999 - 100 + 1) + 100;
		System.out.println(z);
	}
}