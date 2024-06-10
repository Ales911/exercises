package com.example.exercises.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindFirstandLastPositionofElementinSortedArray34 {

    public int[] searchRange(int[] nums, int target) {
        
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = Arrays.binarySearch(nums, target);
        int end = start;

        if (start < 0) {
            return new int[]{-1, -1};
        }

        boolean leftDone = false;
        boolean rightDone = false;
        while (!leftDone || !rightDone) {
            if (!leftDone) {
                if (start == 0 || nums[start - 1] != target) {
                    leftDone = true;
                } else {
                    start--;
                }
            }
            if (!rightDone) {
                if (end == nums.length - 1 || nums[end + 1] != target) {
                    rightDone = true;
                } else {
                    end++;
                }
            }
        }
        return new int[]{start, end};
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(int[] given, int target, int[] expected) {
        Assertions.assertArrayEquals(expected, searchRange(given, target));
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                Arguments.of(new int[]{}, 0, new int[]{-1, -1}),
                Arguments.of(new int[]{7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9}, 7, new int[]{0, 0}),
                Arguments.of(new int[]{7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9}, 8, new int[]{1, 10}),
                Arguments.of(new int[]{7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9}, 10, new int[]{-1, -1}),
                Arguments.of(new int[]{1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 11, 12, 12, 12, 12, 12, 13}, 2, new int[]{1, 4}),
                Arguments.of(new int[]{-999985131, -999953607, -999953607, -999915742, -999883817, -999849817, -999822901, -999815377, -999810801, -68594, -49967, 200394, 114012, 999969829, 999973689, 999975494}, -999953607, new int[]{1, 2})
        );
    }

}
