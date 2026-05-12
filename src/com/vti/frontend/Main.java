package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise1;
import com.vti.backend.Exercise2;
import com.vti.backend.Exercise3;
import com.vti.backend.Exercise4;
import com.vti.backend.Exercise5;
import com.vti.backend.Exercise6;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n========== MENU CHÍNH ==========");
			System.out.println("1. Exercise 1 - Flow Control");
			System.out.println("2. Exercise 2 - System out printf");
			System.out.println("3. Exercise 3 - Date Format");
			System.out.println("4. Exercise 4 - Random Number");
			System.out.println("5. Exercise 5 - Input from console");
			System.out.println("6. Exercise 6 - Method");
			System.out.println("0. Thoát chương trình");
			System.out.print("Chọn exercise (0-6): ");

			int exerciseChoice = scanner.nextInt();

			switch (exerciseChoice) {
			case 1:
				showExercise1Menu();
				break;
			case 2:
				showExercise2Menu();
				break;
			case 3:
				showExercise3Menu();
				break;
			case 4:
				showExercise4Menu();
				break;
			case 5:
				showExercise5Menu();
				break;
			case 6:
				showExercise6Menu();
				break;
			case 0:
				System.out.println("Thoát chương trình!");
				return;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		}
	}

	private static void showExercise1Menu() {
		Scanner scanner = new Scanner(System.in);
		Exercise1 ex1 = new Exercise1();
		ex1.initData();

		while (true) {
			System.out.println("\n========== EXERCISE 1 - FLOW CONTROL ==========");
			System.out.println("Chọn question (1-17, 0 để quay lại):");

			int question = scanner.nextInt();
			switch (question) {
			case 1:
				ex1.question1();
				break;
			case 2:
				ex1.question2();
				break;
			case 3:
				ex1.question3();
				break;
			case 4:
				ex1.question4();
				break;
			case 5:
				ex1.question5();
				break;
			case 6:
				ex1.question6();
				break;
			case 7:
				ex1.question7();
				break;
			case 8:
				ex1.question8();
				break;
			case 9:
				ex1.question9();
				break;
			case 10:
				ex1.question10();
				break;
			case 11:
				ex1.question11();
				break;
			case 12:
				ex1.question12();
				break;
			case 13:
				ex1.question13();
				break;
			case 14:
				ex1.question14();
				break;
			case 15:
				ex1.question15();
				break;
			case 16:
				ex1.question16();
				break;
			case 17:
				ex1.question17();
				break;
			case 0:
				return;
			default:
				System.out.println("Question không tồn tại!");
			}
		}
	}

	private static void showExercise2Menu() {
		Scanner scanner = new Scanner(System.in);
		Exercise2 ex2 = new Exercise2();

		while (true) {
			System.out.println("\n========== EXERCISE 2 - SYSTEM OUT PRINTF ==========");
			System.out.println("Chọn question (1-6, 0 để quay lại):");

			int question = scanner.nextInt();
			switch (question) {
			case 1:
				ex2.question1();
				break;
			case 2:
				ex2.question2();
				break;
			case 3:
				ex2.question3();
				break;
			case 4:
				ex2.question4();
				break;
			case 5:
				ex2.question5();
				break;
			case 6:
				ex2.question6();
				break;
			case 0:
				return;
			default:
				System.out.println("Question không tồn tại!");
			}
		}
	}

	private static void showExercise3Menu() {
		Scanner scanner = new Scanner(System.in);
		Exercise3 ex3 = new Exercise3();
		ex3.initData();

		while (true) {
			System.out.println("\n========== EXERCISE 3 - DATE FORMAT ==========");
			System.out.println("Chọn question (1-5, 0 để quay lại):");

			int question = scanner.nextInt();
			switch (question) {
			case 1:
				ex3.question1();
				break;
			case 2:
				ex3.question2();
				break;
			case 3:
				ex3.question3();
				break;
			case 4:
				ex3.question4();
				break;
			case 5:
				ex3.question5();
				break;
			case 0:
				return;
			default:
				System.out.println("Question không tồn tại!");
			}
		}
	}

	private static void showExercise4Menu() {
		Scanner scanner = new Scanner(System.in);
		Exercise4 ex4 = new Exercise4();

		while (true) {
			System.out.println("\n========== EXERCISE 4 - RANDOM NUMBER ==========");
			System.out.println("Chọn question (1-7, 0 để quay lại):");

			int question = scanner.nextInt();
			switch (question) {
			case 1:
				ex4.question1();
				break;
			case 2:
				ex4.question2();
				break;
			case 3:
				ex4.question3();
				break;
			case 4:
				ex4.question4();
				break;
			case 5:
				ex4.question5();
				break;
			case 6:
				ex4.question6();
				break;
			case 7:
				ex4.question7();
				break;
			case 0:
				return;
			default:
				System.out.println("Question không tồn tại!");
			}
		}
	}

	private static void showExercise5Menu() {
		Scanner scanner = new Scanner(System.in);
		Exercise5 ex5 = new Exercise5();

		while (true) {
			System.out.println("\n========== EXERCISE 5 - INPUT FROM CONSOLE ==========");
			System.out.println("Chọn question (1-11, 0 để quay lại):");

			int question = scanner.nextInt();
			switch (question) {
			case 1:
				ex5.question1();
				break;
			case 2:
				ex5.question2();
				break;
			case 3:
				ex5.question3();
				break;
			case 4:
				ex5.question4();
				break;
			case 5:
				ex5.question5();
				break;
			case 6:
				ex5.question6();
				break;
			case 7:
				ex5.question7();
				break;
			case 8:
				ex5.question8();
				break;
			case 9:
				ex5.question9();
				break;
			case 10:
				ex5.question10();
				break;
			case 11:
				ex5.question11();
				break;
			case 0:
				return;
			default:
				System.out.println("Question không tồn tại!");
			}
		}
	}

	private static void showExercise6Menu() {
		Scanner scanner = new Scanner(System.in);
		Exercise6 ex6 = new Exercise6();

		while (true) {
			System.out.println("\n========== EXERCISE 6 - METHOD ==========");
			System.out.println("Chọn question (1-3, 0 để quay lại):");

			int question = scanner.nextInt();
			switch (question) {
			case 1:
				ex6.question1();
				break;
			case 2:
				ex6.question2();
				break;
			case 3:
				ex6.question3();
				break;
			case 0:
				return;
			default:
				System.out.println("Question không tồn tại!");
			}
		}
	}
}