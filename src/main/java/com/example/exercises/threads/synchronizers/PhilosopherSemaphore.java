package com.example.exercises.threads.synchronizers;

import java.util.concurrent.Semaphore;

public class PhilosopherSemaphore {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        new Philosopher(sem, "Socrat").start();
        new Philosopher(sem, "Platon").start();
        new Philosopher(sem, "Aristotel").start();
        new Philosopher(sem, "Fales").start();
        new Philosopher(sem, "Pifagor").start();
    }
}
