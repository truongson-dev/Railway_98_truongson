package com.vti.frontend;

import com.vti.backend.*;
import com.vti.utils.ScannerUtils;

public class Demo {
    public static void main(String[] args) {
        Exercise1 ex1 = new Exercise1();
        Exercise2 ex2 = new Exercise2();
        Exercise3 ex3 = new Exercise3();
        
        while (true) {
            System.out.println("\n========== HỆ THỐNG QUẢN LÝ ==========");
            System.out.println("1. Exercise 1: Collections");
            System.out.println("2. Exercise 2: Comparable/Comparator");
            System.out.println("3. Exercise 3: Generics");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            
            int mainChoice = ScannerUtils.inputInt();
            
            switch (mainChoice) {
                case 1:
                    runExercise1(ex1);
                    break;
                case 2:
                    ex2.question1();
                    break;
                case 3:
                    runExercise3(ex3);
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    private static void runExercise1(Exercise1 ex1) {
        while (true) {
            System.out.println("\n===== EXERCISE 1: COLLECTIONS =====");
            System.out.println("1. List Operations");
            System.out.println("2. Stack & Queue");
            System.out.println("3. Set Operations");
            System.out.println("4. Set không trùng tên");
            System.out.println("5. Map Operations");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            
            int choice = ScannerUtils.inputInt();
            
            switch (choice) {
                case 1:
                    ex1.question1();
                    break;
                case 2:
                    ex1.question2();
                    break;
                case 3:
                    ex1.question3();
                    break;
                case 4:
                    ex1.question4_5();
                    break;
                case 5:
                    ex1.question6_7();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    private static void runExercise3(Exercise3 ex3) {
        while (true) {
            System.out.println("\n===== EXERCISE 3: GENERICS =====");
            System.out.println("1. Generic Class & Method");
            System.out.println("2. Employee Generic");
            System.out.println("3. MyMap Generic");
            System.out.println("4. Phone Generic");
            System.out.println("5. Staff Generic");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            
            int choice = ScannerUtils.inputInt();
            
            switch (choice) {
                case 1:
                    ex3.question1_2_3();
                    break;
                case 2:
                    ex3.question5();
                    break;
                case 3:
                    ex3.question6();
                    break;
                case 4:
                    ex3.question7();
                    break;
                case 5:
                    ex3.question8();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}