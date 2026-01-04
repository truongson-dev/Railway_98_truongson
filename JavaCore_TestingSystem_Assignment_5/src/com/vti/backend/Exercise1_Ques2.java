package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.TuyenSinh;

public class Exercise1_Ques2 {
	private TuyenSinh tuyenSinh = new TuyenSinh();
	private Scanner scanner = new Scanner(System.in);

	public void question2() {
		while (true) {
			System.out.println("\n===== TUYEN SINH MENU =====");
			System.out.println("1. Insert contestant");
			System.out.println("2. View contestants");
			System.out.println("3. Find by ID");
			System.out.println("4. Exit");
			System.out.print("Choose: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Clear buffer

			switch (choice) {
			case 1:
				tuyenSinh.addContestant();
				break;
			case 2:
				tuyenSinh.showInfoContestant();
				break;
			case 3:
				System.out.print("Enter ID to search: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				tuyenSinh.findByIdNum(id);
				break;
			case 4:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}