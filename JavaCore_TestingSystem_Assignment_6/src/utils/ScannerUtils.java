package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

	// Question 5, 6, 7: inputInt với error message
	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				System.out.print("Nhập số nguyên: ");
				String input = scanner.nextLine();
				return Integer.parseInt(input.trim());
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}

	// Question 5: inputAge()
	public static int inputAge() {
		while (true) {
			try {
				System.out.print("Nhập tuổi: ");
				String input = scanner.nextLine();
				int age = Integer.parseInt(input.trim());

				if (age < 0) {
					System.err.println("Wrong inputing! The age must be greater than 0, please input again.");
				} else {
					return age;
				}
			} catch (NumberFormatException e) {
				System.err.println("wrong inputing! Please input an age as int, input again.");
			}
		}
	}

	// Question 7: inputInt() không tham số
	public static int inputInt() {
		return inputInt("Wrong inputing! Please input an integer, input again.");
	}

	// Question 7: inputIntPositive()
	public static int inputIntPositive() {
		while (true) {
			int number = inputInt("Wrong inputing! Please input a positive integer, input again.");
			if (number >= 0) {
				return number;
			} else {
				System.err.println("Wrong inputing! The number must be greater than or equal 0, please input again.");
			}
		}
	}

	// Question 8: inputFloat()
	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				System.out.print("Nhập số thực: ");
				String input = scanner.nextLine();
				return Float.parseFloat(input.trim());
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}

	// Question 8: inputFloat() không tham số
	public static float inputFloat() {
		return inputFloat("Wrong inputing! Please input a float number, input again.");
	}

	// Question 8: inputDouble()
	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				System.out.print("Nhập số double: ");
				String input = scanner.nextLine();
				return Double.parseDouble(input.trim());
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}

	// Question 8: inputDouble() không tham số
	public static double inputDouble() {
		return inputDouble("Wrong inputing! Please input a double number, input again.");
	}

	// Question 8: inputString()
	public static String inputString() {
		String input;
		while (true) {
			input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.print("Không được để trống. Nhập lại: ");
			}
		}
	}

	// inputLocalDate()
	public static LocalDate inputLocalDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		while (true) {
			try {
				System.out.print("Nhập ngày (yyyy-MM-dd): ");
				String dateString = scanner.nextLine();
				return LocalDate.parse(dateString, formatter);
			} catch (DateTimeParseException e) {
				System.err.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại (yyyy-MM-dd): ");
			}
		}
	}
}