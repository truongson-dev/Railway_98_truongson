// Hình chữ nhật
package com.vti.entity;

public class Rectangle {
	protected float length;
	protected float width;

	public Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
	}

	public float calculatePerimeter() {
		System.out.println("Tính chu vi theo Hình Chữ Nhật");
		return 2 * (length + width);
	}

	public float calculateArea() {
		System.out.println("Tính diện tích theo Hình Chữ Nhật");
		return length * width;
	}
}