package com.example.exercises.threads.deadLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DeadLockBarrierExmple {

    private final CyclicBarrier barrier1 = new CyclicBarrier(2);
    private final CyclicBarrier barrier2 = new CyclicBarrier(2);

    public void barrierDeadLock() { //throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                barrier1.await();

                synchronized (barrier2) {
                    System.out.println("Thread1 acquired barrier2.");
                    barrier2.await();
                }

            } catch (InterruptedException | BrokenBarrierException ex) {
                ex.printStackTrace();
            }

        });

        Thread thread2 = new Thread(() -> {
            try {
                barrier2.await();

                synchronized (barrier1) {
                    System.out.println("Thread2 acquired barrier1.");
                    barrier1.await();
                }

            } catch (InterruptedException | BrokenBarrierException ex) {
                ex.printStackTrace();
            }

        });

        System.out.println("DeadLock started.");
        thread1.start();
        thread2.start();
//        thread2.join();
//        thread1.join();

//        System.out.println("DeadLock released.");
    }

}
