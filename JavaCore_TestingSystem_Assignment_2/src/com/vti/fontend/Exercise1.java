package com.vti.fontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Exercise1 {

	private static Department dep1, dep2, dep3;
	private static Position pos1, pos2, pos3;
	private static Group group1, group2, group3;
	private static Account acc1, acc2, acc3;

	static {
		// Tạo dữ liệu
		dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Marketing";

		dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Sale";

		dep3 = new Department();
		dep3.id = 3;
		dep3.name = "BOD";

		// Tạo Position
		pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.Dev;

		pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.PM;

		pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.Scrum_Master;

		// Tạo Group
		group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		group1.createDate = LocalDate.of(2021, 1, 1);

		group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = LocalDate.of(2020, 2, 1);

		group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";
		group3.createDate = LocalDate.of(2019, 9, 23);

		// Tạo Account
		acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daonq1";
		acc1.userName = "daonq1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.department = dep1;
		acc1.position = pos1;
		acc1.createDate = LocalDate.now();
		Group[] groupAcc1 = { group1, group2 };
		acc1.groups = groupAcc1;

		acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daonq2";
		acc2.userName = "daonq2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.department = dep2;
		acc2.position = pos2;
		acc2.createDate = LocalDate.of(2021, 3, 17);
		acc2.groups = new Group[] { group3, group2 };

		acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daonq3";
		acc3.userName = "daonq3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.department = dep3;
		acc3.position = pos3;
		acc3.createDate = LocalDate.now();

		// Add Group Account
		group1.accounts = new Account[] { acc1 };
		group2.accounts = new Account[] { acc1, acc2 };
		group3.accounts = new Account[] { acc2 };
	}

	// Question 1
	public static void question1() {
		System.out.println("---Question 1 Check acc2:---");
		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban.");
		} else {
			System.out.println("Phòng ban của nv này là: " + acc2.department.name);
		}
	}

	// Question 2
	public static void question2() {
		System.out.println("---Question 2: Làm theo IF ---");
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {
			int countGroup = acc2.groups.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			}
			if (countGroup == 3) {
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			}
			if (countGroup >= 4) {
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			}
		}
	}

	// Question 3
	public static void question3() {
		System.out.println("---Question 3: Sử dụng toán từ ternary để làm Question 1---");
		System.out.println(acc2.department == null ? "Nhân viên này chưa có phòng ban."
				: "Phòng ban của nv này là: " + acc2.department.name);
	}

	// Question 4
	public static void question4() {
		System.out.println("---Question 4: sử dụng Terry cho Position---");
		System.out.println(
				acc1.position.name.toString() == "Dev" ? "Day 1a Developer" : "Người này không phải là Developer");
	}

	// Question 5
	public static void question5() {
		System.out.println("---Question 5: Số lượng acc trong nhóm 1---");
		if (group1.accounts == null) {
			System.out.println("Group chưa có thành viên nào tham gia");
		} else {
			int countAccInGroup = group1.accounts.length;
			switch (countAccInGroup) {
			case 1:
				System.out.println("Nhóm có một thành viên");
				break;
			case 2:
				System.out.println("Nhóm có hai thành viên");
				break;
			case 3:
				System.out.println("Nhóm có ba thành viên");
				break;
			default:
				System.out.println("Nhóm có nhiều thành viên");
				break;
			}
		}
	}

	// Question 6
	public static void question6() {
		System.out.println("---Question 6: Check số lượng Group nhân viên tham witch Case ---");
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {
			switch (acc2.groups.length) {
			case 1:
			case 2:
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				break;
			case 3:
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
				break;
			default:
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
				break;
			}
		}
	}

	// Question 7
	public static void question7() {
		System.out.println("---Question 7: Sử dụng switch case để làm lại Question 4---");
		String positionName = acc1.position.name.toString();
		switch (positionName) {
		case "Dev":
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}
	}

	// Question 8
	public static void question8() {
		System.out.println("---FOREACH Question 8:---");
		Account[] accArray = { acc1, acc2, acc3 };
		for (Account account : accArray) {
			System.out.println("AccountID: " + account.id + " Email: " + account.email + " Name: " + account.fullName);
		}
	}

	// Question 9
	public static void question9() {
		System.out.println("---Question 9: In thông tin phòng ban: ---");
		Department[] depArray = { dep1, dep2, dep3 };
		for (Department department : depArray) {
			System.out.println("DepID: " + department.id + " Name: " + department.name);
		}
	}

	// Question 10
	public static void question10() {
		System.out.println("---FOR Question 10: In thông tin account:---");
		Account[] accArray1 = { acc1, acc2 };
		for (int i = 0; i < accArray1.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Full name: " + accArray1[i].fullName);
			System.out.println("Phòng ban: " + accArray1[i].department.name);
		}
	}

	// Question 11
	public static void question11() {
		System.out.println("---------Question 11: Thông tin phòng ban:---------");
		Department[] depArray1 = { dep1, dep2, dep3 };
		for (int i = 0; i < depArray1.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray1[i].id);
			System.out.println("Name: " + depArray1[i].name);
		}
	}

	// Question 12
	public static void question12() {
		System.out.println("---------Question 12: Thông tin phòng ban:---------");
		Department[] depArray2 = { dep1, dep2, dep3 };
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray2[i].id);
			System.out.println("Name: " + depArray2[i].name);
		}
	}

	// Question 13
	public static void question13() {
		System.out.println(
				"----------Question 13:In ra thông tin tất cả các account ngoại trừ account thứ 2: ------------");
		Account[] accArray2 = { acc1, acc2, acc3 };
		for (int i = 0; i < accArray2.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accArray2[i].email);
				System.out.println("Full name: " + accArray2[i].fullName);
				System.out.println("Phòng ban: " + accArray2[i].department.name);
			}
		}
	}

	// Question 14
	public static void question14() {
		System.out.println("---------- Question 14: In ra thông tin tất cả các account có id < 4 -----------");
		Account[] accArray3 = { acc1, acc2, acc3 };
		for (int j = 0; j < accArray3.length; j++) {
			if (accArray3[j].id < 4) {
				System.out.println("Thông tin account thứ " + (j + 1) + " là:");
				System.out.println("Email: " + accArray3[j].email);
				System.out.println("Full name: " + accArray3[j].fullName);
				System.out.println("Phòng ban: " + accArray3[j].department.name);
			}
		}
	}

	// Question 15
	public static void question15() {
		System.out.println("---Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20---");
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	// Question 16
	public static void question16() {
		// Question 16-10
		System.out.println("---FOR Question 16- 10: In thông tin account:---");
		Account[] accArray1 = { acc1, acc2, acc3 };
		int i = 0;
		while (i < accArray1.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Full name: " + accArray1[i].fullName);
			System.out.println("Phòng ban: " + accArray1[i].department.name);
			i++;
		}

		// Question 16-11
		System.out.println("---Question 16-11: Thông tin phòng ban: ---");
		Department[] depArray1 = { dep1, dep2, dep3 };
		int j = 0;
		while (j < depArray1.length) {
			System.out.println("Thông tin department thứ " + (j + 1) + " là:");
			System.out.println("Id: " + depArray1[j].id);
			System.out.println("Name: " + depArray1[j].name);
			j++;
		}

		// Question 16-12
		System.out.println("---Question 16-12: Thông tin phòng ban: ---");
		Department[] depArray2 = { dep1, dep2, dep3 };
		int i1 = 0;
		while (i1 < 2) {
			System.out.println("Thông tin department thứ " + (i1 + 1) + " là:");
			System.out.println("Id: " + depArray2[i1].id);
			System.out.println("Name: " + depArray2[i1].name);
			i1++;
		}

		// Question 16-13
		System.out.println("---Question 16-13:In ra thông tin tất cả các account ngoại trừ account thứ 2: ---");
		Account[] accArray2 = { acc1, acc2, acc3 };
		int i2 = 0;
		while (i2 < accArray2.length) {
			if (i2 != 1) {
				System.out.println("Thông tin account thứ " + (i2 + 1) + " là:");
				System.out.println("Email: " + accArray2[i2].email);
				System.out.println("Full name: " + accArray2[i2].fullName);
				System.out.println("Phòng ban: " + accArray2[i2].department.name);
			}
			i2++;
		}

		// Question 16-14
		System.out.println("--- Question 16-14: In ra thông tin tất cả các account có id < 4---");
		Account[] accArray3 = { acc1, acc2, acc3 };
		int i3 = 0;
		while (i3 < accArray3.length) {
			if (accArray3[i3].id < 4) {
				System.out.println("Thông tin account thứ " + (i3 + 1) + " là:");
				System.out.println("Email: " + accArray3[i3].email);
				System.out.println("Full name: " + accArray3[i3].fullName);
				System.out.println("Phòng ban: " + accArray3[i3].department.name);
			}
			i3++;
		}

		// Question 16-15
		System.out.println("---Question 16- 15: In ra các số chẵn nhỏ hơn hoặc bằng 20---");
		int i4 = 1;
		while (i4 <= 20) {
			if (i4 % 2 == 0) {
				System.out.print(i4 + " ");
			}
			i4++;
		}
		System.out.println();
	}

	// Question 17
	public static void question17() {
		// Question 17-10
		System.out.println("---FOR Question 17- 10: In thông tin account:---");
		Account[] accArray1 = { acc1, acc2, acc3 };
		int i = 0;
		do {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Full name: " + accArray1[i].fullName);
			System.out.println("Phòng ban: " + accArray1[i].department.name);
			i++;
		} while (i < accArray1.length);

		// Question 17-11
		System.out.println("---Question 17-11. Thông tin phòng ban:---");
		Department[] depArray1 = { dep1, dep2, dep3 };
		int j = 0;
		do {
			System.out.println("Thông tin department thứ " + (j + 1) + " là:");
			System.out.println("Id: " + depArray1[j].id);
			System.out.println("Name: " + depArray1[j].name);
			j++;
		} while (j < depArray1.length);

		// Question 17-12
		System.out.println("---Question 17-12: Thông tin phòng ban:---");
		Department[] depArray2 = { dep1, dep2, dep3 };
		int i1 = 0;
		do {
			System.out.println("Thông tin department thứ " + (i1 + 1) + " là:");
			System.out.println("Id: " + depArray2[i1].id);
			System.out.println("Name: " + depArray2[i1].name);
			i1++;
		} while (i1 < 2);

		// Question 17-13
		System.out.println("---Question 17-13:In ra thông tin tất cả các account ngoại trừ account thứ 2: ---");
		Account[] accArray2 = { acc1, acc2, acc3 };
		int i2 = 0;
		do {
			if (i2 != 1) {
				System.out.println("Thông tin account thứ " + (i2 + 1) + " là:");
				System.out.println("Email: " + accArray2[i2].email);
				System.out.println("Full name: " + accArray2[i2].fullName);
				System.out.println("Phòng ban: " + accArray2[i2].department.name);
			}
			i2++;
		} while (i2 < accArray2.length);

		// Question 17-14
		System.out.println("--- Question 17-14: In ra thông tin tất cả các account có id < 4---");
		Account[] accArray3 = { acc1, acc2, acc3 };
		int i3 = 0;
		do {
			if (accArray3[i3].id < 4) {
				System.out.println("Thông tin account thứ " + (i3 + 1) + " là:");
				System.out.println("Email: " + accArray3[i3].email);
				System.out.println("Full name: " + accArray3[i3].fullName);
				System.out.println("Phòng ban: " + accArray3[i3].department.name);
			}
			i3++;
		} while (i3 < accArray3.length);

		// Question 17-15
		System.out.println("---Question 17- 15: In ra các số chẵn nhỏ hơn hoặc bằng 20---");
		int i4 = 1;
		do {
			if (i4 % 2 == 0) {
				System.out.print(i4 + " ");
			}
			i4++;
		} while (i4 <= 20);
		System.out.println();
	}
}