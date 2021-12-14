package com.tellesbruno.subproject.gradle.examples;

public class Adder implements InterfaceAdder {
    @Override
    public int add(int a, int b) {
        int c;
        c = a + b;
        System.out.println("Soma: " + c);
        return c;
    }
}