package com.example.exercises.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    public void testFunctions() {
        List<String> names = Arrays.asList("Smith", "Gourav", "John", "Catania");
        Function<String, Integer> nameMappingFunction = str -> str.length();// String::length;
        List<Integer> nameLength = names.stream()
                .map(nameMappingFunction).toList();
        System.out.println(nameLength);
    }
}
