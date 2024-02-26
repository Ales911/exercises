package com.example.exercises.threads.synchronizers;

import java.util.concurrent.CyclicBarrier;

public class CarToFerry extends Thread {

    private final CyclicBarrier cyclicBarrier;
    private final String name;

    CarToFerry(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Car " + name + "is on ferry");
            cyclicBarrier.await();
            System.out.println("Car " + name + "is off ferry");
        } catch (Exception e) {
        }
    }

}
