package com.tellesbruno.study.trail.gradle.errors;

import lombok.Getter;

@Getter
public class HttpRequestExeption extends RuntimeException{
    private final String title;
    private final int statusCode;

    public HttpRequestExeption(String title, String message, int statusCode) {
        super(message);
        this.title = title;
        this.statusCode = statusCode;
    }
}
