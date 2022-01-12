package com.tellesbruno.study.trail.gradle.models;

import lombok.*;
import lombok.experimental.SuperBuilder;


//@SuperBuilder
@Builder @ToString
public class SimpleVehicle {
    @Getter @NonNull
    private Integer year;
    @Getter @Setter @NonNull
    private String color;
    @Getter @Setter @NonNull
    private Double price;
}
