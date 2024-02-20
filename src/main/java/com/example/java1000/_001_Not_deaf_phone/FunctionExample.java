package com.example.java1000._001_Not_deaf_phone;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {

    public void testFunctions() {
        List<String> names = Arrays.asList("Smith", "Gourav", "John", "Catania");
        Function<String, Integer> nameMappingFunction = str -> str.length();// String::length;
        List<Integer> nameLength = names.stream()
                .map(nameMappingFunction).collect(Collectors.toList());
        System.out.println(nameLength);
    }
}
