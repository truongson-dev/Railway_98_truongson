package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Exercise1 {
	private Account acc1, acc2, acc3;
	private Department dep1, dep2, dep3;
	private Position pos1, pos2, pos3;
	private Group group1, group2, group3;

	public void initData() {
		// Tạo Department
		dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Marketing";
		dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Sale";
		dep3 = new Department();
		dep3.id = 3;
		dep3.name = "BOO";

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
		acc1.email = "daong1";
		acc1.userName = "daong1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.department = dep1;
		acc1.position = pos1;
		acc1.createDate = LocalDate.now();
		acc1.groups = new Group[] { group1, group2 };

		acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daong2";
		acc2.userName = "daong2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.department = dep2;
		acc2.position = pos2;
		acc2.createDate = LocalDate.of(2021, 3, 17);
		acc2.groups = new Group[] { group3, group2 };

		acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daong3";
		acc3.userName = "daong3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.department = dep3;
		acc3.position = pos3;
		acc3.createDate = LocalDate.now();

		// Thiết lập quan hệ Group - Account
		group1.accounts = new Account[] { acc1 };
		group2.accounts = new Account[] { acc1, acc2 };
		group3.accounts = new Account[] { acc2 };
	}

	public void question1() {
		System.out.println("---Question 1 Check acc2:---");
		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban.");
		} else {
			System.out.println("Phòng ban của nv này là: " + acc2.department.name);
		}
	}

	public void question2() {
		System.out.println("---Question 2: Làm theo IF ---");
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {
			int countGroup = acc2.groups.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			} else if (countGroup == 3) {
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			} else if (countGroup >= 4) {
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			}
		}
	}

	public void question3() {
		System.out.println("---Question 3: Sử dụng toán từ ternary để làm Question 1---");
		String result = (acc2.department == null) ? "Nhân viên này chưa có phòng ban."
				: "Phòng của nhân viên này là: " + acc2.department.name;
		System.out.println(result);
	}

	public void question4() {
		System.out.println("---Question 4: sử dụng Terry cho Position---");
		String result = (acc1.position.name == PositionName.Dev) ? "Đây là Developer"
				: "Người này không phải là Developer";
		System.out.println(result);
	}

	public void question5() {
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

	public void question6() {
		System.out.println("---Question 6: Check số lượng Group nhân viên tham gia: Switch Case ---");
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

	public void question7() {
		System.out.println("---Question 7: Sử dụng switch case để làm lại Question 4---");
		switch (acc1.position.name) {
		case Dev:
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}
	}

	public void question8() {
		System.out.println("---FOREACH Question 8:---");
		Account[] accArray = { acc1, acc2, acc3 };
		for (Account account : accArray) {
			System.out.println("AccountID: " + account.id + " Email: " + account.email + " Name: " + account.fullName
					+ " Department: " + account.department.name);
		}
	}

	public void question9() {
		System.out.println("---Question 9: In thông tin phòng ban: ---");
		Department[] depArray = { dep1, dep2, dep3 };
		for (Department department : depArray) {
			System.out.println("DepID: " + department.id + " Name: " + department.name);
		}
	}

	public void question10() {
		System.out.println("---FOR Question 10: In thông tin account:---");
		Account[] accArray = { acc1, acc2 };
		for (int i = 0; i < accArray.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Full name: " + accArray[i].fullName);
			System.out.println("Phòng ban: " + accArray[i].department.name);
		}
	}

	public void question11() {
		System.out.println("---Question 11: Thông tin phòng ban:---");
		Department[] depArray = { dep1, dep2, dep3 };
		for (int i = 0; i < depArray.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].id);
			System.out.println("Name: " + depArray[i].name);
		}
	}

	public void question12() {
		System.out.println("---Question 12: Thông tin phòng ban:---");
		Department[] depArray = { dep1, dep2, dep3 };
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].id);
			System.out.println("Name: " + depArray[i].name);
		}
	}

	public void question13() {
		System.out.println("---Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2: ---");
		Account[] accArray = { acc1, acc2, acc3 };
		for (int i = 0; i < accArray.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accArray[i].email);
				System.out.println("Full name: " + accArray[i].fullName);
				System.out.println("Phòng ban: " + accArray[i].department.name);
			}
		}
	}

	public void question14() {
		System.out.println("---Question 14: In ra thông tin tất cả các account có id < 4---");
		Account[] accArray = { acc1, acc2, acc3 };
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i].id < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accArray[i].email);
				System.out.println("Full name: " + accArray[i].fullName);
				System.out.println("Phòng ban: " + accArray[i].department.name);
			}
		}
	}

	public void question15() {
		System.out.println("---Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20---");
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public void question16() {
		System.out.println("---WHILE Question 16:---");

		// Q16-10
		System.out.println("---FOR Question 16-10: In thông tin account:---");
		Account[] accArray1 = { acc1, acc2, acc3 };
		int i = 0;
		while (i < accArray1.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Full name: " + accArray1[i].fullName);
			System.out.println("Phòng ban: " + accArray1[i].department.name);
			i++;
		}

		// Q16-11
		System.out.println("---Question 16-11: Thông tin phòng ban: ---");
		Department[] depArray1 = { dep1, dep2, dep3 };
		int j = 0;
		while (j < depArray1.length) {
			System.out.println("Thông tin department thứ " + (j + 1) + " là:");
			System.out.println("Id: " + depArray1[j].id);
			System.out.println("Name: " + depArray1[j].name);
			j++;
		}

		// Q16-12
		System.out.println("---Question 16-12: Thông tin phòng ban: ---");
		Department[] depArray2 = { dep1, dep2, dep3 };
		int ii = 0;
		while (ii < 2) {
			System.out.println("Thông tin department thứ " + (ii + 1) + " là:");
			System.out.println("Id: " + depArray2[ii].id);
			System.out.println("Name: " + depArray2[ii].name);
			ii++;
		}

		// Q16-13
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

		// Q16-14
		System.out.println("---Question 16-14: In ra thông tin tất cả các account có id < 4---");
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

		// Q16-15
		System.out.println("---Question 16-15: In ra các số chẵn nhỏ hơn hoặc bằng 20---");
		int i4 = 1;
		while (i4 <= 20) {
			if (i4 % 2 == 0) {
				System.out.print(i4 + " ");
			}
			i4++;
		}
		System.out.println();
	}

	public void question17() {
		System.out.println("---DO-WHILE Question 17:---");

		// Q17-10
		System.out.println("---FOR Question 17-10: In thông tin account:---");
		Account[] accArray1 = { acc1, acc2, acc3 };
		int i = 0;
		do {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Full name: " + accArray1[i].fullName);
			System.out.println("Phòng ban: " + accArray1[i].department.name);
			i++;
		} while (i < accArray1.length);

		// Q17-11
		System.out.println("---Question 17-11: Thông tin phòng ban:---");
		Department[] depArray1 = { dep1, dep2, dep3 };
		int j = 0;
		do {
			System.out.println("Thông tin department thứ " + (j + 1) + " là:");
			System.out.println("Id: " + depArray1[j].id);
			System.out.println("Name: " + depArray1[j].name);
			j++;
		} while (j < depArray1.length);

		// Q17-12
		System.out.println("---Question 17-12: Thông tin phòng ban:---");
		Department[] depArray2 = { dep1, dep2, dep3 };
		int ii = 0;
		do {
			System.out.println("Thông tin department thứ " + (ii + 1) + " là:");
			System.out.println("Id: " + depArray2[ii].id);
			System.out.println("Name: " + depArray2[ii].name);
			ii++;
		} while (ii < 2);

		// Q17-13
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

		// Q17-14
		System.out.println("---Question 17-14: In ra thông tin tất cả các account có id < 4---");
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

		// Q17-15
		System.out.println("---Question 17-15: In ra các số chẵn nhỏ hơn hoặc bằng 20---");
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