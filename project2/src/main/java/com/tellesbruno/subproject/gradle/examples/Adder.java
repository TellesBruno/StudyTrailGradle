package com.tellesbruno.subproject.gradle.examples;

import org.springframework.stereotype.Component;

@Component
public class Adder implements InterfaceAdder {
    @Override
    public int add(int a, int b) {
        int c;
        c = a + b;
        System.out.println("Soma: " + c);
        return c;
    }
}