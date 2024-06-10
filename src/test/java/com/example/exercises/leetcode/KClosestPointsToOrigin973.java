package com.example.exercises.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KClosestPointsToOrigin973 {

//    class Pair implements Comparable<Object> {
//
//        int index, distance;
//
//        Pair(int index, int x, int y) {
//            this.index = index;
//            distance = x * x + y * y;
//        }
//
//        @Override
//        public int compareTo(Object object) {
//            int result = 0;
//            if (object instanceof Pair pair) {
//                result = this.distance - pair.distance;
//            }
//            return result;
//        }
//    }
//
    public int[][] kClosest(int[][] points, int k) {

        final Queue<int[]> queue = new PriorityQueue<>((v1, v2) -> (v1[0] * v1[0] + v1[1] * v1[1]) - (v2[0] * v2[0] + v2[1] * v2[1]));

        queue.addAll(Arrays.asList(points));

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }

    public int[][] kClosestList(int[][] points, int k) {

        final List<int[]> list = new ArrayList<>();

        list.addAll(Arrays.asList(points));
        list.sort((v1, v2) -> (v1[0] * v1[0] + v1[1] * v1[1]) - (v2[0] * v2[0] + v2[1] * v2[1]));

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    @Test
    void test1() {
        int[][] given = {{1, 3}, {-2, 2}};
        int[][] expected = {{-2, 2}};
        int[][] actual = kClosestList(given, 1);
        System.out.println(Arrays.toString(actual[0]));
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int[][] given = {{3, 3}, {5, 1}, {-2, 4}};
        int[][] expected = {{3, 3}, {-2, 4}};
        int[][] actual = kClosest(given, 2);
        System.out.println(Arrays.toString(actual[0]));
        System.out.println(Arrays.toString(actual[1]));
        Assertions.assertArrayEquals(expected, actual);
    }

}
