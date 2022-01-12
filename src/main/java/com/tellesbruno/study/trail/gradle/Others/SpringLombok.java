package com.tellesbruno.study.trail.gradle.Others;

import com.tellesbruno.study.trail.gradle.models.SimpleCar;
import com.tellesbruno.study.trail.gradle.models.SimpleVehicle;
import lombok.Synchronized;

public class SpringLombok {
    static Integer count = 0;

    public static void main(String[] args) {
        SimpleVehicle vehicle = SimpleVehicle.builder()
                .year(2001)
                .color("red")
                .price(10000.00)
                .build();

        SimpleCar car = SimpleCar.carBuilder()
                .model("ABC")
                .plate("ABC1234")
                .doors(4)
                .year(2015)
                .color("black")
                .price(50000.00)
                .build();

        System.out.println(vehicle);
        System.out.println(vehicle);

        System.out.println(car);

        vehicle.setColor("blue");

        System.out.println(vehicle.getColor());



        Thread thread1 = new Thread(threadIncrementer);
        Thread thread2 = new Thread(threadIncrementer2);

        thread1.start();
        thread2.start();
    }

    @Synchronized
    public static void incrementer (String ThreadName) {
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println(ThreadName + " " + count);
        }
    }


    public static Runnable threadIncrementer = () -> {
        try {
            incrementer("Thread 1:");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    };

    public static Runnable threadIncrementer2 = () -> {
        try {
            incrementer("Thread 2:");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    };
}
