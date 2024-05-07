package com.example.exercises;

public class BinarySeach {

    static int searchBinaryRecursive(int array[], int startIndex, int endIndex, int elementToFind) {
        // System.out.println("startIndex: " + startIndex + " , endIndex: " + endIndex);
        if (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            } else {
                if (array[middleIndex] > elementToFind) {
                    return searchBinaryRecursive(array, startIndex, middleIndex - 1, elementToFind);
                } else {
                    return searchBinaryRecursive(array, middleIndex + 1, endIndex, elementToFind);
                }
            }
        }
        return -1;
    }

    static int searchBinary(int array[], int elementToFind) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            } else {
                if (array[middleIndex] > elementToFind) {
                    endIndex = middleIndex - 1;
                } else {
                    startIndex = middleIndex + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {16, 24, 32, 36, 41, 42, 42, 53, 55, 57, 64, 73, 74};

        System.out.println(searchBinaryRecursive(array, 0, array.length - 1, 53));
        System.out.println(searchBinary(array, 53));
    }

}
