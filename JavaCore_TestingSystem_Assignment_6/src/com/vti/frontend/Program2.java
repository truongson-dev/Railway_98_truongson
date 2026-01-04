package com.vti.frontend;

import com.vti.backend.Exercise2;
import com.vti.entity.Department;

import utils.ScannerUtils;

public class Program2 {
	public static void main(String[] args) {
		Exercise2 exercise2 = new Exercise2();

		System.out.println("=== DEMO EXERCISE 2: EXCEPTION ===");

		System.out.println("\n--- Question 1: Divide với exception ---");
		Float result = Exercise2.divide(7, 0);
		System.out.println("Kết quả: " + result);

		System.out.println("\n--- Question 2: Divide với finally ---");
		result = Exercise2.divideWithFinally(10, 2);
		System.out.println("Kết quả: " + result);

		System.out.println("\n--- Question 3: Array exception ---");
		exercise2.question3();

		System.out.println("\n--- Question 4: Department array ---");
		Department[] departments = { new Department("Sale"), new Department("Marketing"), new Department("HR") };

		Department dept = Exercise2.getIndex(departments, 1);
		System.out.println("Department tại index 1: " + dept);

		Department dept2 = Exercise2.getIndex(departments, 10);
		System.out.println("Department tại index 10: " + dept2);

		System.out.println("\n--- Question 5 & 6: ScannerUtils Demo ---");
		System.out.print("Vui lòng nhập tuổi: ");
		int age = ScannerUtils.inputAge();
		System.out.println("Tuổi của bạn là: " + age);

		System.out.println("\n=== KẾT THÚC DEMO ===");
	}
}