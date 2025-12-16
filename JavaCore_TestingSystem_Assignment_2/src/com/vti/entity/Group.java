package com.vti.entity;

import java.time.LocalDate;

public class Group {
	public int id;
	public String name;
	public LocalDate createDate;
	public Account[] accounts;

	public Group() {
	}

	public Group(int id, String name, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}
}