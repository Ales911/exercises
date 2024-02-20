package com.example.threads;

import java.util.concurrent.CompletableFuture;

public class ExampleCompletableFuture3 {

    public static void main(String[] args) throws Exception {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");

        future.thenApply(result -> {
            System.out.println(result + " all"); //output Hi all
            return result;
        });

        future.thenApply(result -> {
            System.out.println(result + ", world!"); //output Hi, world!
            return result;
        });

        future.get();
    }
}
