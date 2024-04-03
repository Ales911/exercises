package com.example.exercises;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NonRepeatInArrayTest {
    
    private final NonRepeatInArray nonRepeatInArray = new NonRepeatInArray();
    
    @ParameterizedTest
    @MethodSource("getTestData")
    void testXor(int[] input, int expected) {
        Assertions.assertEquals(expected, nonRepeatInArray.findXor(input));
    }
    
    @ParameterizedTest
    @MethodSource("getTestData")
    void testSort(int[] input, int expected) {
        Assertions.assertEquals(expected, nonRepeatInArray.findSort(input));
    }
    
    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new int[] {9, 1, 7, 2, 6, 1, 2, 7, 6}, 9),
                Arguments.of(new int[] {9, 1, 7, 2, 6, 1, 2, 7, 9}, 6));
    }
    
    
    
}
