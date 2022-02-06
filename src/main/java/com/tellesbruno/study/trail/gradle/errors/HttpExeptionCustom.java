package com.tellesbruno.study.trail.gradle.errors;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class HttpExeptionCustom {
    private String title;
    private int statusCode;
    private String detail;
    private long timestamp;
    private String developerMessage;
}
