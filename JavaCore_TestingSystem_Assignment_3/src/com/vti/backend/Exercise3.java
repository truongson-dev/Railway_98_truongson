package com.vti.backend;

public class Exercise3 {

	public void question1() {
		System.out.println("-------------Question1--------------");
		Integer salary = 5000;
		System.out.printf("%.2f%n", (float) salary);
	}

	public void question2() {
		System.out.println("-------------Question2--------------");
		String s = "1234567";
		int i = Integer.parseInt(s);
		System.out.println(i);
	}

	public void question3() {
		System.out.println("-------------Question3--------------");
		Integer i = 1234567;
		int i1 = i.intValue();
		System.out.println(i1);
	}
}