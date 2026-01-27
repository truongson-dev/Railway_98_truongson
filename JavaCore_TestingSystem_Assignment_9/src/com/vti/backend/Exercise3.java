package com.vti.backend;

import com.vti.entity.*;
import com.vti.utils.ScannerUtils;
import java.util.*;

public class Exercise3 {
    
    public void question1_2_3() {
        System.out.println("\n=== GENERIC DEMO ===");
        
        // Question 1: Student với id generic
        StudentEx3<Integer> studentInt = new StudentEx3<>(1, "Student Int");
        StudentEx3<Float> studentFloat = new StudentEx3<>(2.5f, "Student Float");
        StudentEx3<Double> studentDouble = new StudentEx3<>(3.7, "Student Double");
        
        System.out.println("Student với id int: " + studentInt);
        System.out.println("Student với id float: " + studentFloat);
        System.out.println("Student với id double: " + studentDouble);
        
        // Question 2: Generic method
        System.out.println("\n=== GENERIC METHOD ===");
        printGeneric(123);
        printGeneric(45.67f);
        printGeneric(89.10);
        printGeneric("Hello World");
        printGeneric(studentInt);
        
        // Question 4: Generic array
        System.out.println("\n=== GENERIC ARRAY ===");
        Integer[] intArray = {1, 2, 3, 4, 5};
        Float[] floatArray = {1.1f, 2.2f, 3.3f};
        Double[] doubleArray = {1.11, 2.22, 3.33};
        
        printArray(intArray);
        printArray(floatArray);
        printArray(doubleArray);
    }
    
    public void question5() {
        System.out.println("\n=== EMPLOYEE GENERIC ===");
        
        // Employee với salary int
        Integer[] intSalaries = {1000, 2000, 3000};
        Employee<Integer> empInt = new Employee<>("Nguyen Van A", intSalaries);
        
        // Employee với salary float
        Float[] floatSalaries = {1500.5f, 2500.5f, 3500.5f};
        Employee<Float> empFloat = new Employee<>("Tran Thi B", floatSalaries);
        
        // Employee với salary double
        Double[] doubleSalaries = {1800.75, 2800.75, 3800.75};
        Employee<Double> empDouble = new Employee<>("Le Van C", doubleSalaries);
        
        System.out.println(empInt);
        System.out.println("Lương cuối: " + empInt.getLastSalary());
        
        System.out.println(empFloat);
        System.out.println("Lương cuối: " + empFloat.getLastSalary());
        
        System.out.println(empDouble);
        System.out.println("Lương cuối: " + empDouble.getLastSalary());
    }
    
    public void question6() {
        System.out.println("\n=== MYMAP GENERIC ===");
        
        MyMap<Integer, String> studentMap = new MyMap<>(1, "Nguyen Van A");
        System.out.println("Student Map: " + studentMap);
        System.out.println("Key: " + studentMap.getKey());
        System.out.println("Value: " + studentMap.getValue());
        
        // Thay đổi giá trị
        studentMap.setValue("Nguyen Van B");
        System.out.println("Sau khi thay đổi: " + studentMap);
    }
    
    public void question7() {
        System.out.println("\n=== PHONE GENERIC ===");
        
        // Key là email
        Phone<String, String> phoneEmail = new Phone<>("email@example.com", "0123456789");
        System.out.println("Phone (email): " + phoneEmail.getKey() + " - " + phoneEmail.getPhoneNumber());
        
        // Key là số thứ tự
        Phone<Integer, String> phoneId = new Phone<>(1, "0987654321");
        System.out.println("Phone (ID): " + phoneId.getKey() + " - " + phoneId.getPhoneNumber());
        
        // Key là tên người dùng
        Phone<String, String> phoneName = new Phone<>("John Doe", "0909123456");
        System.out.println("Phone (name): " + phoneName.getKey() + " - " + phoneName.getPhoneNumber());
    }
    
    public void question8() {
        System.out.println("\n=== STAFF GENERIC ===");
        
        Staff<Integer> staffInt = new Staff<>(101, "Nguyen Van A");
        Staff<Long> staffLong = new Staff<>(102L, "Tran Thi B");
        
        System.out.println("Staff Int - ID: " + staffInt.getId() + ", Name: " + staffInt.getName());
        System.out.println("Staff Long - ID: " + staffLong.getId() + ", Name: " + staffLong.getName());
    }
    
    // Generic method
    private <T> void printGeneric(T obj) {
        System.out.println("Generic print: " + obj);
    }
    
    // Generic array method
    private <E> void printArray(E[] array) {
        System.out.print("Array: ");
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}