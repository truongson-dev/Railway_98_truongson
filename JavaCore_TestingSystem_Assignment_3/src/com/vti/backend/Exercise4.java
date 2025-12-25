package com.vti.backend;

import java.util.Scanner;

public class Exercise4 {
	private Scanner scanner = new Scanner(System.in);

	public void question1() {
		System.out.print("Nhập chuỗi: ");
		String s1 = scanner.nextLine();
		String[] words = s1.split("\\s+");
		System.out.println("Số từ trong chuỗi: " + words.length);
	}

	public void question2() {
		System.out.print("Nhập vào chuỗi 1: ");
		String s1 = scanner.next();
		System.out.print("Nhập vào chuỗi 2: ");
		String s2 = scanner.next();
		System.out.println("Kết quả sau khi nối chuỗi: " + s1 + " " + s2);
	}

	public void question3() {
		System.out.print("Nhập Tên: ");
		String name = scanner.nextLine();

		if (name.length() > 0) {
			String firstCharacter = name.substring(0, 1).toUpperCase();
			String leftCharacter = name.substring(1);
			name = firstCharacter + leftCharacter;
		}

		System.out.println("Tên sau chuẩn hóa: " + name);
	}

	public void question4() {
		System.out.print("Nhập tên: ");
		String name = scanner.nextLine();
		name = name.toUpperCase();

		for (int i = 0; i < name.length(); i++) {
			System.out.println("Ký tự thứ " + (i + 1) + " là: " + name.charAt(i));
		}
	}

	public void question5() {
		System.out.print("Nhập họ: ");
		String firstName = scanner.nextLine();
		System.out.print("Nhập tên: ");
		String lastName = scanner.nextLine();
		System.out.println("Họ tên đầy đủ: " + firstName + " " + lastName);
	}

	public void question6() {
		System.out.print("Nhập họ tên đầy đủ: ");
		String fullName = scanner.nextLine();

		// Chuẩn hóa xâu
		fullName = fullName.trim();
		String[] words = fullName.split("\\s+");

		String lastName = words[0];
		String firstName = words[words.length - 1];

		StringBuilder middleName = new StringBuilder();
		for (int i = 1; i <= words.length - 2; i++) {
			middleName.append(words[i]);
			if (i < words.length - 2) {
				middleName.append(" ");
			}
		}

		System.out.println("Họ là: " + lastName);
		System.out.println("Tên đệm là: " + middleName.toString());
		System.out.println("Tên là: " + firstName);
	}

	public void question7() {
		System.out.print("Nhập họ tên đầy đủ: ");
		String fullName = scanner.nextLine();

		// a) Xóa dấu cách thừa
		fullName = fullName.trim();
		fullName = fullName.replaceAll("\\s+", " ");
		System.out.println("Chuỗi sau khi xóa khoảng trắng thừa: " + fullName);

		// b) Viết hoa chữ cái đầu mỗi từ
		String[] words = fullName.split(" ");
		StringBuilder normalizedName = new StringBuilder();

		for (String word : words) {
			if (word.length() > 0) {
				String firstCharacter = word.substring(0, 1).toUpperCase();
				String leftCharacter = word.substring(1).toLowerCase();
				normalizedName.append(firstCharacter).append(leftCharacter).append(" ");
			}
		}

		System.out.println("Họ tên sau khi chuẩn hóa: " + normalizedName.toString().trim());
	}

	public void question8() {
		String[] groupNames = { "Java with VTI", "Cách qua môn gia va", "Học Java có khó không?" };

		System.out.println("Các group có chứa chữ 'Java':");
		for (String groupName : groupNames) {
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}
	}

	public void question9() {
		String[] groupNames = { "Java", "C#", "C++" };

		System.out.println("Các group có tên chính xác là 'Java':");
		for (String groupName : groupNames) {
			if (groupName.equals("Java")) {
				System.out.println(groupName);
			}
		}
	}

	public void question10() {
		System.out.print("Nhập chuỗi 1: ");
		String s1 = scanner.nextLine();
		System.out.print("Nhập chuỗi 2: ");
		String s2 = scanner.nextLine();

		StringBuilder reverseS1 = new StringBuilder();
		for (int i = s1.length() - 1; i >= 0; i--) {
			reverseS1.append(s1.charAt(i));
		}

		if (s2.equals(reverseS1.toString())) {
			System.out.println("OK");
		} else {
			System.out.println("KO");
		}
	}

	public void question11() {
		System.out.print("Nhập một chuỗi: ");
		String str = scanner.nextLine();

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				count++;
			}
		}

		System.out.println("Số lần xuất hiện của ký tự 'a': " + count);
	}

	public void question12() {
		System.out.print("Nhập chuỗi: ");
		String s1 = scanner.nextLine();

		StringBuilder reverseS1 = new StringBuilder();
		for (int i = s1.length() - 1; i >= 0; i--) {
			reverseS1.append(s1.charAt(i));
		}

		System.out.println("Chuỗi đảo ngược: " + reverseS1.toString());
	}

	public void question13() {
		System.out.print("Nhập chuỗi: ");
		String str = scanner.nextLine();

		if (str == null) {
			System.out.println("false");
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				System.out.println("false");
				return;
			}
		}

		System.out.println("true");
	}

	public void question14() {
		System.out.print("Nhập chuỗi: ");
		String str = scanner.nextLine();

		System.out.print("Nhập kí tự muốn chuyển: ");
		char ch1 = scanner.nextLine().charAt(0);

		System.out.print("Nhập kí tự sẽ chuyển: ");
		char ch2 = scanner.nextLine().charAt(0);

		str = str.replace(ch1, ch2);
		System.out.println("Chuỗi sau khi chuyển: " + str);
	}

	public void question15() {
		System.out.print("Nhập chuỗi: ");
		String str = scanner.nextLine();

		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		String[] words = str.split(" ");

		System.out.print("Chuỗi đảo ngược theo từ: ");
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.print(words[i] + " ");
		}
		System.out.println();
	}

	public void question16() {
		System.out.print("Nhập chuỗi: ");
		String str = scanner.nextLine();

		System.out.print("Nhập n: ");
		int n = scanner.nextInt();

		if (str == null || str.isEmpty() || str.length() % n != 0) {
			System.out.println("KO");
			return;
		}

		System.out.println("Các phần chia đều:");
		for (int i = 0; i < str.length(); i += n) {
			System.out.println(str.substring(i, i + n));
		}
	}
}