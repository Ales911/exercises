package com.example.exercises.streams;

import java.util.Arrays;
import java.util.List;

public class ExampleFilter {

    public static void main(String[] args) {
        String str = "a1b2c3d4e5f6g7h8i9j0";
        char[] arr = str.toCharArray();
        System.out.println("Original array: " + Arrays.toString(arr));
        int[] nums = new String(arr)
                .chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .toArray();
        System.out.println("Numbers only: " + Arrays.toString(nums));

        //  Given a list of strings, remove all strings that contain a specific character using streams.
        List<String> list = List.of("apple", "banana", "orange", "kiwi");
        char specificChar = 'a';
        List<String> collect = list.stream().filter(s -> !s.contains(String.valueOf(specificChar))).toList();
        System.out.println(collect);

    }

}
