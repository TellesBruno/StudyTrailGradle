package com.tellesbruno.subproject.gradle.errors;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class BadRequestCuston {
    private String title;
    private int statusCode;
    private String detail;
    private long timestamp;
    private String developerMessage;
}
