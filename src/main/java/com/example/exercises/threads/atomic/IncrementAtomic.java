package com.example.exercises.threads.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class IncrementAtomic {

    private final static AtomicInteger ai = new AtomicInteger(0);

    private final static class IncrementalTask implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 1_000_000; i++) {
                ai.incrementAndGet();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 = new Thread(new IncrementalTask());
        Thread t2 = new Thread(new IncrementalTask());

        t1.start();
        t2.start();

        while (t1.isAlive() && t2.isAlive()) {
            Thread.sleep(100);
        }

        System.out.println(ai.get());

        final AtomicInteger aie = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0, 5_000_000).forEach(i -> executor.submit(aie::incrementAndGet));
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);

        System.out.println(aie.get());

    }

}
