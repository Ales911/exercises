package com.example.exercises.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleCollectors {

    public static void main(String[] args) {
        // Given a list of strings, concatenate them into a single string using streams.
        List<String> list = List.of("Hello", " ", "world", "!");

        String collect = list.stream().collect(Collectors.joining());
        System.out.println(collect);

        // Given a list of integers, partition them into two groups: odd and even, using streams.        
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> oddEvenPartition = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("oddEvenPartition: " + oddEvenPartition);
    }

}
