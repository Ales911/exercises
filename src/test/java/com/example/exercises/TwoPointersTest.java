package com.example.exercises;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TwoPointersTest {

    private final TwoPointers twoPointers = new TwoPointers();

    @ParameterizedTest
    @MethodSource("getTestDataForTwoSum")
    void twoSumTest(int[] arg1, int arg2, boolean expected) {
        Assertions.assertEquals(expected, twoPointers.twoSum(arg1, arg2));
    }

    public static Stream<Arguments> getTestDataForTwoSum() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 3, 4, 6, 8, 9}, 11, true)
        );
    }
    
    @ParameterizedTest
    @MethodSource("getTestDataForSortSqrArray")
    void sortSqrArrayTest(int[] input, int[] expected) {
        Assertions.assertArrayEquals(expected, twoPointers.sortSqrArray(input));
    }

    public static Stream<Arguments> getTestDataForSortSqrArray() {
        return Stream.of(
                Arguments.of(new int[]{-3, 2, 4}, new int[]{4, 9, 16}),
                Arguments.of(new int[]{-100, - 90, -80, -10, -3, 0, 2, 4, 70}, new int[]{0, 4, 9, 16, 100, 4900, 6400, 8100, 10000})
        );
    }

    @ParameterizedTest
    @MethodSource("getTestDataForRotate")
    void rotateTest(int[] input, int step, int[] expected) {
        twoPointers.rotate(input, step);
        Assertions.assertArrayEquals(expected, input);
    }

    public static Stream<Arguments> getTestDataForRotate() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 4, new int[]{4, 5, 6, 7, 1, 2, 3})
        );
    }    
    
}
