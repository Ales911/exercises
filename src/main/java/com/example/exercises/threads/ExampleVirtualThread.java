package com.example.exercises.threads;

import java.lang.Thread.State;
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
        Thread thread = Thread.ofVirtual().start(() -> System.out.println("Hello"));
        thread.join();

        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> future = myExecutor.submit(() -> System.out.println("Running thread"));
            future.get();
            System.out.println("Task completed");
            // ...
        } catch (ExecutionException ex) {
            Logger.getLogger(ExampleVirtualThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        // 2 ----------
        System.out.println("-- 2 ----------");
        Thread.Builder builder = Thread.ofVirtual().name("Thread-", 1);
        Runnable task = () -> {
            System.out.println(String.format("Thread ID: %d, Thread name: %s is working.",
                        Thread.currentThread().threadId(), Thread.currentThread().getName()));
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExampleVirtualThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        // name "worker-0"
        Thread t1 = builder.start(task);
        // t1.join();

        // name "worker-1"
        Thread t2 = builder.start(task);
        // t2.join();

        do {
            System.out.println(t1.getName() + " " + t1.getState());
            System.out.println(t2.getName() + " " + t2.getState());
            Thread.sleep(10);
        } while ((t1.getState() != State.TERMINATED) && (t2.getState() != State.TERMINATED));

        System.out.println("---");
        System.out.println(t1.getName() + " " + t1.getState());
        System.out.println(t2.getName() + " " + t2.getState());

    }

}
