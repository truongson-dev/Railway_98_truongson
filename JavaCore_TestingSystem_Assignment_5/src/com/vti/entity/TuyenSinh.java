package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
	private ArrayList<Contestant> contestants = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void addContestant() {
		System.out.print("Enter name: ");
		String name = scanner.nextLine();

		System.out.print("Enter address: ");
		String address = scanner.nextLine();

		System.out.print("Enter priority: ");
		int priority = scanner.nextInt();
		scanner.nextLine(); // Clear buffer

		System.out.print("Enter block (A/B/C): ");
		String blockName = scanner.nextLine();
		Block block = new Block(blockName);

		Contestant contestant = new Contestant(name, address, priority, block);
		contestants.add(contestant);
		System.out.println("Contestant added successfully!");
	}

	@Override
	public void showInfoContestant() {
		if (contestants.isEmpty()) {
			System.out.println("No contestants!");
			return;
		}

		for (Contestant c : contestants) {
			System.out.println(c);
		}
	}

	@Override
	public void findByIdNum(int id) {
		for (Contestant c : contestants) {
			if (c.getId() == id) {
				System.out.println("Found: " + c);
				return;
			}
		}
		System.out.println("Contestant with ID " + id + " not found!");
	}
}