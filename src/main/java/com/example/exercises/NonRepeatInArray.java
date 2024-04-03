package com.example.exercises;

import java.util.Arrays;

public class NonRepeatInArray {
    
    int findXor(int[] values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            result = result ^ values[i];
        }
        return result;
    }
    
    int findSort(int[] values) {
        Arrays.sort(values);
        int len = values.length;
        int result = -1;
        for (int i = 0; i < len - 2; i = i + 2) {
            if (values[i] != values[i + 1]) {
                result = values[i];
                break;
            }
        }
        
        if (result == -1) {
            result = values[len -1];
        }
        
        return result;
    }

    
}
