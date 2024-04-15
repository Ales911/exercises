package com.example.exercises.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public void testPredicate() {
        List<String> names = Arrays.asList("Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartsWithS).forEach(System.out::println);
    }

    public void testPredicateAndComposition() {
        List<String> names = Arrays.asList("Smith", "Samueal", "Catley", "Sie");
        Predicate<String> startPredicate = str -> str.startsWith("S");
        Predicate<String> lengthPredicate = str -> str.length() >= 5;
        names.stream()
                .filter(startPredicate.and(lengthPredicate))
                .forEach(System.out::println);
    }
}
