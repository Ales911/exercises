package com.example.exercises.leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MedianofTwoSortedArrays4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int merge[] = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                merge[k] = nums1[i];
                i++;
            } else {
                merge[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            merge[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n2) {
            merge[k] = nums2[j];
            j++;
            k++;
        }

        int len = merge.length;

        if (len % 2 == 0) {
            return (merge[len / 2] + merge[len / 2 - 1]) / 2.0;
        } else {
            return merge[len / 2];
        }
    }

    public double findMedianSortedArraysMy(int[] nums1, int[] nums2) {

        double result = 0;

        int length1 = nums1.length;
        int length2 = nums2.length;
        int length0 = nums1.length + nums2.length;
        
        // чётный
        boolean even = length0 % 2 == 0;

        int middle = Math.ceilDiv(length0, 2);
        if (even) {
            middle++;
        }


        int value = 0, pred, index1 = 0, index2 = 0;

        do {

            pred = value;

            if (index1 < length1 && index2 < length2) {
                if (nums1[index1] <= nums2[index2]) {
                    value = nums1[index1];
                    index1++;
                } else {
                    value = nums2[index2];
                    index2++;
                }
            } else {
                if (index1 < length1) {
                    value = nums1[index1];
                    index1++;
                } else {
                    value = nums2[index2];
                    index2++;
                }
            }

            if (index1 + index2 == middle) {
                result = even ? (pred + value) / 2.0 : value;
                break;
            }

        } while (true);
        
        return result;

    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(int[] given1, int[] given2, double expected) {
        Assertions.assertEquals(expected, findMedianSortedArrays(given1, given2));
    }
    
    @ParameterizedTest
    @MethodSource("getTestData")
    void testMy(int[] given1, int[] given2, double expected) {
        Assertions.assertEquals(expected, findMedianSortedArraysMy(given1, given2));
    }
    

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5)
        );
    }

}
