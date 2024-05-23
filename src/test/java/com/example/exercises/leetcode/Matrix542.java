package com.example.exercises.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Matrix542 {

    record Pair(int x, int y) {

    }

    ;
    
    int find(int[][] mat, Pair p) {
        int result = 0;
        Set<Pair> visited = new HashSet<>();
        visited.add(p);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            Pair p1 = queue.poll();
            if (!visited.contains(p1)) {
                result = (mat[p1.x][p1.y] == 0) ? Math.abs(p.x - p1.x) + Math.abs(p.y - p1.y) : 0;
                visited.add(p1);
                if (result > 0) {
                    break;
                }
            }
            int left = p1.x - 1;
            if (left >= 0) {
                Pair p2 = new Pair(left, p1.y);
                if (!visited.contains(p2)) {
                    queue.add(p2);
                }
            }
            int up = p1.y - 1;
            if (up >= 0) {
                Pair p2 = new Pair(p1.x, up);
                if (!visited.contains(p2)) {
                    queue.add(p2);
                }
            }
            int right = p1.x + 1;
            if (right < mat.length) {
                Pair p2 = new Pair(right, p1.y);
                if (!visited.contains(p2)) {
                    queue.add(p2);
                }
            }
            int down = p1.y + 1;
            if (down < mat[0].length) {
                Pair p2 = new Pair(p1.x, down);
                if (!visited.contains(p2)) {
                    queue.add(p2);
                }
            }
        }
        return result;
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        if (mat.length == 1) {
            result[0] = updateMatrixOneD(mat[0]);
            return result;
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    result[i][j] = find(mat, new Pair(i, j));
                    //System.out.println("------------- val: " + result[i][j]);
                }
            }
        }
        return result;
    }

    //  **********************************
    int findZero(int[] given, int start) {
        int result = - 1;
        for (int i = start; i < given.length; i++) {
            if (given[i] == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    int[] updateMatrixOneD(int[] given) {
        int[] result = new int[given.length];
        int start = 0;
        int end = 1;
        while (start < end) {
            end = findZero(given, start);
            if (start == 0) {
                if (end == -1) {
                    break;
                }
                if ((end - start) >= 2) {
                    for (int i = 0, j = end; i < end; i++, j--) {
                        result[i] = j;
                    }
                }
            } else {
                if (end == -1) {
                    for (int i = start, j = 1; i < given.length; i++, j++) {
                        result[i] = j;
                    }
                    break;
                }
                if ((end - start) >= 3) {
                    int mid = start + (end - start) / 2;
                    for (int i = start, j = 1; i <= mid; i++, j++) {
                        result[i] = j;
                    }
                    for (int i = end - 1, j = 1; i >= mid; i--, j++) {
                        result[i] = j;
                    }
                } else {
                    for (int i = start; i < end; i++) {
                        result[i] = 1;
                    }
                }
            }
            start = end + 1;
            end = start + 1;
        }
        return result;
    }

    @Test
    public void updateMatrixTest1() {
        int[][] given = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Assertions.assertArrayEquals(expected, updateMatrix(given));
    }

    @Test
    public void updateMatrixTest2() {
        int[][] given = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        int[][] result = updateMatrix(given);
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void updateMatrixTest7() {
        int[][] given = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
        int[][] expected = {{0, 1, 0, 1, 2}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};

        int[][] result = updateMatrix(given);
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void updateMatrixTest20() {
        int[][] given = {{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};
        int[][] expected = {{0, 0, 1, 0, 1, 2, 1, 0, 1, 2}, {1, 1, 2, 1, 0, 1, 1, 1, 2, 3}, {2, 1, 2, 1, 1, 0, 0, 0, 1, 2}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 2}, {0, 0, 1, 1, 1, 0, 1, 1, 2, 3}, {1, 0, 1, 2, 1, 1, 1, 2, 1, 2}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 2}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 2, 1, 0}};

        int[][] result = updateMatrix(given);
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void updateMatrixTest48() {
        int[][] given = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] expected = {{19, 19, 19}, {18, 18, 18}, {17, 17, 17}, {16, 16, 16}, {15, 15, 15}, {14, 14, 14}, {13, 13, 13}, {12, 12, 12}, {11, 11, 11}, {10, 10, 10}, {9, 9, 9}, {8, 8, 8}, {7, 7, 7}, {6, 6, 6}, {5, 5, 5}, {4, 4, 4}, {3, 3, 3}, {2, 2, 2}, {1, 1, 1}, {0, 0, 0}};

        int[][] result = updateMatrix(given);
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void updateMatrixTest49() {
        // 20000
        int[] g1 = new int[10];
        for (int i = 0; i < g1.length; i++) {
            g1[i] = 1;
        }
        g1[g1.length - 1] = 0;
        int[][] given = {g1};

        int[] g2 = new int[10];
        for (int i = 0, j = g2.length - 1; i < g2.length - 1; i++, j--) {
            g2[i] = j;
        }
        int[][] expected = {g2};

        System.out.println("given lenght: " + given.length);
        for (int[] a : given) {
            System.out.println(Arrays.toString(a));
        }

        int[][] result = updateMatrix(given);
        System.out.println("result:");
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void updateMatrixTest49_2() {
        int[] g1 = {1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1};
        int[][] given = {g1};

        int[] g2 = {2, 1, 0, 1, 1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0, 1, 2, 3};
        int[][] expected = {g2};

        System.out.println("given lenght: " + given.length);
        for (int[] a : given) {
            System.out.println(Arrays.toString(a));
        }

        int[][] result = updateMatrix(given);
        System.out.println("result:");
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        Assertions.assertArrayEquals(expected, result);
    }

}
