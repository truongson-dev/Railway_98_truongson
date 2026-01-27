package com.vti.utils;

import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);
    
    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số nguyên: ");
            }
        }
    }
    
    public static int inputIntPositive() {
        while (true) {
            int num = inputInt();
            if (num > 0) {
                return num;
            }
            System.out.print("Vui lòng nhập số dương: ");
        }
    }
    
    public static float inputFloat() {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số thực: ");
            }
        }
    }
    
    public static double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số thực: ");
            }
        }
    }
    
    public static String inputString() {
        return scanner.nextLine();
    }
    
    public static LocalDate inputLocalDate() {
        System.out.print("Nhập ngày (yyyy-MM-dd): ");
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Nhập lại (yyyy-MM-dd): ");
            }
        }
    }
}