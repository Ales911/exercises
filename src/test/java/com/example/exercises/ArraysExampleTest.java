package com.example.exercises;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ArraysExampleTest {

    final private ArraysExample arraysExample = new ArraysExample();

    @Test
    void sortTest() {
        int given[] = new int[]{5, 5, 0, 5, 0};
        int expected[] = new int[]{0, 0, 5, 5, 5};

        arraysExample.sort(given);

        Assertions.assertArrayEquals(expected, given);
    }

    @Test
    void matrixDiagonalSumTest() {
        int[][] given = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Assertions.assertEquals(25, arraysExample.matrixDiagonalSum(given));
    }

    @Test
    void moveZeroesTest() {
        // При массиве: [0,1,0,3,12]
        // Вывод должен быть: [1,3,12,0,0]    
        int[] given = {0, 1, 0, 3, 12};
        int expected[] = {1, 3, 12, 0, 0};
        arraysExample.moveZeroes(given);
        Assertions.assertArrayEquals(expected, given);
    }

    @ParameterizedTest
    @MethodSource("getTestDataNonRepeatInArrayTest")
    void nonRepeatInArrayTest(int[] input, int expected) {
        Assertions.assertEquals(expected, arraysExample.nonRepeatInArray(input));
    }

    public static Stream<Arguments> getTestDataNonRepeatInArrayTest() {
        return Stream.of(
                Arguments.of(new int[]{9, 1, 7, 2, 6, 1, 2, 7, 6}, 9),
                Arguments.of(new int[]{9, 1, 7, 2, 6, 1, 2, 7, 9}, 6),
                Arguments.of(new int[]{9, 1, 7, 2, 6, 6, 2, 7, 9}, 1));
    }
    
    @ParameterizedTest
    @MethodSource("getTestDataReverseTest")
    void reverseTest(int[] given, int[] expected) {
        arraysExample.reverse(given);
        Assertions.assertArrayEquals(expected, given);
    }
    
    public static Stream<Arguments> getTestDataReverseTest() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}),
                Arguments.of(new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8}, new int[]{8, 6, 4, 2, 9, 7, 5, 3, 1}));
    }
    

}
