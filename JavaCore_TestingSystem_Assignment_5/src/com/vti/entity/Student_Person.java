package com.vti.entity;

import java.util.Scanner;

public class Student_Person extends Person {
	private int id;
	private float gradeAvg;
	private String email;

	@Override
	public void inputInfo() {
		super.inputInfo();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student ID: ");
		this.id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter grade average: ");
		this.gradeAvg = scanner.nextFloat();
		scanner.nextLine();

		System.out.print("Enter email: ");
		this.email = scanner.nextLine();
	}

	@Override
	public String showInfo() {
		return super.showInfo() + ", ID: " + id + ", Grade Average: " + gradeAvg + ", Email: " + email;
	}

	public boolean hasScholarship() {
		return gradeAvg >= 8.0;
	}
}