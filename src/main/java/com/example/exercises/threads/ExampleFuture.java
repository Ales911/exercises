package com.example.exercises.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ExampleFuture {

    public static void main(String[] args) throws Exception {
        Callable task = () -> {
            return "Hello, World!";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        System.out.println(future.get());
    }
}
