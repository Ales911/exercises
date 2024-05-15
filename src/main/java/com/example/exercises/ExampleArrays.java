package com.example.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ExampleArrays {

    void sort(int array[]) {
        // Arrays.sort(array);
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    int matrixDiagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            sum = sum + mat[i][i];
            if (i != j) {
                sum = sum + mat[i][j];
            }
        }
        return sum;
    }

    void moveZeroes(int array[]) {
        int indexBegin = 0;
//        int indexEnd = given.length - 1;
//         System.out.println("-----");
//        int[] result = new int[given.length];
//        for (int i = 0; i < given.length; i++) {
//            System.out.println("given[i]: " + given[i] + ", i: " + i);
//            
//            if (indexBegin == indexEnd) {
//                result[indexBegin] = given[i];
//                break;
//            }
//            
//            if (given[i] == 0) {
//                System.out.println("Put to indexEnd: " + indexEnd);
//                result[indexEnd] = 0;
//                indexEnd--;
//            } else {
//                result[indexBegin] = given[i];
//                indexBegin++;
//            }
//        }
//        
        indexBegin = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[indexBegin] = array[i];
                indexBegin++;
            }
        }

        for (int i = indexBegin; i < array.length; i++) {
            array[i] = 0;
        }

        // System.out.println(Arrays.toString(given));
    }

    int nonRepeatInArray(int array[]) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }

    void reverse(int array[]) {
        // Collections.reverse(list);
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    List<Integer> repeatInArray(int[] given) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < given.length; i++) {
            for (int j = i + 1; j < given.length; j++) {
                if (given[i] == given[j]) {
                    result.add(given[i]);
                    break;
                }
            }
        }
        return result;
    }

    int binarySearch(int[] given, int key) {
        return Arrays.binarySearch(given, key);
    }

    int binarySearchEx(int array[], int key) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == key) {
                return middleIndex;
            } else {
                if (array[middleIndex] > key) {
                    endIndex = middleIndex - 1;
                } else {
                    startIndex = middleIndex + 1;
                }
            }
        }
        return -1;
    }

    int binarySearchRecursive(int array[], int startIndex, int endIndex, int elementToFind) {
        // System.out.println("startIndex: " + startIndex + " , endIndex: " + endIndex);
        if (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            } else {
                if (array[middleIndex] > elementToFind) {
                    return binarySearchRecursive(array, startIndex, middleIndex - 1, elementToFind);
                } else {
                    return binarySearchRecursive(array, middleIndex + 1, endIndex, elementToFind);
                }
            }
        }
        return -1;
    }

    int searchSecondMinimal(int array[]) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min2 = min;
                min = array[i];
            } else if (array[i] < min2 && array[i] != min) {
                min2 = array[i];
            }
        }

        return min2;
    }

    int getFindSmallestMissingPositiveStream(int[] in) {
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

    int getFindSmallestMissingPositiveSimple(int[] in) {
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

    int getFindSmallestMissingPositiveAria(int[] arr) {
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

    List<Integer> findSameInThreeArray(int[][] given) {
        List<Integer> result = new ArrayList<>();
        int index[] = {0, 0, 0};
        while ((index[0] < given[0].length) && (index[1] < given[1].length) && (index[2] < given[2].length)) {
            int v0 = given[0][index[0]];
            int v1 = given[1][index[1]];
            int v2 = given[2][index[2]];
            if (v0 == v1 && v0 == v2) {
                result.add(v0);
                index[0]++;
                index[1]++;
                index[2]++;
                continue;
            }
            int indexMin = (v0 < v1 && v0 < v2) ? 0 : (v1 < v2) ? 1 : 2;
            index[indexMin]++;
        }
        return result;
    }

}
