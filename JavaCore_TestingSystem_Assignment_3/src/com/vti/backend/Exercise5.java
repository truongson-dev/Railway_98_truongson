package com.vti.backend;

import java.util.Arrays;
import java.util.Comparator;

import com.vti.entity.Department;

public class Exercise5 {

	private Department[] createDepartments() {
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Boss of director";

		Department department4 = new Department();
		department4.id = 4;
		department4.name = "Waiting room";

		Department department5 = new Department();
		department5.id = 5;
		department5.name = "Accounting";

		return new Department[] { department1, department2, department3, department4, department5 };
	}

	public void question1() {
		Department[] departments = createDepartments();
		System.out.println("Thông tin phòng ban thứ 1:");
		System.out.println(departments[0].toString());
	}

	public void question2() {
		Department[] departments = createDepartments();
		System.out.println("Thông tin tất cả phòng ban:");
		for (Department department : departments) {
			System.out.println(department);
		}
	}

	public void question3() {
		Department[] departments = createDepartments();
		System.out.println("Địa chỉ của phòng ban thứ 1:");
		System.out.println(departments[0].hashCode());
	}

	public void question4() {
		Department[] departments = createDepartments();
		if (departments[0].name.equals("Phòng A")) {
			System.out.println("Có tên là phòng A");
		} else {
			System.out.println("Không tên là phòng A");
		}
	}

	public void question5() {
		Department[] departments = createDepartments();
		if (departments[0].equals(departments[1])) {
			System.out.println("Có bằng nhau!");
		} else {
			System.out.println("Không bằng nhau!");
		}
	}

	public void question6() {
		Department[] departments = createDepartments();

		// Sắp xếp theo tên tăng dần (A-Z)
		Arrays.sort(departments, new Comparator<Department>() {
			@Override
			public int compare(Department d1, Department d2) {
				return d1.name.compareToIgnoreCase(d2.name);
			}
		});

		System.out.println("Danh sách phòng ban sắp xếp theo tên (A-Z):");
		for (Department department : departments) {
			System.out.println(department.name);
		}
	}

	public void question7() {
		Department[] departments = createDepartments();

		// Sắp xếp theo tên (tương tự question6)
		Arrays.sort(departments, new Comparator<Department>() {
			@Override
			public int compare(Department d1, Department d2) {
				return d1.name.compareToIgnoreCase(d2.name);
			}
		});

		System.out.println("Danh sách phòng ban sắp xếp theo tên:");
		for (Department department : departments) {
			System.out.println(department.name);
		}
	}
}