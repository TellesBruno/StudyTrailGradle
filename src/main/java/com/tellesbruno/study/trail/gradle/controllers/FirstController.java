package com.tellesbruno.study.trail.gradle.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @RequestMapping
    public String mainProject() {
        return "Essa é a aplicação principal!";
    }
}
