package com.vti.entity;

public class MyMath {
	// Overloading methods với các kiểu dữ liệu khác nhau
	public int sum(int a, int b) {
		return a + b;
	}

	public byte sum(byte a, byte b) {
		return (byte) (a + b);
	}

	public float sum(float a, float b) {
		return a + b;
	}

	// Các kết hợp khác
	public float sum(int a, float b) {
		return a + b;
	}

	public float sum(byte a, float b) {
		return a + b;
	}

	public int sum(byte a, int b) {
		return a + b;
	}
}