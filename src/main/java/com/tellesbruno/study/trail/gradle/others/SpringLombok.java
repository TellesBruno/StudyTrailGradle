package com.tellesbruno.study.trail.gradle.others;

import com.tellesbruno.study.trail.gradle.models.SimpleCar;
import com.tellesbruno.study.trail.gradle.models.SimpleVehicle;
import lombok.Synchronized;

import java.util.logging.Logger;

public class SpringLombok {
    private static final Logger LOG = Logger.getLogger(SpringLombok.class.getName());
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

        var msg = vehicle.toString();
        LOG.info(msg);
        LOG.info(msg);

        msg = car.toString();
        LOG.info(msg);

        vehicle.setColor("blue");

        LOG.info(vehicle.getColor());



        var thread1 = new Thread(threadIncrementer);
        var thread2 = new Thread(threadIncrementer2);

        thread1.start();
        thread2.start();
    }

    @Synchronized
    public static void incrementer (String threadName) {
        for (var i = 0; i < 10; i++) {
            count++;
            var msg = threadName + ": " + count;
            LOG.info(msg);
        }
    }


    public static final Runnable threadIncrementer = () -> {
        try {
            incrementer("Thread 1:");
        } catch (Exception e) {
            var msg = "Exception: " + e;
            LOG.info(msg);
        }
    };

    public static final Runnable threadIncrementer2 = () -> {
        try {
            incrementer("Thread 2:");
        } catch (Exception e) {
            var msg = "Exception: " + e;
            LOG.info(msg);
        }
    };
}
