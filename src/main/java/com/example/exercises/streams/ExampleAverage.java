package com.example.exercises.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class ExampleAverage {

    public static void main(String[] args) {
        
        // Write a program to find the average of a list of doubles using streams.
        List<Double> doubles = List.of(1.2, 3.5, 2.8, 4.1, 5.7);
        OptionalDouble average = doubles.stream().mapToDouble(Double::doubleValue).average();
        System.out.println("average of a list of doubles: " + average.getAsDouble());
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double avg = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .mapToDouble(n -> n)
                .average()
                .orElse(0.0);
        System.out.println("The average of even numbers is " + avg);
    }

}
