package com.example.streams;

import java.util.stream.Stream;

public class ExampleMap {
    
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stream2 = stream.map(String::valueOf);
        stream2.forEach(System.out::println);
    }
    
}
