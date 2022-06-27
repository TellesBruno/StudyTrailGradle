package com.tellesbruno.subproject.gradle.examples;

import java.util.logging.Logger;

public class MySampleClass {
    private static final Logger LOG = Logger.getLogger(MySampleClass.class.getName());
    public void doSomething() {
        LOG.info("I'm doing someting!");
    }
}
