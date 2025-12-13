package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;

public class Program {
	public static void main(String[] args) {
		System.out.println("===TESTING SYSTEM-QUESTION1,2,3===\n");

		// ===== QUESTION 2: Tạo ít nhất 3 đối tượng cho mỗi table =====

		// 1. Department - 3 đối tượng
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Marketing";

		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Sale";

		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "BOD";

		// 2. Position - 3 đối tượng
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.Dev;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.Test;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.PM;

		// 3. Account - 3 đối tượng
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "nguyenvanA@email.com";
		acc1.userName = "nguyenvana";
		acc1.fullName = "Nguyen Van A";
		acc1.department = dep1;
		acc1.position = pos1;
		acc1.createDate = LocalDate.now();

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "tranthiB@email.com";
		acc2.userName = "tranthib";
		acc2.fullName = "Tran Thi B";
		acc2.department = dep2;
		acc2.position = pos2;
		acc2.createDate = LocalDate.of(2023, 5, 15);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "levanC@email.com";
		acc3.userName = "levanc";
		acc3.fullName = "Le Van C";
		acc3.department = dep3;
		acc3.position = pos3;
		acc3.createDate = LocalDate.of(2024, 1, 10);

		// 4. Group - 3 đối tượng
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		group1.creator = acc1;
		group1.createDate = LocalDate.now();

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.creator = acc2;
		group2.createDate = LocalDate.now();

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Marketing Team";
		group3.creator = acc3;
		group3.createDate = LocalDate.now();

		// Thiết lập quan hệ Account - Group
		acc1.groups = new Group[] { group1, group2 };
		acc2.groups = new Group[] { group2 };
		acc3.groups = new Group[] { group3 };

		group1.accounts = new Account[] { acc1, acc2 };
		group2.accounts = new Account[] { acc1, acc2, acc3 };
		group3.accounts = new Account[] { acc3 };

		// 5. TypeQuestion - 3 đối tượng
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.name = TypeName.Essay;

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.name = TypeName.Multiple_Choice;

		TypeQuestion type3 = new TypeQuestion();
		type3.id = 3;
		type3.name = TypeName.Essay;

		// 6. CategoryQuestion - 3 đối tượng
		CategoryQuestion cate1 = new CategoryQuestion();
		cate1.id = 1;
		cate1.name = "Java";

		CategoryQuestion cate2 = new CategoryQuestion();
		cate2.id = 2;
		cate2.name = "SQL";

		CategoryQuestion cate3 = new CategoryQuestion();
		cate3.id = 3;
		cate3.name = ".NET";

		// 7. Question - 3 đối tượng
		Question q1 = new Question();
		q1.id = 1;
		q1.content = "What is Object-Oriented Programming?";
		q1.categoryQuestion = cate1;
		q1.typeQuestion = type1;
		q1.creator = acc1;
		q1.createDate = LocalDate.now();

		Question q2 = new Question();
		q2.id = 2;
		q2.content = "What is the difference between WHERE and HAVING in SQL?";
		q2.categoryQuestion = cate2;
		q2.typeQuestion = type2;
		q2.creator = acc2;
		q2.createDate = LocalDate.now();

		Question q3 = new Question();
		q3.id = 3;
		q3.content = "Explain polymorphism in C#";
		q3.categoryQuestion = cate3;
		q3.typeQuestion = type1;
		q3.creator = acc3;
		q3.createDate = LocalDate.now();

		// 8. Answer - 3 đối tượng
		Answer ans1 = new Answer();
		ans1.id = 1;
		ans1.content = "OOP is a programming paradigm based on objects";
		ans1.question = q1;
		ans1.isCorrect = true;

		Answer ans2 = new Answer();
		ans2.id = 2;
		ans2.content = "WHERE filters rows, HAVING filters groups";
		ans2.question = q2;
		ans2.isCorrect = true;

		Answer ans3 = new Answer();
		ans3.id = 3;
		ans3.content = "Polymorphism allows objects to take many forms";
		ans3.question = q3;
		ans3.isCorrect = true;

		// 9. Exam - 3 đối tượng
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "JAVA001";
		exam1.title = "Java Basic Exam";
		exam1.categoryQuestion = cate1;
		exam1.duration = 90;
		exam1.creator = acc1;
		exam1.createDate = LocalDate.now();

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "SQL001";
		exam2.title = "SQL Advanced Exam";
		exam2.categoryQuestion = cate2;
		exam2.duration = 120;
		exam2.creator = acc2;
		exam2.createDate = LocalDate.now();

		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "NET001";
		exam3.title = ".NET Framework Exam";
		exam3.categoryQuestion = cate3;
		exam3.duration = 60;
		exam3.creator = acc3;
		exam3.createDate = LocalDate.now();

		// ===== QUESTION 3: In ít nhất 1 giá trị của mỗi đối tượng =====

		System.out.println("=== IN THÔNG TIN CÁC ĐỐI TƯỢNG ===");
		System.out.println("----------Department--------");
		System.out.println("Department:" + dep1.id + " " + dep1.name);
		System.out.println("Department:" + dep2.id + " " + dep2.name);
		System.out.println("Department:" + dep3.id + " " + dep3.name);

		System.out.println("\n2. Position:");
		System.out.println("Position:" + pos1.id + " " + pos1.name);
		System.out.println("Position:" + pos2.id + " " + pos2.name);
		System.out.println("Position:" + pos3.id + " " + pos3.name);

		System.out.println("\n3. Account:");
		System.out.println("Account:" + acc1.id + " | " + acc1.userName + " | " + acc1.fullName + " | " + acc1.email);
		System.out.println("Account:" + acc2.id + " | " + acc2.userName + " | " + acc2.fullName + " | " + acc2.email);
		System.out.println("Account:" + acc3.id + " | " + acc3.userName + " | " + acc3.fullName + " | " + acc3.email);

		System.out.println("\n4. Group:");
		System.out.println("Group" + group1.id + ": " + group1.name);
		System.out.println("Group" + group2.id + ": " + group2.name);
		System.out.println("Group" + group3.id + ": " + group3.name);

		System.out.println("\n5. TypeQuestion:");
		System.out.println("   Type 1: " + type1.toString());
		System.out.println("   Type 2: " + type2.toString());
		System.out.println("   Type 3: " + type3.toString());

		System.out.println("\n6. CategoryQuestion:");
		System.out.println("   Category 1: " + cate1.toString());
		System.out.println("   Category 2: " + cate2.toString());
		System.out.println("   Category 3: " + cate3.toString());

		System.out.println("\n7. Question:");
		System.out.println("   Question 1: " + q1.toString());
		System.out.println("   Question 2: " + q2.toString());
		System.out.println("   Question 3: " + q3.toString());

		System.out.println("\n8. Answer:");
		System.out.println("   Answer 1: " + ans1.toString());
		System.out.println("   Answer 2: " + ans2.toString());
		System.out.println("   Answer 3: " + ans3.toString());

		System.out.println("\n9. Exam:");
		System.out.println("   Exam 1: " + exam1.toString());
		System.out.println("   Exam 2: " + exam2.toString());
		System.out.println("   Exam 3: " + exam3.toString());
	}
}