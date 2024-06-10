package com.example.exercises.leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {

        if (nums.length == 1) {
            return (nums[0] == val) ? 0 : 1;
        }

        int k = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                while (end >= start) {
                    end--;
                    k++;
                    if (nums[end + 1] != val) {
                        nums[start] = nums[end + 1];
                        nums[end + 1] = val;
                        start++;
                        break;
                    }
                }
            } else {
                start++;
            }
        }
        return nums.length - k;
    }

    int removeElement2(int[] nums, int val) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }

        }

        return count;
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(int[] given, int target, int expected) {
        Assertions.assertEquals(expected, removeElement(given, target));
    }
    
    @ParameterizedTest
    @MethodSource("getTestData")
    void test2(int[] given, int target, int expected) {
        Assertions.assertEquals(expected, removeElement2(given, target));
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new int[]{4, 5}, 5, 1),
                Arguments.of(new int[]{3, 3}, 3, 0),
                Arguments.of(new int[]{1}, 1, 0),
                Arguments.of(new int[]{3, 2, 2, 3}, 3, 2),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5)
        );
    }
}
