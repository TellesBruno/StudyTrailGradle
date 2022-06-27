package com.tellesbruno.subproject.gradle.examples;

import java.util.logging.Logger;

public class AdderMore extends Adder {
    private static final Logger LOG = Logger.getLogger(AdderMore.class.getName());
    @Override
    public int add(int a, int b) {
        int c;
        c = a + b;
        c = c * 2;
        var msg = "Soma * 2: " + c;
        LOG.info(msg);
        return c;
    }
}
