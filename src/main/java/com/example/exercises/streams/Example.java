package com.example.exercises.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {

        // Example Builder
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
        builder.add(2);
        builder.add(3);
        Stream<Integer> stream = builder.build();
        stream.forEach(System.out::println);

        // ExampleConcat
        Stream<String> stream1 = Stream.of("apple", "banana", "orange");
        Stream<String> stream2 = Stream.of("grape", "melon", "pineapple");

        Stream.concat(stream1, stream2).forEach(System.out::println);

        // Example empty
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);

        // Stream from array
        int[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> iStream = Arrays.stream(numbers).boxed();
        iStream.forEach(System.out::println);

        // Stream.ofNullabl
        String name = null;
        Stream<String> sStream = Stream.ofNullable(name);
        sStream.forEach(System.out::println);

        // handle null values
        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");
        List<String> filteredList = list.stream()
                .map(s -> {
                    if (s == null) {
                        return "N/A";
                    }
                    // Perform other operations
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
        filteredList.forEach(System.out::println);

        List<Optional<String>> optionalList = Arrays.asList("apple", null, "banana", null, "orange")
                .stream()
                .map(Optional::ofNullable)
                .collect(Collectors.toList());
        optionalList.forEach(System.out::println);

        List<String> nonNullList = Arrays.asList("apple", null, "banana", null, "orange")
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        nonNullList.forEach(System.out::println);
        
        // ExampleJoining
        System.out.println("ExampleJoining: " + Stream.of("Shark", "Panda", "Sparow").collect(Collectors.joining(", ")));
    }

}
