package com.example.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleCachedThreadPool {

    public static void main(String[] args) {
        Object lock = new Object();
        ExecutorService executorService = Executors.newWorkStealingPool();// newCachedThreadPool();
        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());
            lock.wait(2000);
            System.out.println("Finished");
            return "result";
        };
        for (int i = 0; i < 5; i++) {
            executorService.submit(task);
        }
        executorService.shutdown();
    }
}
