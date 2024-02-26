package com.example.exercises.threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

class Leg implements Runnable {

    private static final AtomicInteger NEXT = new AtomicInteger(1);

    private final int number;

    public Leg(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {
            step();
        }
    }

    private void step() {
        if (NEXT.get() == number) {
            System.out.println("Step by " + number);
            if (NEXT.get() < 40) {
                NEXT.incrementAndGet();
            } else {
                NEXT.set(1);
            }
        } else {
            // System.out.println("Skip by " + number);
            // Thread.yield();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Leg.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}

public class LegExample {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 40; i++) {
            new Thread(new Leg(i)).start();
            // Thread.ofVirtual().start(new Leg(i)); 
            //Thread.startVirtualThread(new Leg(i));
        }
    }
}
