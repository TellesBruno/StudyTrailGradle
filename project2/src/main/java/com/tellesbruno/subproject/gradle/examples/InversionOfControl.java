package com.tellesbruno.subproject.gradle.examples;

public class InversionOfControl {
    private Adder adder;

    public InversionOfControl(Adder adder) {
        this.adder = adder;
    }

    public Adder getAdder() {
        return adder;
    }

    public void setAdder(Adder adder) {
        this.adder = adder;
    }
}
