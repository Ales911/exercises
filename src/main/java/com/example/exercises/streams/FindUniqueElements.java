package com.example.exercises.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class FindUniqueElements {

    public static void main(String[] args) {
        //final String given = "Hello world.";
        final String given = "articles are Awesome";
        List<Character> list = given.chars().mapToObj(o -> (char) o).toList();

        // Write a program to find unique elements in a given string using Java streams.
        List<Character> result = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1).map(e -> e.getKey()).toList();
        System.out.println("non-repeating elements from a given string: " + result);

        System.out.println("non-repeating elements from a given string: "
                + list.stream().filter(e -> Collections.frequency(list, e) == 1).toList());

        // Write a program to find the first non-repeating element from a given string using Java Streams.
        System.out.println("first non-repeating element from a given string: "
                + list.stream().filter(e -> Collections.frequency(list, e) == 1).findFirst().get());

        //System.out.println("first non-repeating element from a given string: "
        List<Character> listUnique
                = list.stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                        .entrySet().stream()
                        .filter(e -> e.getValue() == 1).map(e -> e.getKey()).toList();
        //  Find the first non-repeated character using Java 8 concepts like Streams, Functional Interfaces, and method references
        System.out.println("first non-repeating element from a given string: "
                + list.stream().filter(c -> listUnique.contains(c)).findFirst().get());
    }

}
