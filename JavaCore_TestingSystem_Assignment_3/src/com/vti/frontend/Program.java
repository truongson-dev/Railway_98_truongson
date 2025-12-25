package com.vti.frontend;

import com.vti.backend.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n========== MENU CHÍNH ==========");
            System.out.println("1. Exercise 1 - Datatype Casting");
            System.out.println("2. Exercise 2 - Default value");
            System.out.println("3. Exercise 3 - Boxing & Unboxing");
            System.out.println("4. Exercise 4 - String");
            System.out.println("5. Exercise 5 - Object's Method");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn exercise (0-5): ");
            
            int exerciseChoice = scanner.nextInt();
            
            switch (exerciseChoice) {
                case 1:
                    showExercise1Menu();
                    break;
                case 2:
                    showExercise2Menu();
                    break;
                case 3:
                    showExercise3Menu();
                    break;
                case 4:
                    showExercise4Menu();
                    break;
                case 5:
                    showExercise5Menu();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    private static void showExercise1Menu() {
        Scanner scanner = new Scanner(System.in);
        Exercise1 ex1 = new Exercise1();
        
        while (true) {
            System.out.println("\n========== EXERCISE 1 - DATATYPE CASTING ==========");
            System.out.println("1. Question 1");
            System.out.println("2. Question 2");
            System.out.println("3. Question 3");
            System.out.println("4. Question 4");
            System.out.println("0. Quay lại");
            System.out.print("Chọn question (0-4): ");
            
            int question = scanner.nextInt();
            switch (question) {
                case 1: ex1.question1(); break;
                case 2: ex1.question2(); break;
                case 3: ex1.question3(); break;
                case 4: ex1.question4(); break;
                case 0: return;
                default: System.out.println("Question không tồn tại!");
            }
        }
    }
    
    private static void showExercise2Menu() {
        Scanner scanner = new Scanner(System.in);
        Exercise2 ex2 = new Exercise2();
        
        while (true) {
            System.out.println("\n========== EXERCISE 2 - DEFAULT VALUE ==========");
            System.out.println("1. Question 1");
            System.out.println("0. Quay lại");
            System.out.print("Chọn question (0-1): ");
            
            int question = scanner.nextInt();
            switch (question) {
                case 1: ex2.question1(); break;
                case 0: return;
                default: System.out.println("Question không tồn tại!");
            }
        }
    }
    
    private static void showExercise3Menu() {
        Scanner scanner = new Scanner(System.in);
        Exercise3 ex3 = new Exercise3();
        
        while (true) {
            System.out.println("\n========== EXERCISE 3 - BOXING & UNBOXING ==========");
            System.out.println("1. Question 1");
            System.out.println("2. Question 2");
            System.out.println("3. Question 3");
            System.out.println("0. Quay lại");
            System.out.print("Chọn question (0-3): ");
            
            int question = scanner.nextInt();
            switch (question) {
                case 1: ex3.question1(); break;
                case 2: ex3.question2(); break;
                case 3: ex3.question3(); break;
                case 0: return;
                default: System.out.println("Question không tồn tại!");
            }
        }
    }
    
    private static void showExercise4Menu() {
        Scanner scanner = new Scanner(System.in);
        Exercise4 ex4 = new Exercise4();
        
        while (true) {
            System.out.println("\n========== EXERCISE 4 - STRING ==========");
            System.out.println("1. Question 1 - Đếm từ");
            System.out.println("2. Question 2 - Nối chuỗi");
            System.out.println("3. Question 3 - Viết hoa chữ cái đầu");
            System.out.println("4. Question 4 - In từng ký tự");
            System.out.println("5. Question 5 - Họ và tên");
            System.out.println("6. Question 6 - Tách họ tên");
            System.out.println("7. Question 7 - Chuẩn hóa họ tên");
            System.out.println("8. Question 8 - Group chứa 'Java'");
            System.out.println("9. Question 9 - Group 'Java'");
            System.out.println("10. Question 10 - Chuỗi đảo ngược");
            System.out.println("11. Question 11 - Đếm ký tự 'a'");
            System.out.println("12. Question 12 - Đảo ngược chuỗi");
            System.out.println("13. Question 13 - Kiểm tra chữ số");
            System.out.println("14. Question 14 - Thay thế ký tự");
            System.out.println("15. Question 15 - Đảo ngược theo từ");
            System.out.println("16. Question 16 - Chia chuỗi");
            System.out.println("0. Quay lại");
            System.out.print("Chọn question (0-16): ");
            
            int question = scanner.nextInt();
            switch (question) {
                case 1: ex4.question1(); break;
                case 2: ex4.question2(); break;
                case 3: ex4.question3(); break;
                case 4: ex4.question4(); break;
                case 5: ex4.question5(); break;
                case 6: ex4.question6(); break;
                case 7: ex4.question7(); break;
                case 8: ex4.question8(); break;
                case 9: ex4.question9(); break;
                case 10: ex4.question10(); break;
                case 11: ex4.question11(); break;
                case 12: ex4.question12(); break;
                case 13: ex4.question13(); break;
                case 14: ex4.question14(); break;
                case 15: ex4.question15(); break;
                case 16: ex4.question16(); break;
                case 0: return;
                default: System.out.println("Question không tồn tại!");
            }
        }
    }
    
    private static void showExercise5Menu() {
        Scanner scanner = new Scanner(System.in);
        Exercise5 ex5 = new Exercise5();
        
        while (true) {
            System.out.println("\n========== EXERCISE 5 - OBJECT'S METHOD ==========");
            System.out.println("1. Question 1 - In thông tin phòng ban 1");
            System.out.println("2. Question 2 - In tất cả phòng ban");
            System.out.println("3. Question 3 - Địa chỉ phòng ban 1");
            System.out.println("4. Question 4 - Kiểm tra tên phòng ban");
            System.out.println("5. Question 5 - So sánh phòng ban");
            System.out.println("6. Question 6 - Sắp xếp phòng ban A-Z");
            System.out.println("7. Question 7 - Sắp xếp phòng ban");
            System.out.println("0. Quay lại");
            System.out.print("Chọn question (0-7): ");
            
            int question = scanner.nextInt();
            switch (question) {
                case 1: ex5.question1(); break;
                case 2: ex5.question2(); break;
                case 3: ex5.question3(); break;
                case 4: ex5.question4(); break;
                case 5: ex5.question5(); break;
                case 6: ex5.question6(); break;
                case 7: ex5.question7(); break;
                case 0: return;
                default: System.out.println("Question không tồn tại!");
            }
        }
    }
}