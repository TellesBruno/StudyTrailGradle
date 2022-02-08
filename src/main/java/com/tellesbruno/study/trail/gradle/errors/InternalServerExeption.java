package com.tellesbruno.study.trail.gradle.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerExeption extends RuntimeException{
    public InternalServerExeption(String message) {
        super(message);
    }
}
