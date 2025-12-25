package com.vti.backend;

import com.vti.entity.Account_Ques2;
import com.vti.entity.Circle;
import com.vti.entity.Date;
import com.vti.entity.Student;

public class Exercise4 {

	// Question 1: Student Encapsulation
	public void question1() {
		System.out.println("=== Question 1: Student Encapsulation ===");

		Student student1 = new Student("Nguyen Van A", "Ha Noi");
		student1.plusScore(3.5f);
		System.out.println("Student 1: " + student1);

		Student student2 = new Student("Tran Thi B", "Hai Phong");
		student2.setScore(5.5f);
		System.out.println("Student 2: " + student2);

		Student student3 = new Student("Le Van C", "Da Nang");
		student3.plusScore(7.5f);
		System.out.println("Student 3: " + student3);

		Student student4 = new Student("Pham Thi D", "Ho Chi Minh");
		student4.plusScore(9.0f);
		System.out.println("Student 4: " + student4);
	}

	// Question 2: Circle, Account, Date
	public void question2() {
		System.out.println("\n=== Question 2: Circle, Account, Date ===");

		// Circle
		System.out.println("--- Circle Demo ---");
		Circle circle1 = new Circle();
		System.out.println("Circle 1 (default): " + circle1);

		Circle circle2 = new Circle(2.5);
		System.out.println("Circle 2 (radius=2.5): " + circle2);

		Circle circle3 = new Circle(3.0, "blue");
		System.out.println("Circle 3 (radius=3.0, color=blue): " + circle3);

		// Account
		System.out.println("\n--- Account Demo ---");
		Account_Ques2 acc1 = new Account_Ques2("ACC001", "John", 1000);
		Account_Ques2 acc2 = new Account_Ques2("ACC002", "Jane", 500);

		System.out.println("Initial:");
		System.out.println("  " + acc1);
		System.out.println("  " + acc2);

		acc1.credit(500);
		System.out.println("After credit 500 to acc1: " + acc1.getBalance());

		acc1.debit(200);
		System.out.println("After debit 200 from acc1: " + acc1.getBalance());

		acc1.transferTo(acc2, 300);
		System.out.println("After transfer 300 from acc1 to acc2:");
		System.out.println("  " + acc1);
		System.out.println("  " + acc2);

		// Date
		System.out.println("\n--- Date Demo ---");
		Date date1 = new Date(15, 6, 2023);
		System.out.println("Date 1: " + date1);
		System.out.println("Is leap year 2023? " + date1.isLeapYear());

		Date date2 = new Date(29, 2, 2024);
		System.out.println("Date 2: " + date2);
		System.out.println("Is leap year 2024? " + date2.isLeapYear());
	}
}