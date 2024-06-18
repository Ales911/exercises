package com.example.exercises.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductofArrayExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {
        int pref = 1;
        int index0 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (index0 >= 0) {
                    Arrays.fill(nums, 0);
                    return nums;
                }
                index0 = i;
            } else {
                pref = pref * nums[i];
            }
        }

        if (index0 >= 0) {
            Arrays.fill(nums, 0);
            nums[index0] = pref;
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = pref / nums[i];
        }

        return nums;
    }

    @Test
    void test() {
        int[] given = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        Assertions.assertArrayEquals(expected, productExceptSelf(given));
    }
}
