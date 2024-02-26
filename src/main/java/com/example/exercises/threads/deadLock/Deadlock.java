package com.example.exercises.threads.deadLock;

public class Deadlock {

    public static void main(String[] args) {
        new DeadLockSynchronizedExample().synchronizedDeadLock();
        // new DeadLockBarrierExmple().barrierDeadLock();
    }
}
