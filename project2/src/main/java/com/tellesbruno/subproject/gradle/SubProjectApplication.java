package com.tellesbruno.subproject.gradle;


import com.tellesbruno.subproject.gradle.examples.MySampleClass;
import com.tellesbruno.subproject.gradle.examples.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SubProjectApplication {

    @Autowired
    private Runner runner;

    public static void main(String[] args) {
        SpringApplication.run(SubProjectApplication.class, args);
    }

    @PostConstruct
    public void init() {
        runner.run();
    }
}
