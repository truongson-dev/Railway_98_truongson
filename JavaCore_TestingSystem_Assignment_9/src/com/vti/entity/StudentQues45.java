package com.vti.entity;

public class StudentQues45 implements Comparable<StudentQues45> {
    private int id;
    private String name;
    
    public StudentQues45(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
    
    @Override
    public int compareTo(StudentQues45 o) {
        return this.name.compareTo(o.getName());
    }
}