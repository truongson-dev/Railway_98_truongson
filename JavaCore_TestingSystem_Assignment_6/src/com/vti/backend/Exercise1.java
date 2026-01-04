package com.vti.backend;

public class Exercise1 {

	// Question 1: Debug bài tìm Min/Max
	public void question1() {
		System.out.println("=== Debug Min/Max ===");
		int[] arr = { 2, 5, 1, 8, 3, 9, 4 };

		// Giải thích debug:
		System.out.println("a) Tại vòng lặp i = 4:");
		System.out.println("   - Giá trị ban đầu maxValue = arr[0] = 2");
		System.out.println("   - i=1: arr[1]=5 > 2 → maxValue=5");
		System.out.println("   - i=2: arr[2]=1 < 5 → maxValue=5");
		System.out.println("   - i=3: arr[3]=8 > 5 → maxValue=8");
		System.out.println("   - i=4: arr[4]=3 < 8 → maxValue=8");
		System.out.println("   => Tại i=4, maxValue = 8");

		System.out.println("\nb) Set maxValue = 5 tại i=4:");
		System.out.println("   - Dùng debugger set giá trị maxValue = 5");
		System.out.println("   - Các vòng lặp sau sẽ so sánh với 5");

		System.out.println("\nc) Code sửa bug:");
		int maxValue = getMaxValue(arr);
		int minValue = getMinValue(arr);

		System.out.println("Max Value: " + maxValue);
		System.out.println("Min Value: " + minValue);
	}

	private int getMaxValue(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Mảng không được null hoặc rỗng");
		}

		int maxValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		return maxValue;
	}

	private int getMinValue(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Mảng không được null hoặc rỗng");
		}

		int minValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < minValue) {
				minValue = arr[i];
			}
		}
		return minValue;
	}

	// Question 2: Debug chương trình thêm cán bộ
	public void question2() {
		System.out.println("\n=== Debug thêm cán bộ ===");
		System.out.println("Nguyên nhân lỗi: Scanner.nextInt() không đọc ký tự newline (\\n)");
		System.out.println("Giải pháp 1: Dùng Integer.parseInt(scanner.nextLine())");
		System.out.println("Giải pháp 2: Thêm scanner.nextLine() sau scanner.nextInt()");

		System.out.println("\nCode sửa lỗi:");
		System.out.println("Scanner scanner = new Scanner(System.in);");
		System.out.println("System.out.print(\"Bạn muốn add bao nhiêu cán bộ: \");");
		System.out.println("int n = Integer.parseInt(scanner.nextLine()); // Sửa ở đây");
		System.out.println("// Tiếp tục dùng scanner.nextLine() cho các input khác");
	}
}