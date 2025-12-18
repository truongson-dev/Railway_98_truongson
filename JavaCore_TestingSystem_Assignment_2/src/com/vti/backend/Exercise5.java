package com.vti.backend;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Exercise5 {

	// Question 1
	public static void question1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào 3 số nguyên");
		System.out.println("Nhập vào số 1: ");
		int a = sc.nextInt();

		System.out.println("Nhập vào số 2: ");
		int b = sc.nextInt();

		System.out.println("Nhập vào số 3: ");
		int c = sc.nextInt();

		System.out.println("Bạn vừa nhập vào các số: " + a + " " + b + " " + c);
	}

	// Question 2
	public static void question2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình---");
		System.out.println("Mời bạn nhập vào 2 số thực");
		System.out.println("Nhập vào số 1: ");
		float f1 = sc.nextFloat();

		System.out.println("Nhập vào số 2: ");
		float f2 = sc.nextFloat();

		System.out.println("Bạn vừa nhập vào các số: " + f1 + " " + f2);
	}

	// Question 3
	public static void question3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---Question 3: Viết lệnh cho phép người dùng nhập họ và tên---");
		System.out.println("Mời bạn nhập vào Họ: ");
		String s1 = sc.next();

		System.out.println("Mời bạn nhập vào Tên: ");
		String s2 = sc.next();

		System.out.println("Fullname của bạn là:" + s1 + " " + s2);
	}

	// Question 4
	public static void question4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ---");
		System.out.println("Mời bạn nhập vào năm sinh: ");
		int year = sc.nextInt();
		System.out.println("Mời bạn nhập vào tháng sinh: ");
		int month = sc.nextInt();
		System.out.println("Mời bạn nhập vào ngày sinh: ");
		int day = sc.nextInt();

		LocalDate dateBirth = LocalDate.of(year, month, day);
		System.out.println("Ngày sinh của bạn là: " + dateBirth);
	}

	// Question 5
	public static void question5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin account cần tạo: ");
		Account acc = new Account();
		System.out.println("Nhập ID: ");
		acc.id = sc.nextInt();
		System.out.println("Nhập email: ");
		acc.email = sc.next();
		System.out.println("Nhập userName: ");
		acc.userName = sc.next();
		System.out.println("Nhập fullName: ");
		acc.fullName = sc.next();
		System.out
				.println("Nhập position (Nhập các số từ 1 đến 4 tương ứng với: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");
		int posNum = sc.nextInt();

		switch (posNum) {
		case 1:
			Position pos1 = new Position();
			pos1.name = PositionName.Dev;
			acc.position = pos1;
			break;
		case 2:
			Position pos2 = new Position();
			pos2.name = PositionName.Test;
			acc.position = pos2;
			break;
		case 3:
			Position pos3 = new Position();
			pos3.name = PositionName.Scrum_Master;
			acc.position = pos3;
			break;
		case 4:
			Position pos4 = new Position();
			pos4.name = PositionName.PM;
			acc.position = pos4;
			break;
		}

		System.out.println("Thông tin Acc vừa nhập, ID: " + acc.id + " Email: " + acc.email + " UserName: "
				+ acc.userName + " FullName: " + acc.fullName + " Position: " + acc.position.name);
	}

	// Question 6
	public static void question6() {
		System.out.println("Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Mời bạn nhập vào thông tin Department cần tạo: ");
			Department dep = new Department();
			System.out.println("Nhập ID: ");
			dep.id = sc.nextInt();
			System.out.println("Nhập Name: ");
			dep.name = sc.next();

			System.out.println("Thông tin Department vừa nhập, ID: " + dep.id + " Name: " + dep.name);
		}
	}

	// Question 7
	public static void question7() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Hãy nhập vào 1 số chẵn: ");
			int a = sc.nextInt();
			if (a % 2 == 0) {
				System.out.println("Bạn vừa nhập vào:" + a);
				return;
			} else {
				System.out.println("Nhập sai, đây không phải là số chẵn");
			}
		}
	}

	// Question 8
	public static void question8() {
		System.out.println("Question 8: Viết chương trình thực hiện theo flow");
		try (Scanner sc = new Scanner(System.in)) {
			int choose;
			while (true) {
				System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department");
				choose = sc.nextInt();
				if (choose == 1 || choose == 2) {
					switch (choose) {
					case 1:
						question5();
						break;
					case 2:
						question6();
						break;
					}
					return;
				} else {
					System.out.println("Nhập lại: ");
				}
			}
		}
	}

	// Question 9
	public static void question9() {
		Scanner sc = new Scanner(System.in);

		// Tạo Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing_System";
		group1.createDate = LocalDate.of(2021, 1, 1);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = LocalDate.of(2020, 2, 1);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";
		group3.createDate = LocalDate.of(2019, 9, 23);

		// Tạo Account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daonq1";
		acc1.userName = "daonq1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.createDate = LocalDate.now();

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daonq2";
		acc2.userName = "daonq2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.createDate = LocalDate.of(2021, 3, 17);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daonq3";
		acc3.userName = "daonq3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.createDate = LocalDate.now();

		Account[] accArray = { acc1, acc2, acc3 };
		Group[] groupArray = { group1, group2, group3 };

		System.out.println("Danh sách User đang có trên hệ thống: ");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println(accArray[i].userName);
		}

		System.out.println("Nhập vào UserName của account: ");
		String userName = sc.next();

		System.out.println("Danh sách Group đang có trên hệ thống: ");
		for (int i = 0; i < groupArray.length; i++) {
			System.out.println(groupArray[i].name);
		}

		System.out.println("Nhập vào tên Group cần thêm: ");
		String groupName = sc.next();

		int indexGroup = -1;
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i].name.equals(groupName)) {
				indexGroup = i;
			}
		}

		int indexAccount = -1;
		for (int j = 0; j < accArray.length; j++) {
			if (accArray[j].userName.equals(userName)) {
				indexAccount = j;
			}
		}

		if (indexAccount < 0 || indexGroup < 0) {
			System.out.println("Kiểm tra lại thông tin bạn nhập, không có Account hoặc group này trên hệ thống");
		} else {
			for (int j = 0; j < accArray.length; j++) {
				if (accArray[j].userName.equals(userName)) {
					Group[] gpAdd = { groupArray[indexGroup] };
					accArray[j].groups = gpAdd;
				}
			}
			System.out.println("Bạn vừa Add group: " + accArray[indexAccount].groups[0].name + " cho Account: "
					+ accArray[indexAccount].userName);
		}
	}

	// Question 10
	public static void question10() {
		System.out.println("Question 8: Viết chương trình thực hiện theo flow");
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department, 3.Add Group vào Account");
			choose = sc.nextInt();
			if (choose == 1 || choose == 2 || choose == 3) {
				switch (choose) {
				case 1:
					question5();
					break;
				case 2:
					question6();
					break;
				case 3:
					question9();
					break;
				}
				System.out.println("Bạn có muốn tiếp tục không, hãy chọn Menu, Chọn 0 để thoát chương trình!");
				int ak = sc.nextInt();
				if (ak == 0) {
					System.out.println("Bye!!!");
					return;
				}
			} else {
				System.out.println("Nhập lại: ");
			}
		}
	}

	// Question 11
	public static void question11() {
		System.out.println("Question 8: Viết chương trình thực hiện theo flow");
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println(
					"Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department, 3.Add Group vào Account, 4. Thêm Account vào 1 nhóm ngẫu nhiên");
			choose = sc.nextInt();
			if (choose == 1 || choose == 2 || choose == 3 || choose == 4) {
				switch (choose) {
				case 1:
					question5();
					break;
				case 2:
					question6();
					break;
				case 3:
					question9();
					break;
				case 4:
					addAccountToRandomGroup();
					break;
				}
				System.out.println("Bạn có muốn tiếp tục không, hãy chọn Menu, Chọn 0 để thoát chương trình!");
				int ak = sc.nextInt();
				if (ak == 0) {
					System.out.println("Bye!!!");
					return;
				}
			} else {
				System.out.println("Nhập lại: ");
			}
		}
	}

	private static void addAccountToRandomGroup() {
		try (Scanner sc = new Scanner(System.in)) {
			// Tạo Group
			Group group1 = new Group();
			group1.id = 1;
			group1.name = "Testing_System";
			group1.createDate = LocalDate.of(2021, 1, 1);

			Group group2 = new Group();
			group2.id = 2;
			group2.name = "Development";
			group2.createDate = LocalDate.of(2020, 2, 1);

			Group group3 = new Group();
			group3.id = 3;
			group3.name = "Sale";
			group3.createDate = LocalDate.of(2019, 9, 23);

			// Tạo Account
			Account acc1 = new Account();
			acc1.id = 1;
			acc1.email = "daonq1";
			acc1.userName = "daonq1";
			acc1.fullName = "Dao Nguyen 1";

			Account acc2 = new Account();
			acc2.id = 2;
			acc2.email = "daonq2";
			acc2.userName = "daonq2";
			acc2.fullName = "Dao Nguyen 2";
			acc2.createDate = LocalDate.of(2021, 3, 17);

			Account acc3 = new Account();
			acc3.id = 3;
			acc3.email = "daonq3";
			acc3.userName = "daonq3";
			acc3.fullName = "Dao Nguyen 3";
			acc3.createDate = LocalDate.now();

			Account[] accArray = { acc1, acc2, acc3 };
			Group[] groupArray = { group1, group2, group3 };

			System.out.println("Danh sách User đang có trên hệ thống: ");
			for (int i = 0; i < accArray.length; i++) {
				System.out.println(accArray[i].userName);
			}

			System.out.println("Nhập vào UserName của account: ");
			String userName = sc.next();

			System.out.println("Danh sách Group đang có trên hệ thống: ");
			for (int i = 0; i < groupArray.length; i++) {
				System.out.println(groupArray[i].name);
			}

			java.util.Random random = new java.util.Random();
			int indexGroup = random.nextInt(3);

			int indexAccount = -1;
			for (int j = 0; j < accArray.length; j++) {
				if (accArray[j].userName.equals(userName)) {
					indexAccount = j;
				}
			}

			if (indexAccount < 0) {
				System.out.println("Kiểm tra lại thông tin bạn nhập, không có Account này trên hệ thống");
			} else {
				for (int j = 0; j < accArray.length; j++) {
					if (accArray[j].userName.equals(userName)) {
						Group[] gpAdd = { groupArray[indexGroup] };
						accArray[j].groups = gpAdd;
						System.out.println("Bạn vừa Add group: " + accArray[indexAccount].groups[0].name
								+ " cho Account: " + accArray[indexAccount].userName);
					}
				}
			}
		}
	}
}