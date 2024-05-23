package com.example.exercises.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumSubarray53 {

    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int result = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < size; i++) {
            maxEndingHere = maxEndingHere + nums[i];
            if (nums[i] > maxEndingHere) {
                maxEndingHere = nums[i];
                if (result < maxEndingHere) {
                }
            }
            if (result < maxEndingHere) {
                result = maxEndingHere;
            }
        }
        return result;
    }
    
    @Test
    public void maxSubArray() {
        int[] given = {-2,1,-3,4,-1,2,1,-5,4};
        int expected = 6;
        Assertions.assertEquals(expected, maxSubArray(given));
    }

}
