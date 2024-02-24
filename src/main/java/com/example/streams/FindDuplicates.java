package com.example.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 4, 5};
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .distinct()
                .forEach(System.out::println);
    }

}
