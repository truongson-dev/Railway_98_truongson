package com.vti.frontend;

public class Program3 {
	public static void main(String[] args) {
//	Viết chương trình tính tổng của 5 số
//	1 4 7 9 13

//		int number1 = 1;
//		int number2 = 4;                        
//		int number3 = 7;
//		int number4 = 9;
//		int number5 = 13;
// Thay vì lưu nhiều biến thì lưu thành mảng

		int[] numbers = { 1, 4, 7, 9, 13 };

		System.out.println("Phần tử số 0 trong mảng: " + numbers[0]);
		System.out.println("Phần tử số 0 trong mảng: " + numbers[1]);
		System.out.println("Phần tử số 0 trong mảng: " + numbers[2]);
		System.out.println("Phần tử số 0 trong mảng: " + numbers[3]);

		int result = numbers[0] + numbers[1] + numbers[2] + numbers[3];
		System.out.println("Tổng các phần tử là: " + result);
	}
}
