package com.vti.entity;

public class Account_Ques2 {
	private String id;
	private String name;
	private int balance;

	public Account_Ques2(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public int credit(int amount) {
		balance += amount;
		return balance;
	}

	public int debit(int amount) {
		if (amount <= balance) {
			balance -= amount;
		} else {
			System.out.println("Số dư không đủ!");
		}
		return balance;
	}

	public void transferTo(Account_Ques2 account, int amount) {
		if (amount <= balance) {
			this.debit(amount);
			account.credit(amount);
			System.out.println("Chuyển " + amount + " từ tài khoản " + this.id + " sang " + account.id);
		} else {
			System.out.println("Số dư không đủ để chuyển!");
		}
	}

	@Override
	public String toString() {
		return "Account_Ques2{id='" + id + "', name='" + name + "', balance=" + balance + "}";
	}
}