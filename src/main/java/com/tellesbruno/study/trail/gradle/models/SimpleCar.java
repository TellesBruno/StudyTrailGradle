package com.tellesbruno.study.trail.gradle.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

//@SuperBuilder
@ToString
public class SimpleCar extends SimpleVehicle{
    @Getter @NonNull
    private final String model;

    @Getter @NonNull
    private final String plate;

    @Getter @NonNull
    private final Integer doors;

    @Builder(builderMethodName = "carBuilder")
    public SimpleCar(String model, String plate, Integer doors, Integer year, String color, Double price) {
        super(year, color, price);
        this.model = model;
        this.plate = plate;
        this.doors = doors;
    }
}
