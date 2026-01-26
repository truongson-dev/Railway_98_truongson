package com.vti.backend;

import com.vti.entity.*;
import com.vti.utils.ScannerUtils;
import com.vti.utils.FileUtils;

public class Exercise1 {
    
    // Question 1
    public void question1() {
        Student[] students = new Student[3];
        
        System.out.println("Khởi tạo 3 sinh viên:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Sinh viên " + (i + 1) + ":");
            students[i] = new Student();
        }
        
        System.out.println("\nThông tin sinh viên:");
        for (Student s : students) {
            System.out.println(s);
        }
        
        System.out.println("\nChuyển sang Đại học Công nghệ:");
        Student.college = "Đại học Công nghệ";
        
        System.out.println("\nThông tin sau khi chuyển:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
    
    // Question 2
    public void question2() {
        Student[] students = new Student[3];
        
        for (int i = 0; i < 3; i++) {
            students[i] = new Student("Sinh viên " + (i + 1));
        }
        
        System.out.println("=== QUẢN LÝ QUỸ NHÓM ===");
        
        // B1: Mỗi sinh viên nộp 100k
        Student.moneyGroup += 300;
        System.out.println("B1: Mỗi SV nộp 100k. Tổng quỹ: " + Student.moneyGroup + "k");
        
        // B2: SV1 lấy 50k
        Student.moneyGroup -= 50;
        System.out.println("B2: SV1 lấy 50k mua bim bim. Tổng quỹ: " + Student.moneyGroup + "k");
        
        // B3: SV2 lấy 20k
        Student.moneyGroup -= 20;
        System.out.println("B3: SV2 lấy 20k mua bánh mì. Tổng quỹ: " + Student.moneyGroup + "k");
        
        // B4: SV3 lấy 150k
        Student.moneyGroup -= 150;
        System.out.println("B4: SV3 lấy 150k mua đồ học tập. Tổng quỹ: " + Student.moneyGroup + "k");
        
        // B5: Mỗi người đóng 50k
        Student.moneyGroup += 150;
        System.out.println("B5: Mỗi SV đóng 50k. Tổng quỹ: " + Student.moneyGroup + "k");
    }
    
    // Question 3
    public void question3() {
        System.out.println("=== TÍNH TOÁN VỚI MYMATH ===");
        System.out.print("Nhập số a: ");
        int a = ScannerUtils.inputInt();
        System.out.print("Nhập số b: ");
        int b = ScannerUtils.inputInt();
        
        System.out.println("Max(" + a + ", " + b + ") = " + MyMath.max(a, b));
        System.out.println("Min(" + a + ", " + b + ") = " + MyMath.min(a, b));
        System.out.println("Sum(" + a + ", " + b + ") = " + MyMath.sum(a, b));
        System.out.println(a + " + PI = " + MyMath.sumWithPI(a));
    }
    
    // Question 4
    public void question4() {
        Student student = new Student();
        System.out.println("College hiện tại: " + student.getCollege());
        
        student.setCollege("Đại học Hà Nội");
        System.out.println("College sau khi thay đổi: " + student.getCollege());
    }
    
    // Question 5
    public void question5() {
        System.out.println("=== ĐẾM SỐ LƯỢNG SINH VIÊN ===");
        
        Student.COUNT = 0; // Reset counter
        for (int i = 0; i < 3; i++) {
            new Student("SV " + (i + 1));
        }
        
        new Student("SV 4");
        new Student("SV 5");
        
        System.out.println("Tổng số sinh viên đã tạo: " + Student.COUNT);
    }
    
    // Question 6
    public void question6() {
        System.out.println("=== ĐẾM SINH VIÊN THEO LOẠI ===");
        
        // Reset counters
        Student.COUNT = 0;
        PrimaryStudent.COUNTPri = 0;
        SecondaryStudent.COUNTSecond = 0;
        
        // Tạo 2 PrimaryStudent
        PrimaryStudent p1 = new PrimaryStudent("Primary 1");
        PrimaryStudent p2 = new PrimaryStudent("Primary 2");
        
        // Tạo 4 SecondaryStudent
        SecondaryStudent s1 = new SecondaryStudent("Secondary 1");
        SecondaryStudent s2 = new SecondaryStudent("Secondary 2");
        SecondaryStudent s3 = new SecondaryStudent("Secondary 3");
        SecondaryStudent s4 = new SecondaryStudent("Secondary 4");
        
        System.out.println("\n=== THỐNG KÊ ===");
        System.out.println("+--------------------+------+");
        System.out.println("| Loại sinh viên     | Số lượng |");
        System.out.println("+--------------------+------+");
        System.out.printf("| %-18s | %-6d |\n", "Student", Student.COUNT);
        System.out.printf("| %-18s | %-6d |\n", "PrimaryStudent", PrimaryStudent.COUNTPri);
        System.out.printf("| %-18s | %-6d |\n", "SecondaryStudent", SecondaryStudent.COUNTSecond);
        System.out.println("+--------------------+------+");
    }
    
    // Question 7
    public void question7() {
        System.out.println("=== GIỚI HẠN 7 SINH VIÊN ===");
        
        Student.COUNT = 0;
        for (int i = 0; i < 6; i++) {
            new Student("SV " + (i + 1));
        }
        
        System.out.println("\nThử tạo PrimaryStudent thứ 7:");
        PrimaryStudent p = new PrimaryStudent("Primary 7");
        
        System.out.println("\nThử tạo SecondaryStudent thứ 8 (vượt quá giới hạn):");
        SecondaryStudent s = new SecondaryStudent("Secondary 8");
    }
    
    // Question 8
    public void question8() {
        System.out.println("=== QUẢN LÝ HÌNH HỌC ===");
        
        try {
            // Tạo 4 hình chữ nhật
            System.out.println("Tạo 4 hình chữ nhật:");
            HinhChuNhat[] hcns = new HinhChuNhat[4];
            for (int i = 0; i < 4; i++) {
                System.out.println("Hình chữ nhật " + (i + 1) + ":");
                System.out.print("Chiều dài: ");
                float dai = ScannerUtils.inputFloat();
                System.out.print("Chiều rộng: ");
                float rong = ScannerUtils.inputFloat();
                hcns[i] = new HinhChuNhat(dai, rong);
                System.out.println("Chu vi: " + hcns[i].tinhChuVi() + 
                                 ", Diện tích: " + hcns[i].tinhDienTich());
            }
            
            // Tạo hình tròn thứ 5
            System.out.println("\nTạo hình tròn thứ 5:");
            System.out.print("Bán kính: ");
            float r1 = ScannerUtils.inputFloat();
            HinhTron ht1 = new HinhTron(r1);
            System.out.println("Chu vi: " + ht1.tinhChuVi() + 
                             ", Diện tích: " + ht1.tinhDienTich());
            
            // Thử tạo hình thứ 6 (sẽ vượt quá giới hạn)
            System.out.println("\nThử tạo hình thứ 6 (vượt quá giới hạn 5 hình):");
            System.out.print("Bán kính: ");
            float r2 = ScannerUtils.inputFloat();
            HinhTron ht2 = new HinhTron(r2);
            
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
    
    // Question 9 - File Operations
    public void question9() {
        System.out.println("=== THAO TÁC VỚI FILE ===");
        
        try {
            // 1. Kiểm tra file tồn tại
            System.out.print("Nhập đường dẫn file cần kiểm tra: ");
            String path1 = ScannerUtils.inputString();
            if (FileUtils.isFileExists(path1)) {
                System.out.println("File tồn tại!");
            } else {
                System.out.println("File không tồn tại!");
            }
            
            // 2. Tạo file mới
            System.out.print("\nNhập đường dẫn file mới: ");
            String path2 = ScannerUtils.inputString();
            FileUtils.createNewFile(path2);
            
            // 3. Xóa file
            System.out.print("\nNhập đường dẫn file cần xóa: ");
            String path3 = ScannerUtils.inputString();
            FileUtils.deleteFile(path3);
            
            // 4. Kiểm tra folder
            System.out.print("\nNhập đường dẫn folder: ");
            String path4 = ScannerUtils.inputString();
            if (FileUtils.isFolder(path4)) {
                System.out.println("Đây là một folder!");
                
                // 5. Lấy danh sách file trong folder
                String[] files = FileUtils.getAllFileName(path4);
                if (files != null) {
                    System.out.println("Danh sách file trong folder:");
                    for (String file : files) {
                        System.out.println("- " + file);
                    }
                }
            } else {
                System.out.println("Đây không phải là folder!");
            }
            
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}