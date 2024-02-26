package com.example.exercises.threads.synchronizers;

import java.util.concurrent.CountDownLatch;

public class Car extends Thread {

    private final CountDownLatch countDownLatch;
    private final String name;

    private final int speed;
    private final int trackLength;

    Car(CountDownLatch countDownLatch, String name, int speed, int trackLength) {
        this.countDownLatch = countDownLatch;
        this.name = name;
        this.speed = speed;
        this.trackLength = trackLength;
    }

    @Override
    public void run() {
        try {
            sleep(300);
            System.out.println(name + " the car is before startline");
            countDownLatch.countDown();
            countDownLatch.await();
            System.out.println(name + " starts");
            sleep(trackLength / speed);//ждем пока проедет трассу

            System.out.println(name + " finished. it had speed: " + speed);
        } catch (InterruptedException e) {
            System.out.println("Something wrong.");
        }
    }
}
