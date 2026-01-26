package com.vti.entity;

import java.time.LocalDate;

public class StudentEx2 implements Comparable<StudentEx2> {
    private static int COUNTEX2 = 0;
    private int id;
    private String name;
    private LocalDate birthDay;
    private int score;
    
    public StudentEx2(String name, LocalDate birthDay, int score) {
        this.id = ++COUNTEX2;
        this.name = name;
        this.birthDay = birthDay;
        this.score = score;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public LocalDate getBirthDay() {
        return birthDay;
    }
    
    public int getScore() {
        return score;
    }
    
    @Override
    public String toString() {
        return "StudentEx2 [id=" + id + ", name=" + name + 
               ", birthDay=" + birthDay + ", score=" + score + "]";
    }
    
    @Override
    public int compareTo(StudentEx2 o) {
        int nameCompare = this.name.compareTo(o.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        
        int scoreCompare = Integer.compare(this.score, o.getScore());
        if (scoreCompare != 0) {
            return scoreCompare;
        }
        
        return this.birthDay.compareTo(o.getBirthDay());
    }
}