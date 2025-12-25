package com.vti.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.entity.Employee;
import com.vti.entity.Engineer;
import com.vti.entity.Staff;
import com.vti.entity.Staff.Gender;
import com.vti.entity.Worker;
import com.vti.entity.inheritance.HighSchoolStudent;

public class Exercise5 {
	private ArrayList<Staff> staffList = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	// Question 1: Inheritance demonstration
	public void question1() {
		System.out.println("=== Question 1: Inheritance ===");

		Worker worker = new Worker("Nguyen Van A", 25, Gender.MALE, "Ha Noi", 5);
		Engineer engineer = new Engineer("Tran Thi B", 30, Gender.FEMALE, "Hai Phong", "IT");
		Employee employee = new Employee("Le Van C", 28, Gender.MALE, "Da Nang", "Admin");

		System.out.println(worker);
		System.out.println(engineer);
		System.out.println(employee);
	}

	// Question 2: Staff Management System
	public void question2() {
		System.out.println("\n=== Question 2: Staff Management System ===");

		boolean running = true;
		while (running) {
			System.out.println("\n===== MENU QUẢN LÝ CÁN BỘ =====");
			System.out.println("1. Thêm mới cán bộ");
			System.out.println("2. Tìm kiếm theo họ tên");
			System.out.println("3. Hiển thị danh sách cán bộ");
			System.out.println("4. Xóa cán bộ theo tên");
			System.out.println("5. Thoát");
			System.out.print("Chọn chức năng: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				addStaff();
				break;
			case 2:
				searchStaff();
				break;
			case 3:
				displayStaff();
				break;
			case 4:
				deleteStaff();
				break;
			case 5:
				running = false;
				System.out.println("Thoát chương trình!");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		}
	}

	private void addStaff() {
		System.out.println("\nChọn loại cán bộ:");
		System.out.println("1. Công nhân");
		System.out.println("2. Kỹ sư");
		System.out.println("3. Nhân viên");
		System.out.print("Chọn: ");
		int type = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Nhập tên: ");
		String name = scanner.nextLine();

		System.out.print("Nhập tuổi: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Nhập giới tính (1-Male, 2-Female, 3-Unknown): ");
		int genderChoice = scanner.nextInt();
		scanner.nextLine();
		Gender gender = Gender.UNKNOWN;
		if (genderChoice == 1) {
			gender = Gender.MALE;
		} else if (genderChoice == 2) {
			gender = Gender.FEMALE;
		}

		System.out.print("Nhập địa chỉ: ");
		String address = scanner.nextLine();

		switch (type) {
		case 1: // Worker
			System.out.print("Nhập bậc (1-10): ");
			int rank = scanner.nextInt();
			staffList.add(new Worker(name, age, gender, address, rank));
			System.out.println("Đã thêm công nhân!");
			break;
		case 2: // Engineer
			System.out.print("Nhập chuyên ngành: ");
			String specialized = scanner.nextLine();
			staffList.add(new Engineer(name, age, gender, address, specialized));
			System.out.println("Đã thêm kỹ sư!");
			break;
		case 3: // Employee
			System.out.print("Nhập công việc: ");
			String task = scanner.nextLine();
			staffList.add(new Employee(name, age, gender, address, task));
			System.out.println("Đã thêm nhân viên!");
			break;
		}
	}

	private void searchStaff() {
		System.out.print("Nhập tên cần tìm: ");
		String name = scanner.nextLine();

		boolean found = false;
		for (Staff staff : staffList) {
			if (staff.getName().toLowerCase().contains(name.toLowerCase())) {
				System.out.println(staff);
				found = true;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy cán bộ có tên: " + name);
		}
	}

	private void displayStaff() {
		if (staffList.isEmpty()) {
			System.out.println("Danh sách cán bộ trống!");
		} else {
			System.out.println("\n===== DANH SÁCH CÁN BỘ =====");
			for (Staff staff : staffList) {
				System.out.println(staff);
			}
			System.out.println("Tổng số: " + staffList.size() + " cán bộ");
		}
	}

	private void deleteStaff() {
		System.out.print("Nhập tên cần xóa: ");
		String name = scanner.nextLine();

		Iterator<Staff> iterator = staffList.iterator();
		boolean removed = false;

		while (iterator.hasNext()) {
			Staff staff = iterator.next();
			if (staff.getName().equalsIgnoreCase(name)) {
				iterator.remove();
				removed = true;
			}
		}

		if (removed) {
			System.out.println("Đã xóa cán bộ có tên: " + name);
		} else {
			System.out.println("Không tìm thấy cán bộ có tên: " + name);
		}
	}

	// Question 3: Constructor Inheritance
	public void question3() {
		System.out.println("\n=== Question 3: Constructor Inheritance ===");

		HighSchoolStudent student = new HighSchoolStudent("Nam", 1, "Chuyên Văn", "Đại học công nghệ");
		System.out.println("High School Student: " + student);
	}
}