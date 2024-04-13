package com.example.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FindSmallestMissingPositive {

    int getStream(int[] in) {
        List<Integer> source = Arrays.stream(in).boxed().toList();
        // System.out.println("source: " + source);
        List<Integer> prepared = source.stream().distinct().filter(i -> i > 0).sorted().toList();
        // System.out.println("prepared: " + prepared);
        final int result;
        if (prepared.get(0) > 1) {
            result = 1;
        } else {
            OptionalInt oi = IntStream.rangeClosed(1, prepared.get(prepared.size() - 1)).filter(e -> !prepared.contains(e)).findFirst();
            if (oi.isEmpty()) {
                result = prepared.get(prepared.size() - 1) + 1;
            } else {
                result = oi.getAsInt();
            }
        }
        // System.out.println("result: " + result);
        return result;
    }

    int getSimple(int[] in) {
        int result = 1;
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            boolean found = false;
            for (int j = 0; j < in.length; j++) {
                if (i == in[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result = i;
                break;
            }
        }
        return result;
    }
    
    int getAria(int[] arr) {
        // System.out.println("Source: " + Arrays.toString(arr));
        int n = arr.length;

        // We iterate through the array and use swapping to place each element at its correct position.
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        // System.out.println("Prepared: " + Arrays.toString(arr));

        // Then, we iterate through the array again to find the first missing positive integer.
        // If all elements are in their correct positions, the result will be n + 1.
        final int result;
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                result = i + 1;
                // System.out.println("Result: " + result);
                return result;
            }
        }

        result = n + 1;
        // System.out.println("Result: " + result);
        return result;
    }

}
