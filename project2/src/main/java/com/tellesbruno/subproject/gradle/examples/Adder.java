package com.tellesbruno.subproject.gradle.examples;

import java.util.logging.Logger;

public class Adder implements InterfaceAdder {

    private static final Logger LOG = Logger.getLogger(Adder.class.getName());
    @Override
    public int add(int a, int b) {
        int c;
        c = a + b;
        var msg = "Soma: " + c;
        LOG.info(msg);
        return c;
    }
}