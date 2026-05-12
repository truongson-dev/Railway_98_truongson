package com.vti.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vti.entity.Exam;

public class Exercise3 {
	private Exam exam1, exam2;

	public void initData() {
		exam1 = new Exam();
		exam1.code = "EXAM001";
		exam1.createDate = new Date();

		exam2 = new Exam();
		exam2.code = "EXAM002";
		exam2.createDate = new Date();
	}

	public void question1() {
		System.out.println("Question 1: In ra thông tin Exam thứ 1 format theo định dạng vietnamese");
		Locale locale = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, locale);
		String date = dateFormat.format(exam1.createDate);
		System.out.println(exam1.code + ": " + date);
	}

	public void question2() {
		System.out.println("Question 2: In ra thông tin Exam đã tạo ngày nào theo định dạng yyyy-MM-dd-HH-mm-ss");
		String pattern = "yyyy-MM-dd-HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };
		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}

	public void question3() {
		System.out.println("Question 3: Chỉ in ra năm của create date");
		String pattern = "yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };
		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}

	public void question4() {
		System.out.println("Question 4: Chỉ in ra tháng và năm của create date");
		String pattern = "yyyy-MM";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };
		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}

	public void question5() {
		System.out.println("Question 5: Chỉ in ra MM-DD của create date");
		String pattern = "MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };
		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}
}