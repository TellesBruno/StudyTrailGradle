package com.tellesbruno.study.trail.gradle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class LoginToken {
    private String user;
    private String password;
}