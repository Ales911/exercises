package com.example.exercises.threads.synchronizers;

import java.util.concurrent.CountDownLatch;

public class ExampleCountDownLatch {

 private static final int trackLength = 500000;
 
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            new Car(countDownLatch, "car N " + i, (int) (Math.random() * 100 + 50), trackLength).start();
            Thread.sleep(1000);
        }
    }
    
}
