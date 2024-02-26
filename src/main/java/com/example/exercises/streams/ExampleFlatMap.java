package com.example.exercises.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleFlatMap {

    public static <T> Stream<T> flatten(T[]... arrays) {
        Stream<T> stream = Stream.of(arrays).flatMap(Arrays::stream);
        return stream;
    }

    public static void main(String[] args) {
        String[] a = {"A", "B"};
        String[] b = {"C", "D"};
        String[] c = {"E", "F"};

        //String[] s = flatten(a, b, c).toArray(String[]::new);
        // System.out.println(Arrays.toString(s));        // [A, B, C, D, E, F]
        
        Stream<String> stream = Stream.of(a, b, c).flatMap(Arrays::stream);
        
        System.out.println(Arrays.toString(stream.toArray()));        // [A, B, C, D, E, F]
        
        
        List<String> a2 = Arrays.asList("A", "B");
        List<String> b2 = Arrays.asList("C", "D");
        List<String> c2 = Arrays.asList("E", "F");        
        
        Stream<String> stream2 = Stream.of(a2, b2, c2).flatMap(List::stream);
        
        System.out.println(stream2.collect(Collectors.toList()));        // [A, B, C, D, E, F]
    }

}
