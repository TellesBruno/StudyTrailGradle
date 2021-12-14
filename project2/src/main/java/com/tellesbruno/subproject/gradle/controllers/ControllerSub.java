package com.tellesbruno.subproject.gradle.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerSub {
    @RequestMapping
    public String subproject() {
        return "Esta é uma sub-aplicação!";
    }
}
