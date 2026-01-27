package com.vti.entity;

import java.util.Arrays;

public class Employee<T> {
    private static int COUNT = 0;
    private int id;
    private String name;
    private T[] salaries;
    
    public Employee(String name, T[] salaries) {
        this.id = ++COUNT;
        this.name = name;
        this.salaries = salaries;
    }
    
    public String getLastSalary() {
        return "Employee [id=" + id + ", name=" + name + 
               ", lastSalary=" + salaries[salaries.length - 1] + "]";
    }
    
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + 
               ", salaries=" + Arrays.toString(salaries) + "]";
    }
}