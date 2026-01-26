package com.vti.frontend;

import com.vti.backend.Exercise1;
import com.vti.utils.ScannerUtils;

public class DemoExercise1 {
    public static void main(String[] args) {
        Exercise1 ex1 = new Exercise1();
        
        while (true) {
            System.out.println("\n=== MENU BÀI TẬP STATIC ===");
            System.out.println("1. Question 1 - Static variable college");
            System.out.println("2. Question 2 - Quỹ nhóm");
            System.out.println("3. Question 3 - MyMath");
            System.out.println("4. Question 4 - Get/Set college");
            System.out.println("5. Question 5 - Đếm sinh viên");
            System.out.println("6. Question 6 - Primary/Secondary Student");
            System.out.println("7. Question 7 - Giới hạn 7 sinh viên");
            System.out.println("8. Question 8 - Hình học");
            System.out.println("9. Question 9 - Thao tác với File");
            System.out.println("0. Thoát");
            System.out.print("Chọn bài tập: ");
            
            int choice = ScannerUtils.inputInt();
            
            try {
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
                        ex1.question4();
                        break;
                    case 5:
                        ex1.question5();
                        break;
                    case 6:
                        ex1.question6();
                        break;
                    case 7:
                        ex1.question7();
                        break;
                    case 8:
                        ex1.question8();
                        break;
                    case 9:
                        ex1.question9();
                        break;
                    case 0:
                        System.out.println("Kết thúc chương trình!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
}