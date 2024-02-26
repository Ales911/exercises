package com.example.exercises.threads.deadLock;

public class DeadLockSynchronizedExample {
    
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    
    public void synchronizedDeadLock() { //throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized(lock1) {
                System.out.println("Thread1 acquired lock1.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
                synchronized(lock2) {
                    System.out.println("Thread1 acquired lock2.");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            synchronized(lock2) {
                System.out.println("Thread2 acquired lock2.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
                synchronized(lock1) {
                    System.out.println("Thread2 acquired lock1.");
                }
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
