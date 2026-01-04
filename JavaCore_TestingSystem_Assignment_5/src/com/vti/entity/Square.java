// Hình vuông
package com.vti.entity;

public class Square extends Rectangle {

	public Square(float side) {
		super(side, side); // Gọi constructor của lớp cha
	}

	// Ghi đè phương thức để thêm thông báo
	@Override
	public float calculatePerimeter() {
		System.out.println("Tính chu vi theo Hình Vuông");
		return super.calculatePerimeter(); // Gọi phương thức của lớp cha
	}

	@Override
	public float calculateArea() {
		System.out.println("Tính diện tích theo Hình Vuông");
		return super.calculateArea(); // Gọi phương thức của lớp cha
	}
}