package com.example.exercises.streams;

import java.util.List;
import java.util.stream.Stream;

public class ExampleConcat {

    public static void main(String[] args) {
        // Merge two lists of integers and remove duplicates using streams.
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4, 5);

        List<Integer> collect = Stream.concat(list1.stream(), list2.stream()).distinct().toList();
        System.out.println(collect);
    }

}
