package com.vti.entity.polymorphism.question5;

public class DienThoaiThongMinh extends DienThoaiDiDong {
	@Override
	public void tanCong() {
		System.out.println("Smartphone: Ném là vỡ màn hình!");
	}

	public void suDung3G() {
		System.out.println("Đang sử dụng 3G...");
	}

	public void chupHinh() {
		System.out.println("Đang chụp hình...");
	}
}