package com.tellesbruno.study.trail.gradle.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder @ToString @Getter @Setter
public class SimpleVehicle {
    private Integer year;
    private String color;
    private Double price;
}
