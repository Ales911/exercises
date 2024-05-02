package com.example.exercises;

import java.util.ArrayList;
import java.util.List;

public class ExampleIntegers {

    int getFirstDigit(int value) {
        int result = 0;

        do {
            if ((value > 0) && (value < 10)) {
                result = value;
            }
            value = value / 10;
        } while (value > 0);

        return result;
    }

    int getCountDigit(int value) {
//        System.out.println("value: " + value);
//        double logV = Math.log10(value);
//        System.out.println("logV: " + logV);
//        double floorDouble = Math.floor(logV);
//        System.out.println("floorDouble: " + floorDouble);
//        int intCast = (int) floorDouble;
//        System.out.println("intCast: " + intCast);

        return value == 0 ? 1 : 1 + (int) Math.floor(Math.log10(value));
    }

    int reverse(int value) {
        long result = 0;
        while (value != 0) {
            int digit = value % 10;
            result = result * 10 + digit;
            value = value / 10;

            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                result = 0;
                break;
            }
        }
        return (int) result;
    }

    // числа от 0 до 1000, которые делятся на 3, но не делятся на 5, и сумма цифр в которых меньше десяти. 
    static List<Integer> sum() {
        List<Integer> result = new ArrayList<>();
        for (int i = 3; i < 1000; i = i + 3) {
            if ((i % 5 != 0)
                    // ex 621
                    && // 100th : 6
                    (i / 100
                    + // 10th : 2
                    (i / 10) % 10
                    + // 1th : 1
                    i % 10) < 10) {
                result.add(i);
            }
        }
        return result;
    }

    boolean isPrimeNumber(int number) {
        int tempNumber;
        boolean result = true;
        for (int x = 2; x <= number / 2; x++) {
            tempNumber = number % x;
            if (tempNumber == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sum().size() + ": " + sum());

        // Swap 2 numbers 
        int a = 10;
        int b = 20;

        System.out.println("a is " + a + " and b is " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping, a is " + a + " and b is " + b);

    }

}
