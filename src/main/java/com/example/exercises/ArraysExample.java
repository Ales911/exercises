package com.example.exercises;

import java.util.List;

public class ArraysExample {

    public static void main(String[] args) {
        // Write a program to sort two types of numbers to the left and right in an array.
        // Example: Integer array[] = [5, 5, 0, 5, 0] -> output: [0, 0, 5, 5, 5]
        Integer array[] = new Integer[] {5, 5, 0, 5, 0};
        
         java.util.Arrays.sort(array);

//        int n = array.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    // Swap arr[j] and arr[j+1]
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }

        System.out.println(List.of(array));

    }

}
