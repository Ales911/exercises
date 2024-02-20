package com.example.java1000._001_Not_deaf_phone;

public class Main {

    public static void main(String[] strings) {
        Object lock = new Object();
        new StepThread(lock).start();
        new StepThread(lock).start();
    }
}
