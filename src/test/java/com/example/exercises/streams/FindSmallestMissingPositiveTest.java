package com.example.exercises.streams;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestMethodOrder(OrderAnnotation.class)
public class FindSmallestMissingPositiveTest {

    private final FindSmallestMissingPositive findSmallestMissingPositive = new FindSmallestMissingPositive();

    @Order(2)  
    @ParameterizedTest
    @MethodSource("getTestData")
    public void getStreamTest(int[] input, int expected) {
        int actual = findSmallestMissingPositive.getStream(input);
        Assertions.assertEquals(expected, actual);
    }
    
    @Order(3)  
    @ParameterizedTest
    @MethodSource("getTestData")
    public void getSimpleTest(int[] input, int expected) {
        int actual = findSmallestMissingPositive.getSimple(input);
        Assertions.assertEquals(expected, actual);
    }
    
    @Order(1)  
    @ParameterizedTest
    @MethodSource("getTestData")
    public void getAriaTest(int[] input, int expected) {
        int actual = findSmallestMissingPositive.getAria(input);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 0}, 3),
                Arguments.of(new int[]{7, 8, 9, 11, 12}, 1),
                Arguments.of(new int[]{3, 4, -1, 1}, 2),
                Arguments.of(new int[]{8, 5, -5, 35, -101, 4, 99, 1, 2, 3, 9, 6, 7, 55, 54, 53, 52, 51,
                    49, 48, 47, 46, 45, 44, 43, 42, 41, 40,
                    39, 38, 37, 36, 35, 34, 33, 32, 31, 30,
                    29, 28, 27, 26, 25, 24, 23, 22, 21, 20,
                    19, 18, 17, 16, 15, 14, 13, 12, 11, 10
                }, 50));
    }

}
