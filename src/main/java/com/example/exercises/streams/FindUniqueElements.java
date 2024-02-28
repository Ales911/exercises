package com.example.exercises.streams;

import java.util.List;
import java.util.stream.Collectors;

public class FindUniqueElements {

    public static void main(String[] args) {
        final String given = "Hello world.";
        List<Character> list = given.chars().mapToObj(o -> (char) o).toList();
        List<Character> result = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1).map(e -> e.getKey()).toList();
        System.out.println("result: " + result);
    }

}
