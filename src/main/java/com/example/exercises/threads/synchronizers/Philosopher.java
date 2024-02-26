package com.example.exercises.threads.synchronizers;

import java.util.concurrent.Semaphore;

class Philosopher extends Thread {

    private final Semaphore sem;
    private boolean full = false;
    private final String name;

    Philosopher(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (!full) {
                sem.acquire();
                System.out.println(name + " sit down at the table");

                int feedTime = (int) (Math.random() * 10 + 1);

                sleep(feedTime * 1000);
                full = true;

                System.out.println(name + " fed up in " + feedTime + " sec! Philosopher leaves the table");
                sem.release();
//                sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("Something wrong.");
        }
    }
}
