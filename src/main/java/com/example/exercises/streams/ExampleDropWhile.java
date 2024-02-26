package com.example.exercises.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleDropWhile {

    private final Logger log = LoggerFactory.getLogger(ExampleDropWhile.class);

    void example1() {
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
        log.info("example1(): " + numbersStream.dropWhile(x -> x > 1).collect(Collectors.toList()));
    }

    void example2() {
        Stream<Integer> numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        //numbers.sorted().dropWhile(n -> n < 0).forEach(n -> System.out.println(n));
        log.info("example2(): " + numbers.dropWhile(x -> x < 0).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        ExampleDropWhile exampleDropWhile = new ExampleDropWhile();

        exampleDropWhile.example1();
        exampleDropWhile.example2();
    }

}
