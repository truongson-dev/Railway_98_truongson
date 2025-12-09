package com.vti.frontend;

import com.vti.entity.Student;

public class Program4 {
// Hàm main 
	public static void main(String[] args) {
//	Tạo ra các bạn học viên trong chương trình
		Student student1 = new Student();
		student1.name = "Sơn";
		student1.age = 20;

//		học viên 2
		Student student2 = new Student();
		student2.name = "Đức";
		student2.age = 24;

//		học viên 3
		Student student3 = new Student();
		student3.name = "Lâm";
		student3.age = 22;

		System.out.println("Thông tin bạn học viên 1, Tên: " + student1.name + ", Tuổi: " + student1.age);
		System.out.println("Thông tin bạn học viên 2, Tên: " + student2.name + ", Tuổi: " + student2.age);
		System.out.println("Thông tin bạn học viên 2, Tên: " + student3.name + ", Tuổi: " + student3.age);
	}

}
