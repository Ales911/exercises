package com.example.exercises;

import java.util.PriorityQueue;
import java.util.Queue;

public class ExamplePriorityQueue {

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>((v1, v2) -> 0);
        // Queue<String> queue = new PriorityQueue<>();
        queue.add("Bob");
        queue.add("Andrew");
        queue.add("John");
        queue.add("Rob");
        System.out.println(queue);
        System.out.println("---");
        while (!queue.isEmpty()) {
            // System.out.println(queue.remove());
            System.out.println(queue.poll());
        }
    }

}
