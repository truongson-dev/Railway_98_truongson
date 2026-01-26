package com.vti.entity;

import com.vti.utils.ScannerUtils;

public class Student {
    private int id;
    private String name;
    public static String college = "Đại học Bách Khoa";
    public static int COUNT = 0;
    public static int moneyGroup = 0;

    public Student() {
        super();
        COUNT++;
        if (COUNT > 7) {
            System.err.println("Số lượng sinh viên đã vượt quá 7, không thể tạo thêm sinh viên");
        } else {
            this.id = COUNT;
            System.out.println("Nhập vào tên sinh viên: ");
            this.name = ScannerUtils.inputString();
        }
    }

    public Student(String name) {
        super();
        COUNT++;
        this.id = COUNT;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCollege() {
        return college;
    }

    public void setCollege(String newCollege) {
        college = newCollege;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", college=" + college + "]";
    }
}