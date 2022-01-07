package com.tellesbruno.subproject.gradle.examples;

import org.springframework.beans.factory.annotation.Autowired;

public class Runner {
    @Autowired
    public MySampleClass mySampleClass;

    public Runner(MySampleClass mySampleClass) {
        this.mySampleClass = mySampleClass;
    }

    public void run() {
        mySampleClass.doSomething();
    }
}
