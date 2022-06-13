package com.tellesbruno.study.trail.gradle.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpRequestExeption extends RuntimeException{
    private final String title;
    private final int statusCode;
    private final HttpStatus status;

    public HttpRequestExeption(String title, String message, HttpStatus status) {
        super(message);
        this.title = title;
        this.status = status;
        this.statusCode = status.value();
    }
}
