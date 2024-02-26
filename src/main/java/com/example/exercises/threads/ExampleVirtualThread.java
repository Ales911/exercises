package com.example.exercises.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleVirtualThread {

    public static void main(String[] args) throws InterruptedException {

        // 1 ----------
        System.out.println("-- 1 ----------");
        Thread.ofVirtual().start(() -> System.out.println("Hello"));
        // thread.join();
        Thread.sleep(100);

        // 2 ----------
        System.out.println("-- 2 ----------");
        Thread.Builder builder = Thread.ofVirtual().name("worker-", 0);
        Runnable task = () -> {
            System.out.println("Thread ID: " + Thread.currentThread().threadId());
        };

        // name "worker-0"
        Thread t1 = builder.start(task);
        t1.join();
        System.out.println(t1.getName() + " " + t1.getState());

        // name "worker-1"
        Thread t2 = builder.start(task);
        t2.join();
        System.out.println(t2.getName() + " " + t2.getState());

        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> future = myExecutor.submit(() -> System.out.println("Running thread"));
            future.get();
            System.out.println("Task completed");
            // ...
         } catch (ExecutionException ex) {
            Logger.getLogger(ExampleVirtualThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
