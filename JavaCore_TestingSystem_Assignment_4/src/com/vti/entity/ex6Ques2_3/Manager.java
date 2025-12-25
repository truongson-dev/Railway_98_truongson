package com.vti.entity.ex6Ques2_3;

public class Manager extends User {
	public Manager(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public double calculatePay() {
		return salaryRatio * 520;
	}
}