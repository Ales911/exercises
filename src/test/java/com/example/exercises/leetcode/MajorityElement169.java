package com.example.exercises.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MajorityElement169 {

    public int majorityElementBoyerMoore(int[] nums) {
        int count = 0;
        int candidate = 0;
        int maj = nums.length / 2;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate > maj) {
                break;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElement(int[] nums) {
        int result = 0;
        int maj = nums.length / 2;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            int count = m.merge(j, 1, Integer::sum);
            if (count > maj) {
                result = j;
                break;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] given = {3, 2, 3};
        Assertions.assertEquals(3, majorityElementBoyerMoore(given));
    }

    @Test
    public void test2() {
        int[] given = {2, 2, 1, 1, 1, 2, 2};
        Assertions.assertEquals(2, majorityElementBoyerMoore(given));
    }

    @Test
    public void test3() {
        int[] given = {1, 2, 1, 1, 2, 2, 2};
        Assertions.assertEquals(2, majorityElementBoyerMoore(given));
    }

}
