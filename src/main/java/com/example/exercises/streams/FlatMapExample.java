package com.example.exercises.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> original = Map.of(1, List.of(1, 2), 2, List.of(3, 4, 5));

        Map<Integer, Integer> source = original.entrySet().stream().flatMap(entry -> {
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();
            return value.stream().map(v -> Map.entry(v, key));
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        System.out.println(source);
    }

}
