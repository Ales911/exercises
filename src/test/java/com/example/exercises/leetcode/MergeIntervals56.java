package com.example.exercises.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MergeIntervals56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int index = 0, indexNext = 1, countMerged = 0;
        while (index < intervals.length - 1) {
            if (indexNext < intervals.length && intervals[index][1] >= intervals[indexNext][0]) {
                // System.out.println(intervals[index][1] + ", " + intervals[indexNext][1]);
                intervals[index][1] = (intervals[index][1] > intervals[indexNext][1]) ? intervals[index][1] : intervals[indexNext][1];
                intervals[indexNext] = new int[]{-1, -1};
                countMerged++;
            } else {
                index = indexNext;
            }
            indexNext++;
        }

        int[][] result = new int[intervals.length - countMerged][2];
        int j = 0;
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                result[j] = interval;
                j++;
            }
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(int[][] given, int[][] expected) {
        int[][] result = merge(given);
//        for (int[] result1 : result) {
//            System.out.println(Arrays.toString(result1));
//        }
        Assertions.assertArrayEquals(expected, result);
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 4}, {0, 0}}, new int[][]{{0, 0}, {1, 4}}),
                Arguments.of(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, new int[][]{{1, 6}, {8, 10}, {15, 18}}),
                Arguments.of(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}}),
                Arguments.of(new int[][]{{1, 4}, {0, 4}}, new int[][]{{0, 4}}),
                Arguments.of(new int[][]{{1, 4}, {2, 3}}, new int[][]{{1, 4}}),
                Arguments.of(new int[][]{{1, 4}, {0, 2}, {3, 5}}, new int[][]{{0, 5}})
        );
    }

}
