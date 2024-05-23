package com.example.exercises.streams;

import java.util.Comparator;
import java.util.List;

public class ExampleSort {

    public static void main(String[] args) {
        // Given an array of integers, find the kth largest element.
        List<Integer> list = List.of(1, 12, 44, 32, 52, 81, 59, 84, 72, 37);

        int k = 4;

        Integer num = list.stream().sorted(Comparator.reverseOrder()).limit(k).skip(k - 1).findFirst().orElse(-1);
        System.out.println(num);
    }

}
