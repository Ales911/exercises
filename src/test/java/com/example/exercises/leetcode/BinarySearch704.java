package com.example.exercises.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearch704 {

    int search(int start, int end, int[] nums, int target) {

        if (start > end) {
            return -1;
        }

        if (start == end) {
            return (nums[start] == target) ? start : -1;
        }

        if (end - start == 1) {
            if (nums[start] == target) {
                return start;
            } else {
                if (nums[end] == target) {
                    return end;
                } else {
                    return -1;
                }
            }
        }

        int index = (end + start) / 2;
        int i = nums[index];
        if (i == target) {
            return index;
        } else {
            if (target > i) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            return search(start, end, nums, target);
        }
    }

    public int search(int[] nums, int target) {
        return search(0, nums.length - 1, nums, target);
    }

    @Test
    public void searchTest1() {
        Assertions.assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    @Test
    public void searchTest2() {
        Assertions.assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    @Test
    public void searchTest3() {
        Assertions.assertEquals(1, search(new int[]{2, 5}, 5));
    }

    @Test
    public void searchTest4() {
        Assertions.assertEquals(2, search(new int[]{-1, 0, 5}, 5));
    }

}
