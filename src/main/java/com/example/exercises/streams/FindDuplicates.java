package com.example.exercises.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {
        final List<String> sSource = List.of("apple", "banana", "apple", "orange", "banana", "grape", "orange");
//        final Map<String, List<String>> r1 = strings.stream()
//                .collect(Collectors.groupingBy(s -> s));
//        System.out.println("r1: " + r1);
//
//        List<Entry<String, List<String>>> r2 = r1.entrySet().stream().filter(entry -> entry.getValue().size() > 1).toList();
//        System.out.println("r2: " + r2);
//
//        List<String> r3 = r2.stream().map(Entry::getKey).toList();
//        System.out.println("r3: " + r3);
        // List<String> duplicates = 
                Map<String, Long> duplicates = sSource.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() > 1)
//                .map(entry -> entry.getKey())
//                .toList();
        System.out.println("Source: " + sSource);
        System.out.println("Duplicates: " + duplicates);

        // ---------------------------
        int[] aSource = {1, 2, 3, 1, 2, 4, 5};
        System.out.println(" --- ");
        List<Integer> iList = Arrays.stream(aSource)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Source: " + iList);
        System.out.println("Duplicates: ");
        iList.stream()
                .filter(i -> Collections.frequency(iList, i) > 1)
                .distinct()
                .forEach(System.out::print);
        System.out.println();

        // Write a program to find the first repeating element/character from a given string using Java Streams.
        System.out.println(" --- ");
        String source = "Hello world.";
        System.out.println("Source: " + source);
        List<Character> ls = source.chars().mapToObj(o -> (char) o).toList();
        Character result = ls.stream().dropWhile(i -> Collections.frequency(ls, i) <= 1).findFirst().orElseThrow();
        System.out.println("first repeating element: " + result);

        System.out.println(" --- ");
        Set sCharachters = new HashSet();
        result = ls.stream().filter(e -> !sCharachters.add(e)).findFirst().orElseThrow();
        System.out.println("first repeating element: " + result);

        // Write a program to find the second-highest element from an array. The array can contain duplicate elements. Solve it using Java 8 streams.
        System.out.println("Source: " + iList);
        Integer i = iList.stream()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .distinct().limit(2).toList().get(1);
        System.out.println("second-highest element: " + i);

    }

}
