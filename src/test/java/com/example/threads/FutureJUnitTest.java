package com.example.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Test;

public class FutureJUnitTest {
    
    @Test
    public void hello() throws InterruptedException, ExecutionException {
        final Future<String> future = CompletableFuture
                .supplyAsync(() -> "Hello world!");

        System.out.println(future.get()); 
    }
}
