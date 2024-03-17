package com.example.exercises.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindCountOfWordsInString {

    public static void main(String[] args) {
        String str = "this is word count for word is good";
        Map<String, Long> mapStr = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));
        System.out.println(mapStr);
    }

}
