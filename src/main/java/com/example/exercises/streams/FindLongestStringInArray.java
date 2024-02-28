package com.example.exercises.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindLongestStringInArray {

    public static void main(String[] args) {

        String[] source = new String[] {"1", "12", "123", "ab", "abc"};

        Optional<String> max = Stream.of(source)
                // max((s1, s2) -> s1.length() - s2.length());
                .max(Comparator.comparing(String::length));
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        
        List<String> longestStrings = Stream.of(source)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1)
                .collect(Collectors.toList());

        System.out.println("Longest string(s): " + longestStrings);        

        Map.Entry<Integer, List<String>> maxEntry = Stream.of(source)
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                // .max((e1, e2) -> e1.getKey() - e2.getKey())
                .max(Map.Entry.comparingByKey())
                .orElseThrow();

        System.out.println(maxEntry.getValue());
    }

}
