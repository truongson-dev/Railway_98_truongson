package com.vti.entity.polymorphism.question5;

public class DienThoaiCoDien extends DienThoaiDiDong {
	@Override
	public void tanCong() {
		System.out.println("Điện thoại cổ điển: Ném là chắc chắn!");
	}

	public void ngheDaiRadio() {
		System.out.println("Đang nghe đài radio...");
	}
}