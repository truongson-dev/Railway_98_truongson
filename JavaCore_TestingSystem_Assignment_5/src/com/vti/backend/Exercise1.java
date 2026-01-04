package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.News;

public class Exercise1 {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<News> newsList = new ArrayList<>();

	public void question1() {
		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");
			System.out.print("Choose: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Clear buffer

			switch (choice) {
			case 1:
				insertNews();
				break;
			case 2:
				viewNews();
				break;
			case 3:
				calculateAverage();
				break;
			case 4:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	private void insertNews() {
		System.out.print("Enter title: ");
		String title = scanner.nextLine();

		System.out.print("Enter publish date (yyyy-MM-dd): ");
		String publishDate = scanner.nextLine();

		System.out.print("Enter author: ");
		String author = scanner.nextLine();

		System.out.print("Enter content: ");
		String content = scanner.nextLine();

		int[] rates = new int[3];
		System.out.print("Enter rate 1: ");
		rates[0] = scanner.nextInt();
		System.out.print("Enter rate 2: ");
		rates[1] = scanner.nextInt();
		System.out.print("Enter rate 3: ");
		rates[2] = scanner.nextInt();
		scanner.nextLine(); // Clear buffer

		News news = new News(title, publishDate, author, content, rates);
		newsList.add(news);
		System.out.println("News added successfully!");
	}

	private void viewNews() {
		if (newsList.isEmpty()) {
			System.out.println("No news available!");
			return;
		}

		for (News news : newsList) {
			news.display();
			System.out.println("------------------------");
		}
	}

	private void calculateAverage() {
		if (newsList.isEmpty()) {
			System.out.println("No news available!");
			return;
		}

		for (News news : newsList) {
			float avg = news.calculate();
			System.out.println("Title: " + news.getTitle() + " - Average Rate: " + avg);
		}
	}
}