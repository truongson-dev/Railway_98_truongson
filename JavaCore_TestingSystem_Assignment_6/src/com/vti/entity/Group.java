package com.vti.entity;

import java.time.LocalDate;

import utils.ScannerUtils;

public class Group {
	public static int COUNT = 0;
	private int id;
	private String name;
	private LocalDate createDate;
	private Account[] accounts;

	public Group() {
		super();
		System.out.println("Nhập thông tin tạo Group: ");
		COUNT++;
		this.id = COUNT;
		System.out.print("Nhập tên Group: ");
		this.name = ScannerUtils.inputString();
		System.out.print("Nhập ngày tạo Group (yyyy-MM-dd): ");
		this.createDate = ScannerUtils.inputLocalDate();
		System.out.print("Bạn có muốn thêm Account vào Group hay không? (1.Có, 2.Không): ");

		while (true) {
			int chooseAddAcc = ScannerUtils.inputIntPositive();
			switch (chooseAddAcc) {
			case 1:
				System.out.print("Nhập số lượng account muốn thêm vào Group này: ");
				int countAcc = ScannerUtils.inputIntPositive();
				Account[] accs = new Account[countAcc];
				for (int i = 0; i < countAcc; i++) {
					System.out.println("Nhập vào Account thứ " + (i + 1) + ": ");
					Account acc = new Account();
					accs[i] = acc;
				}
				this.accounts = accs;
				return;
			case 2:
				return;
			default:
				System.out.print("Nhập lại (1 hoặc 2): ");
				break;
			}
		}
	}

	public void printlnforGroup() {
		System.out.println("\n=== THÔNG TIN GROUP ===");
		System.out.println("ID: " + id);
		System.out.println("Tên: " + name);
		System.out.println("Ngày tạo: " + createDate);
		if (accounts != null) {
			System.out.println("Số lượng Account trong Group này là: " + accounts.length);
			for (Account account : accounts) {
				System.out.println("  " + account.toString());
			}
		} else {
			System.out.println("Group chưa có Account nào.");
		}
	}
}