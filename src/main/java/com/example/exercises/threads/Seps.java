package com.example.exercises.threads;

public class Seps {
    
    public static void main(String[] strings) {
        final Object lock = new Object();
        new StepThread(lock).start();
        new StepThread(lock).start();
    }
}
