package com.vti.entity;

public class Student implements IStudent {
	private static int COUNT = 0;
	private int id;
	private String name;
	private int group;

	public Student(String name, int group) {
		COUNT++;
		this.id = COUNT;
		this.name = name;
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getGroup() {
		return group;
	}

	@Override
	public void diemDanh() {
		System.out.println(name + " điểm danh.");
	}

	@Override
	public void hocBai() {
		System.out.println(name + " đang học bài.");
	}

	@Override
	public void donVeSinh() {
		System.out.println(name + " đi dọn vệ sinh.");
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Group: " + group;
	}
}