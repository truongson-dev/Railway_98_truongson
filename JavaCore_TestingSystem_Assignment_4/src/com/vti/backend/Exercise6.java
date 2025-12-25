package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.ex6.VietnamesePhone;
import com.vti.entity.ex6Ques2_3.Employee;
import com.vti.entity.ex6Ques2_3.Manager;
import com.vti.entity.ex6Ques2_3.User;
import com.vti.entity.ex6Ques2_3.Waiter;

public class Exercise6 {
	private Scanner scanner = new Scanner(System.in);

	// Question 1: Phone Contact Management
	public void question1() {
		System.out.println("=== Question 1: Phone Contact Management ===");

		VietnamesePhone phone = new VietnamesePhone();
		boolean running = true;

		while (running) {
			System.out.println("\n===== QUẢN LÝ DANH BẠ =====");
			System.out.println("1. Thêm contact");
			System.out.println("2. Xóa contact");
			System.out.println("3. Cập nhật contact");
			System.out.println("4. Tìm kiếm contact");
			System.out.println("5. Hiển thị tất cả contacts");
			System.out.println("6. Thoát");
			System.out.print("Chọn chức năng: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.print("Nhập tên: ");
				String name = scanner.nextLine();
				System.out.print("Nhập số điện thoại: ");
				String phoneNumber = scanner.nextLine();
				phone.insertContact(name, phoneNumber);
				break;

			case 2:
				System.out.print("Nhập tên contact cần xóa: ");
				String removeName = scanner.nextLine();
				phone.removeContact(removeName);
				break;

			case 3:
				System.out.print("Nhập tên contact cần cập nhật: ");
				String updateName = scanner.nextLine();
				System.out.print("Nhập số điện thoại mới: ");
				String newPhone = scanner.nextLine();
				phone.updateContact(updateName, newPhone);
				break;

			case 4:
				System.out.print("Nhập tên contact cần tìm: ");
				String searchName = scanner.nextLine();
				phone.searchContact(searchName);
				break;

			case 5:
				phone.printContacts();
				break;

			case 6:
				running = false;
				System.out.println("Thoát chương trình!");
				break;

			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		}
	}

	// Question 2 & 3: User Salary Management
	public void question23() {
		System.out.println("\n=== Question 2 & 3: User Salary Management ===");

		boolean running = true;

		while (running) {
			System.out.println("\n===== QUẢN LÝ NHÂN SỰ =====");
			System.out.println("1. Thêm Employee");
			System.out.println("2. Thêm Manager");
			System.out.println("3. Thêm Waiter");
			System.out.println("4. Thoát");
			System.out.print("Chọn chức năng: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.print("Nhập tên Employee: ");
				String empName = scanner.nextLine();
				System.out.print("Nhập salary ratio: ");
				double empRatio = scanner.nextDouble();

				User employee = new Employee(empName, empRatio);
				employee.displayInfor();
				break;

			case 2:
				System.out.print("Nhập tên Manager: ");
				String mgrName = scanner.nextLine();
				System.out.print("Nhập salary ratio: ");
				double mgrRatio = scanner.nextDouble();

				User manager = new Manager(mgrName, mgrRatio);
				manager.displayInfor();
				break;

			case 3:
				System.out.print("Nhập tên Waiter: ");
				String waitName = scanner.nextLine();
				System.out.print("Nhập salary ratio: ");
				double waitRatio = scanner.nextDouble();

				User waiter = new Waiter(waitName, waitRatio);
				waiter.displayInfor();
				break;

			case 4:
				running = false;
				System.out.println("Thoát chương trình!");
				break;

			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		}
	}
}