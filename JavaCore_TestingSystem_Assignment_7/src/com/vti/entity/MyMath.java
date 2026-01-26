package com.vti.entity;

public class MyMath {
    public static final double PI = 3.14;

    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    public static int min(int a, int b) {
        return (a <= b) ? a : b;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static double sumWithPI(int a) {
        return a + PI;
    }
}