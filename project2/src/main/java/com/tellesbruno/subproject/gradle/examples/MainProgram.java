package com.tellesbruno.subproject.gradle.examples;

import org.springframework.stereotype.Component;

@Component
public class MainProgram {
    public static void main(String[] args) {
        InversionOfControl inversionOfControl = new InversionOfControl(new Adder());
        inversionOfControl.getAdder().add(1, 2);
        inversionOfControl.getAdder().add(3, 4);
        inversionOfControl.getAdder().add(5, 6);
    }
}
