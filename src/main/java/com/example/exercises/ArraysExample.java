package com.example.exercises;

import java.util.ArrayList;
import java.util.List;

public class ArraysExample {

    public void sort(int array[]) {
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

    public int matrixDiagonalSum(int[][] mat) {
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

    public void moveZeroes(int array[]) {
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

    public int nonRepeatInArray(int array[]) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }

    public void reverse(int array[]) {
        // Collections.reverse(list);
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
    
    public List<Integer> repeatInArray(int[] given) {
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

}
