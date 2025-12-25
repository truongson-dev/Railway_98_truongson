package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

public class Exercise1 {
	public void question1() {
		System.out.println("=== Question 1: Department Constructors ===");
		Department dep1 = new Department();
		System.out.println("Department 1: " + dep1);

		Department dep2 = new Department("Sale");
		System.out.println("Department 2: " + dep2);
	}

	public void question2() {
		System.out.println("\n=== Question 2: Account Constructors ===");

		Account acc1 = new Account();
		System.out.println("Account 1 (no params): " + acc1);

		Account acc2 = new Account(1, "test@email.com", "user1", "Nguyen", "Van A");
		System.out.println("Account 2: " + acc2);

		Position pos = new Position(1, "Developer");
		Account acc3 = new Account(2, "test2@email.com", "user2", "Tran", "Thi B", pos);
		System.out.println("Account 3: " + acc3);

		Account acc4 = new Account(3, "test3@email.com", "user3", "Le", "Van C", pos, LocalDate.of(2023, 1, 15));
		System.out.println("Account 4: " + acc4);
	}

	public void question3() {
		System.out.println("\n=== Question 3: Group Constructors ===");

		Group group1 = new Group();
		System.out.println("Group 1 (no params): " + group1);

		Account creator = new Account(1, "creator@email.com", "creator", "Creator", "Name");
		Account[] accounts = { new Account(2, "member1@email.com", "member1", "Member", "One"),
				new Account(3, "member2@email.com", "member2", "Member", "Two") };
		Group group2 = new Group("Group A", creator, accounts, LocalDate.now());
		System.out.println("Group 2: " + group2);

		String[] usernames = { "user1", "user2", "user3" };
		Group group3 = new Group("Group B", creator, usernames, LocalDate.now());
		System.out.println("Group 3: " + group3);
	}
}