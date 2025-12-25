package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float score;

	public Student(String name, String hometown) {
		this.name = name;
		this.hometown = hometown;
		this.score = 0;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public void plusScore(float score) {
		this.score += score;
	}

	@Override
	public String toString() {
		String rank;
		if (score < 4.0) {
			rank = "Yếu";
		} else if (score < 6.0) {
			rank = "Trung bình";
		} else if (score < 8.0) {
			rank = "Khá";
		} else {
			rank = "Giỏi";
		}

		return "Student{id=" + id + ", name='" + name + "', hometown='" + hometown + "', score=" + score + ", rank='"
				+ rank + "'}";
	}
}