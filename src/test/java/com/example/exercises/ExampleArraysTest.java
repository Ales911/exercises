package com.example.exercises;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ExampleArraysTest {

    final private ExampleArrays arraysExample = new ExampleArrays();

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

    @ParameterizedTest
    @MethodSource("getTestDataBinarySearch")
    void binarySearchTest(int[] given, int expected) {
        Assertions.assertEquals(expected, arraysExample.binarySearch(given, 50));
    }

    @ParameterizedTest
    @MethodSource("getTestDataBinarySearch")
    void binarySearchExTest(int[] given, int expected) {
        Assertions.assertEquals(expected, arraysExample.binarySearchEx(given, 50));
    }

    @ParameterizedTest
    @MethodSource("getTestDataBinarySearch")
    void binarySearchRecursiveTest(int[] given, int expected) {
        Assertions.assertEquals(expected, arraysExample.binarySearchRecursive(given, 0, given.length - 1, 50));
    }

    public static Stream<Arguments> getTestDataBinarySearch() {
        return Stream.of(
                Arguments.of(new int[]{20, 30, 40, 50, 60}, 3),
                Arguments.of(new int[]{50, 60, 70}, 0),
                Arguments.of(new int[]{2, 3, 5, 7, 9, 50}, 5));
    }

    @Test
    void searchSecondMinimalTest() {
        int[] given = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        Assertions.assertEquals(24, arraysExample.searchSecondMinimal(given));
    }

    @Test
    void repeatInArrayTest() {
        List<Integer> expected = List.of(64, 42, 24);
        int[] given = {64, 42, 73, 41, 32, 24, 16, 24, 57, 42, 74, 55, 64};
        Assertions.assertIterableEquals(expected, arraysExample.repeatInArray(given));
    }

    @ParameterizedTest
    @MethodSource("getFindSmallestMissingPositiveTestData")
    public void getStreamTest(int[] input, int expected) {
        int actual = arraysExample.getFindSmallestMissingPositiveStream(input);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getFindSmallestMissingPositiveTestData")
    public void getSimpleTest(int[] input, int expected) {
        int actual = arraysExample.getFindSmallestMissingPositiveSimple(input);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getFindSmallestMissingPositiveTestData")
    public void getAriaTest(int[] input, int expected) {
        int actual = arraysExample.getFindSmallestMissingPositiveAria(input);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> getFindSmallestMissingPositiveTestData() {
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

    @Test
    void findSameInThreeArray() {
        List<Integer> actual = arraysExample.findSameInThreeArray(new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}});
        Assertions.assertEquals(List.of(3), actual);
    }

}
