package com.vti.entity;

public class Block {
	private String name;
	private String subject;

	public Block(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		switch (name.toUpperCase()) {
		case "A":
			return "Toán, Lý, Hóa";
		case "B":
			return "Toán, Hóa, Sinh";
		case "C":
			return "Văn, Sử, Địa";
		default:
			return "Unknown";
		}
	}
}