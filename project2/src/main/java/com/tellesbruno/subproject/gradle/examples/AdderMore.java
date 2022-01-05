package com.tellesbruno.subproject.gradle.examples;

public class AdderMore extends Adder {
    @Override
    public int add(int a, int b) {
        int c;
        c = a + b;
        c = c * 2;
        System.out.println("Soma * 2: " + c);
        return c;
    }
}
