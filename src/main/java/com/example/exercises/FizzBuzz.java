package com.example.exercises;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

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

    public static void main(String[] args) {
//        boolean found = false;
//        for (int i = 1; i <= 100; i++) {
//            found = false;
//            if (i % 3 == 0) {
//                System.out.print("Fizz");
//                found = true;
//            }
//            if (i % 5 == 0) {
//                System.out.print("Buzz");
//                found = true;
//            }
//            if (!found) {
//                System.out.print(i);
//            }
//            System.out.println();
//        } 

        System.out.println(sum().size() + ": " + sum());
    }

}