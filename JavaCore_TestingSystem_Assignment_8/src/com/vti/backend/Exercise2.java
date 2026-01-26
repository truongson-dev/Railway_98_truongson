package com.vti.backend;

import com.vti.entity.StudentEx2;
import com.vti.utils.ScannerUtils;
import java.time.LocalDate;
import java.util.*;

public class Exercise2 {
    private List<StudentEx2> studentList;
    
    public Exercise2() {
        studentList = new ArrayList<>();
    }
    
    public void question1() {
        while (true) {
            System.out.println("\n=== COMPARABLE/COMPARATOR ===");
            System.out.println("1. Thêm student mới");
            System.out.println("2. Sắp xếp theo tên (Comparable)");
            System.out.println("3. Sắp xếp theo nhiều tiêu chí");
            System.out.println("4. Sắp xếp theo điểm giảm dần");
            System.out.println("5. Sắp xếp theo ngày sinh");
            System.out.println("6. In danh sách");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            
            int choice = ScannerUtils.inputInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = ScannerUtils.inputString();
                    System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
                    LocalDate birth = ScannerUtils.inputLocalDate();
                    System.out.print("Nhập điểm: ");
                    int score = ScannerUtils.inputInt();
                    
                    studentList.add(new StudentEx2(name, birth, score));
                    System.out.println("Đã thêm student!");
                    break;
                    
                case 2:
                    Collections.sort(studentList);
                    System.out.println("Đã sắp xếp theo tên!");
                    printStudentList();
                    break;
                    
                case 3:
                    Collections.sort(studentList, (s1, s2) -> {
                        int nameCompare = s1.getName().compareTo(s2.getName());
                        if (nameCompare != 0) return nameCompare;
                        
                        int scoreCompare = Integer.compare(s2.getScore(), s1.getScore());
                        if (scoreCompare != 0) return scoreCompare;
                        
                        return s1.getBirthDay().compareTo(s2.getBirthDay());
                    });
                    System.out.println("Đã sắp xếp theo tên, điểm giảm dần, ngày sinh!");
                    printStudentList();
                    break;
                    
                case 4:
                    Collections.sort(studentList, (s1, s2) -> 
                        Integer.compare(s2.getScore(), s1.getScore()));
                    System.out.println("Đã sắp xếp theo điểm giảm dần!");
                    printStudentList();
                    break;
                    
                case 5:
                    Collections.sort(studentList, (s1, s2) -> 
                        s1.getBirthDay().compareTo(s2.getBirthDay()));
                    System.out.println("Đã sắp xếp theo ngày sinh!");
                    printStudentList();
                    break;
                    
                case 6:
                    printStudentList();
                    break;
                    
                case 0:
                    return;
                    
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    private void printStudentList() {
        System.out.println("\nDanh sách student:");
        for (StudentEx2 s : studentList) {
            System.out.println(s);
        }
    }
}