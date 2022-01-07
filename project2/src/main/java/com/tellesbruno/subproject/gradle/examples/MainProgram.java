package com.tellesbruno.subproject.gradle.examples;

public class MainProgram {
    public static void main(String[] args) {

        InversionOfControl inversionOfControl = new InversionOfControl(new Adder());

        inversionOfControl.getAdder().add(1, 2);
        inversionOfControl.getAdder().add(3, 4);
        inversionOfControl.getAdder().add(5, 6);

        inversionOfControl.setAdder(new AdderMore());

        inversionOfControl.getAdder().add(1, 2);
        inversionOfControl.getAdder().add(3, 4);
        inversionOfControl.getAdder().add(5, 6);
    }
}
