package com.vti.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
	private String name;
	private Gender gender;
	private LocalDate birthDate;
	private String address;

	public enum Gender {
		MALE, FEMALE, UNKNOWN
	}

	// Constructors
	public Person() {
	}

	public Person(String name, Gender gender, LocalDate birthDate, String address) {
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.address = address;
	}

	// Getters và Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Methods
	public void inputInfo() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter name: ");
		this.name = scanner.nextLine();

		System.out.print("Enter gender (1.Male, 2.Female, 3.Unknown): ");
		int genderChoice = scanner.nextInt();
		scanner.nextLine();

		switch (genderChoice) {
		case 1:
			this.gender = Gender.MALE;
			break;
		case 2:
			this.gender = Gender.FEMALE;
			break;
		default:
			this.gender = Gender.UNKNOWN;
		}

		System.out.print("Enter birth date (yyyy-MM-dd): ");
		this.birthDate = LocalDate.parse(scanner.nextLine());

		System.out.print("Enter address: ");
		this.address = scanner.nextLine();
	}

	public String showInfo() {
		return "Name: " + name + ", Gender: " + gender + ", Birth Date: " + birthDate + ", Address: " + address;
	}
}