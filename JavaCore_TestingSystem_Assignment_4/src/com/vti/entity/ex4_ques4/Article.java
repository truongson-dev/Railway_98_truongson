package com.vti.entity.ex4_ques4;

import java.time.LocalDate;

public class Article extends Document {
	private LocalDate dayRelease;

	public Article(int id, String publisher, int numRelease, LocalDate dayRelease) {
		super(id, publisher, numRelease);
		this.dayRelease = dayRelease;
	}

	public LocalDate getDayRelease() {
		return dayRelease;
	}

	public void setDayRelease(LocalDate dayRelease) {
		this.dayRelease = dayRelease;
	}

	@Override
	public String toString() {
		return super.toString() + ", dayRelease=" + dayRelease + ", type=Article}";
	}
}