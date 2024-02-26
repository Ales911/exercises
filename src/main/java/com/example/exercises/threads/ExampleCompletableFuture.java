package com.example.exercises.threads;

import java.util.concurrent.CompletableFuture;

public class ExampleCompletableFuture {

    public static void main(String[] args) throws Exception {
        // CompletableFuture уже содержащий результат
        CompletableFuture.completedFuture("Просто значение");

        // CompletableFuture, запускающий (run) новый поток с Runnable, поэтому он Void
        CompletableFuture.runAsync(() -> {
            System.out.println("run " + Thread.currentThread().getName());
        });

        // CompletableFuture, запускающий новый поток, результат которого возьмём у Supplier
        CompletableFuture<String> supplier;
        supplier = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply " + Thread.currentThread().getName());
            return "Значение";
        });

        Thread.sleep(100);
    }
}
