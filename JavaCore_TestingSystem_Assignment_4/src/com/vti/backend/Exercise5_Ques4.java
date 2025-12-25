package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.entity.ex4_ques4.Article;
import com.vti.entity.ex4_ques4.Book;
import com.vti.entity.ex4_ques4.Document;
import com.vti.entity.ex4_ques4.Magazine;

public class Exercise5_Ques4 {
	private ArrayList<Document> documentList = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	private int nextId = 1;

	public void question4() {
		System.out.println("=== Question 4: Library Management System ===");

		boolean running = true;
		while (running) {
			System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
			System.out.println("1. Thêm mới tài liệu");
			System.out.println("2. Xóa tài liệu theo mã");
			System.out.println("3. Hiển thị thông tin tài liệu");
			System.out.println("4. Tìm kiếm tài liệu theo loại");
			System.out.println("5. Thoát");
			System.out.print("Chọn chức năng: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				addDocument();
				break;
			case 2:
				deleteDocument();
				break;
			case 3:
				displayDocuments();
				break;
			case 4:
				searchByType();
				break;
			case 5:
				running = false;
				System.out.println("Thoát chương trình!");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		}
	}

	private void addDocument() {
		System.out.println("\nChọn loại tài liệu:");
		System.out.println("1. Sách");
		System.out.println("2. Báo");
		System.out.println("3. Tạp chí");
		System.out.print("Chọn: ");
		int type = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Nhập tên nhà xuất bản: ");
		String publisher = scanner.nextLine();

		System.out.print("Nhập số bản phát hành: ");
		int numRelease = scanner.nextInt();
		scanner.nextLine();

		switch (type) {
		case 1: // Book
			System.out.print("Nhập tên tác giả: ");
			String author = scanner.nextLine();

			System.out.print("Nhập số trang: ");
			int pages = scanner.nextInt();

			documentList.add(new Book(nextId++, publisher, numRelease, author, pages));
			System.out.println("Đã thêm sách!");
			break;

		case 2: // Article
			System.out.print("Nhập ngày phát hành (ngày): ");
			int day = scanner.nextInt();
			System.out.print("Nhập tháng phát hành: ");
			int month = scanner.nextInt();
			System.out.print("Nhập năm phát hành: ");
			int year = scanner.nextInt();

			LocalDate releaseDate = LocalDate.of(year, month, day);
			documentList.add(new Article(nextId++, publisher, numRelease, releaseDate));
			System.out.println("Đã thêm báo!");
			break;

		case 3: // Magazine
			System.out.print("Nhập số phát hành: ");
			int issueNumber = scanner.nextInt();

			System.out.print("Nhập tháng phát hành (ngày): ");
			int mDay = scanner.nextInt();
			System.out.print("Nhập tháng phát hành: ");
			int mMonth = scanner.nextInt();
			System.out.print("Nhập năm phát hành: ");
			int mYear = scanner.nextInt();

			LocalDate monthRelease = LocalDate.of(mYear, mMonth, mDay);
			documentList.add(new Magazine(nextId++, publisher, numRelease, issueNumber, monthRelease));
			System.out.println("Đã thêm tạp chí!");
			break;
		}
	}

	private void deleteDocument() {
		System.out.print("Nhập mã tài liệu cần xóa: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Iterator<Document> iterator = documentList.iterator();
		boolean removed = false;

		while (iterator.hasNext()) {
			Document doc = iterator.next();
			if (doc.getId() == id) {
				iterator.remove();
				removed = true;
				break;
			}
		}

		if (removed) {
			System.out.println("Đã xóa tài liệu mã " + id);
		} else {
			System.out.println("Không tìm thấy tài liệu mã " + id);
		}
	}

	private void displayDocuments() {
		if (documentList.isEmpty()) {
			System.out.println("Danh sách tài liệu trống!");
		} else {
			System.out.println("\n===== DANH SÁCH TÀI LIỆU =====");
			for (Document doc : documentList) {
				System.out.println(doc);
			}
			System.out.println("Tổng số: " + documentList.size() + " tài liệu");
		}
	}

	private void searchByType() {
		System.out.println("\nChọn loại tài liệu cần tìm:");
		System.out.println("1. Sách");
		System.out.println("2. Báo");
		System.out.println("3. Tạp chí");
		System.out.print("Chọn: ");
		int type = scanner.nextInt();
		scanner.nextLine();

		System.out.println("\n===== KẾT QUẢ TÌM KIẾM =====");
		boolean found = false;

		switch (type) {
		case 1: // Book
			for (Document doc : documentList) {
				if (doc instanceof Book) {
					System.out.println(doc);
					found = true;
				}
			}
			if (!found) {
				System.out.println("Không có sách trong thư viện");
			}
			break;

		case 2: // Article
			for (Document doc : documentList) {
				if (doc instanceof Article) {
					System.out.println(doc);
					found = true;
				}
			}
			if (!found) {
				System.out.println("Không có báo trong thư viện");
			}
			break;

		case 3: // Magazine
			for (Document doc : documentList) {
				if (doc instanceof Magazine) {
					System.out.println(doc);
					found = true;
				}
			}
			if (!found) {
				System.out.println("Không có tạp chí trong thư viện");
			}
			break;
		}
	}
}