package com.example.exercises.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeSum15 {

    private Set<Integer> hashes = new HashSet<>();

    private void compose(int v1, int v2, int v3, List<List<Integer>> list) {
        Integer[] array = {v1, v2, v3};
        Arrays.sort(array);
        if (hashes.add(Arrays.hashCode(array))) {
            list.add(Arrays.asList(array));
        }
    }

    public List<List<Integer>> threeSumMy(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 3 && (0 == nums[0] + nums[1] + nums[2])) {
            result.add(List.of(nums[0], nums[1], nums[2]));
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }
        //Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int num1 = nums[i];
                    int num2 = nums[j];
                    int num3 = 0 - (num1 + num2);

                    if (!map.containsKey(num3)) {
                        continue;
                    }

                    if (num1 == num2 && num2 == num3 && map.get(num1) >= 3) {
                        compose(num1, num2, num3, result);
                        continue;
                    }

                    if (num1 == num2 && num2 != num3 && map.get(num1) >= 2) {
                        compose(num1, num2, num3, result);
                        continue;
                    }

                    if (num1 != num2 && num2 == num3 && map.get(num2) >= 2) {
                        compose(num1, num2, num3, result);
                        continue;
                    }

                    if (num1 != num2 && num1 == num3 && map.get(num1) >= 2) {
                        compose(num1, num2, num3, result);
                        continue;
                    }

                    if (num1 != num2 && num1 != num3 && num2 != num3) {
                        compose(num1, num2, num3, result);
                    }

                }
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(result);
        return result;
    }

//    Sort the given array in non-decreasing order.
//    Loop through the array from index 0 to n-1.
//    For each iteration, set the target as -nums[i].
//    Set two pointers, j=i+1 and k=n-1.
//    While j<k, check if nums[j]+nums[k]==target.
//    If yes, add the triplet {nums[i], nums[j], nums[k]} to the result and move j to the right and k to the left.
//    If no, move either j or k based on the comparison of nums[j]+nums[k] with target.
//    To avoid duplicate triplets, skip the iterations where nums[i]==nums[i-1] and also skip the iterations where nums[j]==nums[j-1] or nums[k]==nums[k+1].
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 3 && (0 == nums[0] + nums[1] + nums[2])) {
            result.add(List.of(nums[0], nums[1], nums[2]));
            return result;
        }
        Arrays.sort(nums);
        int lenght = nums.length;
        for (int i = 0; i < lenght; i++) {
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            
            int target = -nums[i];
            // start
            int j = i + 1;
            // end
            int k = lenght - 1;

            while (j < k) {

                   //System.out.println(i + " " + j + " " + k);
                   System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                
                // To avoid duplicate triplets, skip the iterations where nums[i]==nums[i-1] and 
                // also skip the iterations where nums[j]==nums[j-1] or nums[k]==nums[k+1].
                
//                if ((i > 0 && nums[i] == nums[i - 1]) || (j > 0 && nums[j] == nums[j - 1]) || (nums[k] < lenght && nums[k] == nums[k + 1])) {
//                    continue;
//                }

                if (nums[j] + nums[k] == target) {
                    // If yes, add the triplet {nums[i], nums[j], nums[k]} to the result and move j to the right and k to the left.
                    // add
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    j++;
                    k--;
                } else {
                    // If no, move either j or k based on the comparison of nums[j]+nums[k] with target.                    
                    if (nums[j] + nums[k] > target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }

        }
        return result;
    }
    

    public List<List<Integer>> threeSumChatGPT(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);  // Sort the array to use two-pointer technique and skip duplicates easily
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {  // Skip duplicate elements for i
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move both pointers to avoid duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // We need a larger number
                } else {
                    right--;  // We need a smaller number
                }
            }
        }
        
        return result;
    }

    

    @Test
    public void threeSumTest0() {
        int[] given = {0, 0, 0};
        List<List<Integer>> expected = List.of(List.of(0, 0, 0));
        Assertions.assertIterableEquals(expected, threeSumMy(given));
    }

    @Test
    public void threeSumTestMy() {
        int[] given = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        Assertions.assertIterableEquals(expected, threeSumMy(given));
    }

    @Test
    public void threeSumTest() {
        int[] given = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        Assertions.assertIterableEquals(expected, threeSum(given));
    }
    
    @Test
    public void threeSumChatGPTTest() {
        int[] given = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        Assertions.assertIterableEquals(expected, threeSumChatGPT(given));
    }
            

}
