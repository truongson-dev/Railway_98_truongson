package com.vti.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.err.print("Vui lòng nhập số nguyên: ");
            }
        }
    }

    public static int inputIntPositive() {
        while (true) {
            int num = inputInt();
            if (num >= 0) {
                return num;
            }
            System.err.print("Vui lòng nhập số dương: ");
        }
    }

    public static float inputFloat() {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (Exception e) {
                System.err.print("Vui lòng nhập số thực: ");
            }
        }
    }

    public static double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (Exception e) {
                System.err.print("Vui lòng nhập số thực: ");
            }
        }
    }

    public static String inputString() {
        while (true) {
            String str = scanner.nextLine().trim();
            if (!str.isEmpty()) {
                return str;
            }
            System.err.print("Vui lòng nhập chuỗi không rỗng: ");
        }
    }

    public static LocalDate inputLocalDate() {
        System.out.print("Nhập theo định dạng yyyy-MM-dd: ");
        while (true) {
            String dateStr = scanner.nextLine().trim();
            try {
                return LocalDate.parse(dateStr);
            } catch (Exception e) {
                System.err.print("Định dạng không hợp lệ. Nhập lại (yyyy-MM-dd): ");
            }
        }
    }
}