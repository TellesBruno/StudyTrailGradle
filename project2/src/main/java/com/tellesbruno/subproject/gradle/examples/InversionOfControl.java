package com.tellesbruno.subproject.gradle.examples;

import org.springframework.beans.factory.annotation.Autowired;

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
