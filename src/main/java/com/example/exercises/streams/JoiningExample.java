package com.example.exercises.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningExample {

    public static void main(String[] args) {
        System.out.println(Stream.of("Shark", "Panda", "Sparow").collect(Collectors.joining(", ")));
    }
    
}
