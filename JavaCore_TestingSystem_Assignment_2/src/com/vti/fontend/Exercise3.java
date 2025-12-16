package com.vti.fontend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vti.entity.Exam;

public class Exercise3 {

	// Question 1
	public static void question1() {
		Exam exam1 = new Exam();
		exam1.code = "EXAM001";
		exam1.createDate = new Date();

		Locale locale = new Locale("vn", "VN");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", locale);
		String date = dateFormat.format(exam1.createDate);
		System.out.println(exam1.code + ": " + date);
	}

	// Question 2
	public static void question2() {
		Exam exam1 = new Exam();
		exam1.code = "EXAM001";
		exam1.createDate = new Date();

		Exam exam2 = new Exam();
		exam2.code = "EXAM002";
		exam2.createDate = new Date();

		String pattern = "yyyy-MM-dd-HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };

		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}

	// Question 3
	public static void question3() {
		Exam exam1 = new Exam();
		exam1.code = "EXAM001";
		exam1.createDate = new Date();

		Exam exam2 = new Exam();
		exam2.code = "EXAM002";
		exam2.createDate = new Date();

		String pattern = "yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };

		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}

	// Question 4
	public static void question4() {
		Exam exam1 = new Exam();
		exam1.code = "EXAM001";
		exam1.createDate = new Date();

		Exam exam2 = new Exam();
		exam2.code = "EXAM002";
		exam2.createDate = new Date();

		String pattern = "yyyy-MM";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };

		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}

	// Question 5
	public static void question5() {
		Exam exam1 = new Exam();
		exam1.code = "EXAM001";
		exam1.createDate = new Date();

		Exam exam2 = new Exam();
		exam2.code = "EXAM002";
		exam2.createDate = new Date();

		String pattern = "MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };

		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}
}