package com.example.streams;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleReduce {

    record Phone(String name, int price) {

    }

    private final Logger log = LoggerFactory.getLogger(ExampleReduce.class);

    void example1() {
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> result = numbersStream.reduce((x, y) -> x * y);
        log.info("example1(): " + String.valueOf(result.get())); // 720
    }

    void example2() {
        Stream<String> wordsStream = Stream.of("mom", "cleaned", "window");
        Optional<String> sentence = wordsStream.reduce((x, y) -> x + " " + y);
        log.info("example2(): " + sentence.get()); // mom cleaned window
    }

    void example3() {
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
        int result = numbersStream.reduce(2, (x, y) -> x * y);
        log.info("example3(): " + result); // 1440
    }

    void example4() {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000),
                new Phone("LG G 4", 32000));

        int sum = phoneStream.reduce(0,
                (x, y) -> {
                    if (y.price() < 50000) {
                        return x + y.price();
                    } else {
                        return x + 0;
                    }
                },
                (x, y) -> x + y);

        log.info("example4(): " + sum); // 117000
    }

    public static void main(String[] args) {
        ExampleReduce exampleReduce = new ExampleReduce();

        exampleReduce.example1();
        exampleReduce.example2();
        exampleReduce.example3();
        exampleReduce.example4();
    }

}
