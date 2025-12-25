package com.vti.entity.ex4_ques4;

import java.time.LocalDate;

public class Magazine extends Document {
	private int issueNumber;
	private LocalDate monthRelease;

	public Magazine(int id, String publisher, int numRelease, int issueNumber, LocalDate monthRelease) {
		super(id, publisher, numRelease);
		this.issueNumber = issueNumber;
		this.monthRelease = monthRelease;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public LocalDate getMonthRelease() {
		return monthRelease;
	}

	public void setMonthRelease(LocalDate monthRelease) {
		this.monthRelease = monthRelease;
	}

	@Override
	public String toString() {
		return super.toString() + ", issueNumber=" + issueNumber + ", monthRelease=" + monthRelease
				+ ", type=Magazine}";
	}
}