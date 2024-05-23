package com.example.exercises.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleGroupingBy {

    public static void main(String[] args) {
        // Write a program to find the first non-repeating character in a string using streams.
        String str = "abacdbef";

        Optional<Character> firstNonRepeatingChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println(firstNonRepeatingChar.get());
    }

}
