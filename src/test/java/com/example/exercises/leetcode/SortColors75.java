package com.example.exercises.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SortColors75 {

    public void sortColors(int[] nums) {
//        int p0 = 0;
//        int p2 = nums.length - 1;
//        int i = 0;
//        while (i <= p2) {
//            if (nums[i] == 0) {
//                if (i == p0) {
//                    p0++;
//                    i++;
//                } else {
//                    int tmp = nums[p0];
//                    nums[p0] = 0;
//                    nums[i] = tmp;
//                    p0++;
//                }
//            } else {
//                if (nums[i] == 2) {
//                    int tmp = nums[p2];
//                    nums[p2] = 2;
//                    nums[i] = tmp;
//                    p2--;
//                } else {
//                    i++;
//                }
//            }
//        }

        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else {
                if (nums[i] == 1) {
                    count1++;
                }
            }
        }

        if (count0 > 0) {
            Arrays.fill(nums, 0, count0, 0);
        }
        if (count1 > 0) {
            Arrays.fill(nums, count0, count0 + count1, 1);
        }

        Arrays.fill(nums, count0 + count1, nums.length, 2);

    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(int[] given, int[] expected) {
        sortColors(given);
        System.out.println(Arrays.toString(given));
        Assertions.assertArrayEquals(expected, given);
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                Arguments.of(new int[]{2, 0, 1}, new int[]{0, 1, 2})
        );
    }

}
