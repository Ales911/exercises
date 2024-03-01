package com.example.exercises.streams;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindUniqueElementsTest {

    final String given = "Hello world.";
    final List<Character> list = given.chars().mapToObj(o -> (char) o).toList();

    @Test
    public void FindUniqueElements() {
        List<Character> result = list.stream().filter(e -> Collections.frequency(list, e) == 1).toList();
        Assertions.assertEquals(7, result.size());
    }

    @Test
    public void FindUniqueElementsGroupBy() {
        List<Character> result = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1).map(e -> e.getKey()).toList();
        Assertions.assertEquals(7, result.size());
    }

}
