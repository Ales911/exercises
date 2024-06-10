package com.example.exercises.leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InsertInterval57 {

    int[][] insertRange(int[][] to, int[] add, int index) {
        int[][] result = new int[to.length + 1][2];
        System.arraycopy(to, 0, result, 0, index);
        result[index] = add;
        System.arraycopy(to, index, result, index + 1, to.length - index);
        return result;
    }

    enum Overlapped {
        LEFT_NOT,
        LEFT_OVERLAPPED,
        IN,
        OVERLAPPED,
        RIGHT_OVERLAPPED,
        RIGHT_NOT
    }

    Overlapped insert(int[] to, int[] candidate) {
        final Overlapped result;
        if (candidate[0] < to[0]) {
            if (candidate[1] < to[0]) {
                result = Overlapped.LEFT_NOT;
            } else {
                if (candidate[1] >= to[0] && candidate[1] <= to[1]) {
                    to[0] = candidate[0];
                    result = Overlapped.LEFT_OVERLAPPED;
                } else {
                    to[0] = candidate[0];
                    to[1] = candidate[1];
                    result = Overlapped.OVERLAPPED;
                }
            }
        } else {
            if (candidate[0] <= to[1]) {
                if (candidate[1] <= to[1]) {
                    result = Overlapped.IN;
                } else {
                    to[1] = candidate[1];
                    result = Overlapped.RIGHT_OVERLAPPED;
                }
            } else {
                result = Overlapped.RIGHT_NOT;
            }
        }
        return result;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int index1 = 0;
        Overlapped overlapped = Overlapped.LEFT_NOT;
        while (index1 < intervals.length) {
            overlapped = insert(intervals[index1], newInterval);
            if (overlapped == Overlapped.IN) {
                return intervals;
            }
            if (overlapped == Overlapped.LEFT_NOT) {
                return insertRange(intervals, newInterval, index1);
            }
            if (overlapped != Overlapped.RIGHT_NOT) {
                // LEFT_OVERLAPPED, OVERLAPPED, RIGHT_OVERLAPPED
                break;
            }
            index1++;
        }

        if (overlapped == Overlapped.RIGHT_NOT) {
            return insertRange(intervals, newInterval, intervals.length);
        }

        // LEFT_OVERLAPPED, OVERLAPPED, RIGHT_OVERLAPPED
        int[] updated = intervals[index1];
        int index2 = 0;
        for (int i = intervals.length - 1; i > index1; i--) {
            if (updated[1] >= intervals[i][1]) {
                break;
            } else {
                // updated[1] < intervals[i][1]
                if (updated[1] >= intervals[i][0]) {
                    updated[1] = intervals[i][1];
                    break;
                } else {
                    // updated[1] < intervals[i][0])
                    index2++;
                }
            }
        }

        int[][] result = new int[index1 + index2 + 1][2];
        System.arraycopy(intervals, 0, result, 0, index1 + 1);
        System.arraycopy(intervals, intervals.length - index2, result, index1 + 1, index2);

        return result;
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(int[][] given, int interval[], int[][] expected) {
        int[][] result = insert(given, interval);
//        for (int[] result1 : result) {
//            System.out.println(Arrays.toString(result1));
//        }
        Assertions.assertArrayEquals(expected, result);
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}, new int[][]{{1, 5}, {6, 9}}),
                Arguments.of(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}, new int[][]{{1, 2}, {3, 10}, {12, 16}}),
                Arguments.of(new int[][]{}, new int[]{5, 7}, new int[][]{{5, 7}}),
                Arguments.of(new int[][]{{1, 5}}, new int[]{6, 8}, new int[][]{{1, 5}, {6, 8}}),
                Arguments.of(new int[][]{{1, 5}}, new int[]{0, 0}, new int[][]{{0, 0}, {1, 5}}),
                Arguments.of(new int[][]{{3, 5}, {12, 15}}, new int[]{6, 6}, new int[][]{{3, 5}, {6, 6}, {12, 15}})
        );
    }

    @ParameterizedTest
    @MethodSource("getInsertRangeTestData")
    void insertRangeTest(int[][] given, int[] add, int index, int[][] expected) {
        int[][] result = insertRange(given, add, index);
        Assertions.assertArrayEquals(expected, result);
    }

    public static Stream<Arguments> getInsertRangeTestData() {
        int[][] given = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        int[] add = new int[]{9, 9};
        return Stream.of(
                Arguments.of(given, add, 0, new int[][]{{9, 9}, {1, 1}, {2, 2}, {3, 3}}),
                Arguments.of(given, add, 1, new int[][]{{1, 1}, {9, 9}, {2, 2}, {3, 3}}),
                Arguments.of(given, add, 2, new int[][]{{1, 1}, {2, 2}, {9, 9}, {3, 3}}),
                Arguments.of(given, add, 3, new int[][]{{1, 1}, {2, 2}, {3, 3}, {9, 9}})
        );
    }

    // only 1 remove
    int[][] removeRange(int[][] from, int index, int size) {
        int[][] result = new int[from.length - size][2];
        int j = 0;
        for (int i = 0; i < from.length; i++) {
            if (i != index /*|| (size > 1 && (i < index1 + size))*/) {
                result[j] = from[i];
                j++;
            }
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("getRemoveRangeTestData")
    public void removeRangeTest(int[][] given, int index, int count, int[][] expected) {
        int[][] result = removeRange(given, index, count);
//        for (int[] a : result) {
//            System.out.println(Arrays.toString(a));
//        }
        Assertions.assertArrayEquals(expected, result);
    }

    public static Stream<Arguments> getRemoveRangeTestData() {
        int[][] given = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        return Stream.of(
                Arguments.of(given, 0, 1, new int[][]{{2, 2}, {3, 3}}),
                Arguments.of(given, 1, 1, new int[][]{{1, 1}, {3, 3}}),
                Arguments.of(given, 2, 1, new int[][]{{1, 1}, {2, 2}})
        //                Arguments.of(given, 0, 2, new int[][]{{1, 1}, {3, 3}}),
        //                Arguments.of(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}}, 1, 2, new int[][]{{1, 1}, {4, 4}})
        );
    }

}
