package com.vti.backend;

import com.vti.entity.Department;

public class Exercise2 {

	// Question 1: Chia 2 số với exception
	public static Float divide(int a, int b) {
		try {
			return (float) a / b;
		} catch (ArithmeticException e) {
			System.err.println("cannot divide 0");
			return null;
		}
	}

	// Question 2: Thêm finally
	public static Float divideWithFinally(int a, int b) {
		try {
			return (float) a / b;
		} catch (ArithmeticException e) {
			System.err.println("cannot divide 0");
			return null;
		} finally {
			System.out.println("divide completed!");
		}
	}

	// Question 3: Exception mảng
	public void question3() {
		int[] ints = { 1, 4, 6 };
		try {
			System.out.println(ints[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Không tìm thấy phần tử mảng: " + e.getMessage());
		}
	}

	// Question 4: Department array exception
	public void question4() {
		Department dep1 = new Department("Dep1");
		Department dep2 = new Department("Dep2");
		Department dep3 = new Department("Dep3");
		Department[] depArray = { dep1, dep2, dep3 };

		try {
			System.out.println(depArray[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Cannot find department.");
		}
	}

	// Method getIndex cho Department
	public static Department getIndex(Department[] departments, int index) {
		try {
			return departments[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Cannot find department.");
			return null;
		}
	}
}