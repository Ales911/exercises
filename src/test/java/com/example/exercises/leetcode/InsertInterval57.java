package com.example.exercises.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertInterval57 {

    boolean isIn(int start, int end, int val) {
        return val < end && val > start;
    }

    int[][] insertRange(int[][] to, int[] add, int index) {
        int[][] result = new int[to.length + 1][2];
        if (index == to.length) {
            System.arraycopy(to, 0, result, 0, to.length);
            result[result.length - 1] = add;
        } else {
            if (index == 0) {
                result[0] = add;
                System.arraycopy(to, 0, result, 1, to.length);
            } else {
                System.arraycopy(to, 0, result, 0, index);
                result[index] = add;
                System.arraycopy(to, index, result, index + 1, to.length - index);
            }
        }
        return result;
    }

    // only 1 remove
    int[][] removeRange(int[][] from, int index, int size) {
        int[][] result = new int[from.length - size][2];
        int j = 0;
        for (int i = 0; i < from.length; i++) {
            if (i != index /*|| (size > 1 && (i < index + size))*/) {
                result[j] = from[i];
                j++;
            }
        }
        return result;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int result[][] = {{}};

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (isIn(start, end, newInterval[0])) {
                if (!isIn(start, end, newInterval[1])) {
                    intervals[i][1] = newInterval[1];
                }
                continue;
            }

        }
        // return new int[][] {{1, 5}, {6,9}};
        return intervals;
    }

    @Test
    public void removeRangeTest1() {
        int[][] intervals = {{1, 1}, {2, 2}, {3, 3}};
        int[][] result = removeRange(intervals, 0, 1);
        int[][] expected = {{2, 2}, {3, 3}};
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    public void removeRangeTest2() {
        int[][] intervals = {{1, 1}, {2, 2}, {3, 3}};
        int[][] result = removeRange(intervals, 1, 1);
        int[][] expected = {{1, 1}, {3, 3}};
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    public void removeRangeTest3() {
        int[][] intervals = {{1, 1}, {2, 2}, {3, 3}};
        int[][] result = removeRange(intervals, 2, 1);
        int[][] expected = {{1, 1}, {2, 2}};
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }
    
    // @Test
    public void removeRangeTest4() {
        int[][] intervals = {{1, 1}, {2, 2}, {3, 3}};
        int[][] result = removeRange(intervals, 0, 2);
        int[][] expected = {{3, 3}};
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }
    
    // @Test
    public void removeRangeTest5() {
        int[][] intervals = {{1, 1}, {2, 2}, {3, 3}, {4, 4}};
        int[][] result = removeRange(intervals, 1, 2);
        int[][] expected = {{1, 1}, {4,4}};
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    public void insertRangeTest1() {
        int[][] intervals = {{1, 1}, {2, 2}, {3, 3}, {4, 4}};
        int[] add = {0, 0};
        int[][] result = insertRange(intervals, add, 0);
        int[][] expected = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}};
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void insertRangeTest2() {
        int[][] intervals = {{1, 1}, {2, 2}};
        int[] add = {9, 9};
        int[][] result = insertRange(intervals, add, 1);
        int[][] expected = {{1, 1}, {9, 9}, {2, 2}};
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    public void insertRangeTest3() {
        int[][] intervals = {{1, 1}, {2, 2}};
        int[] add = {3, 3};
        int[][] result = insertRange(intervals, add, 2);
        int[][] expected = {{1, 1}, {2, 2}, {3, 3}};
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }

    //@Test
    public void insertTest1() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] interval = {2, 5};
        int[][] expected = {{1, 5}, {6, 9}};
        int[][] result = insert(intervals, interval);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        Assertions.assertArrayEquals(expected, result);
    }
}
