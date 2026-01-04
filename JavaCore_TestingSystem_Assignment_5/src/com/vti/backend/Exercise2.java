package com.vti.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Student;

public class Exercise2 {
	private ArrayList<Student> students = new ArrayList<>();
	private Random random = new Random();
	private Scanner scanner = new Scanner(System.in);

	public void question1() {
		while (true) {
			System.out.println("\n===== STUDENT MANAGEMENT =====");
			System.out.println("1. Create 10 students");
			System.out.println("2. View all students");
			System.out.println("3. Roll call all students");
			System.out.println("4. Group 1 study");
			System.out.println("5. Group 2 clean");
			System.out.println("6. Exit");
			System.out.print("Choose: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				createStudents();
				break;
			case 2:
				viewStudents();
				break;
			case 3:
				rollCall();
				break;
			case 4:
				group1Study();
				break;
			case 5:
				group2Clean();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	private void createStudents() {
		students.clear();
		for (int i = 1; i <= 10; i++) {
			int group = random.nextInt(3) + 1; // Random group 1-3
			Student student = new Student("Student " + i, group);
			students.add(student);
		}
		System.out.println("Created 10 students successfully!");
	}

	private void viewStudents() {
		if (students.isEmpty()) {
			System.out.println("No students!");
			return;
		}

		for (Student s : students) {
			System.out.println(s);
		}
	}

	private void rollCall() {
		System.out.println("=== ROLL CALL ===");
		for (Student s : students) {
			s.diemDanh();
		}
	}

	private void group1Study() {
		System.out.println("=== GROUP 1 STUDY ===");
		for (Student s : students) {
			if (s.getGroup() == 1) {
				s.hocBai();
			}
		}
	}

	private void group2Clean() {
		System.out.println("=== GROUP 2 CLEAN ===");
		for (Student s : students) {
			if (s.getGroup() == 2) {
				s.donVeSinh();
			}
		}
	}
}