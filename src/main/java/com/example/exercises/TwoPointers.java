package com.example.exercises;

public class TwoPointers {

    boolean twoSum(int[] input, int targetValue) {

        int pointerOne = 0;
        int pointerTwo = input.length - 1;

        while (pointerOne < pointerTwo) {
            int sum = input[pointerOne] + input[pointerTwo];

            if (sum == targetValue) {
                return true;
            } else if (sum < targetValue) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }

        return false;
    }

    int[] sortSqrArray(int[] given) {

        if (given[0] >= 0) {
            return given;
        }

        int[] result = new int[given.length];
        int begin = 0;
        int end = given.length - 1;
        int index = end;

        while (begin < end) {
            if (Math.abs(given[begin]) >= Math.abs(given[end])) {
                result[index] = given[begin] * given[begin];
                begin++;
            } else {
                result[index] = given[end] * given[end];
                end--;
            }
            index--;
        }

        result[index] = given[end] * given[end];

        return result;
    }

    // Rotate Array k Steps    
    // Problem: Given an array, rotate the array to the right by k steps,
    // where k is non-negative.
    // For example, if our input array is [1, 2, 3, 4, 5, 6, 7] and k is 4,
    // then the output should be [4, 5, 6, 7, 1, 2, 3].
    private void reverse(int[] input, int start, int end) {
        while (start < end) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] input, int step) {
        step %= input.length;
        reverse(input, 0, input.length - 1);
        reverse(input, 0, step - 1);
        reverse(input, step, input.length - 1);
    }

}
