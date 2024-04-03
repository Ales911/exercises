package com.example.exercises;

public class ReverseInt {
    
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
    
}
