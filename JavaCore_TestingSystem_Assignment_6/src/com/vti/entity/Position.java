package com.vti.entity;

import utils.ScannerUtils;

public class Position {
	public static int COUNTPos = 0;
	public int id;
	public PositionName name;

	public enum PositionName {
		Dev, Test, Scrum_Master, PM
	}

	public Position() {
		super();
		COUNTPos++;
		this.id = COUNTPos;

		System.out.println("Chọn tên vị trí muốn nhập:");
		System.out.println("1. Dev");
		System.out.println("2. Test");
		System.out.println("3. Scrum_Master");
		System.out.println("4. PM");
		System.out.print("Lựa chọn của bạn: ");

		while (true) {
			int choosePos = ScannerUtils.inputIntPositive();
			switch (choosePos) {
			case 1:
				this.name = PositionName.Dev;
				return;
			case 2:
				this.name = PositionName.Test;
				return;
			case 3:
				this.name = PositionName.Scrum_Master;
				return;
			case 4:
				this.name = PositionName.PM;
				return;
			default:
				System.err.print("Chọn lại (1-4): ");
			}
		}
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
}