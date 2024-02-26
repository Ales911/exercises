package com.example.exercises.threads;

public class ExampleSynchronized {

    public static void main(String[] args) throws InterruptedException {
        
        
//        String str = "we".equals("fd");
        
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                System.out.println("thread");
            }
        };

        Thread th1 = new Thread(task);
        System.out.println("state:" + th1.getState());
        th1.start();
        System.out.println("state:" + th1.getState());
        synchronized (lock) {
            for (int i = 0; i < 8; i++) {
                Thread.currentThread().sleep(1000);
                System.out.print("  " + i);
            }
            System.out.println(" ...");
        }
        System.out.println("state:" + th1.getState());
        Thread.currentThread().sleep(1000);
        System.out.println("state:" + th1.getState());
    }

}
