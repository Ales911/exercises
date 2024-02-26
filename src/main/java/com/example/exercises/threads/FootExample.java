package com.example.exercises.threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

class Foot implements Runnable {

    static final String LEFT = "left";
    static final String RIGHT = "right";

    private static final AtomicBoolean IS_LEFT_ORDER = new AtomicBoolean(true);

    private final String name;

    public Foot(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            step();
        }
    }

    private /*synchronized*/ void step() {
        
        if ((name.equals(LEFT) && IS_LEFT_ORDER.get()) || (name.equals(RIGHT) && !IS_LEFT_ORDER.get())) {
            System.out.println("Step by " + name);
            if (IS_LEFT_ORDER.get()) {
                IS_LEFT_ORDER.compareAndSet(true, false);
            } else {
                IS_LEFT_ORDER.compareAndSet(false, true);
            }
        } else {
            // System.out.println("Skip by " + name);
            // Thread.yield();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Foot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class FootExample {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Foot(Foot.LEFT)).start();
        new Thread(new Foot(Foot.RIGHT)).start();
    }
}
