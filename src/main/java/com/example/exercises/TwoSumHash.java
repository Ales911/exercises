package com.example.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHash {

    static int[] twoSum(int[] given, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = given.length;
        for (int i = 0; i < length; i++) {
            int j = target - given[i];
            if (map.containsKey(j)) {
                return new int[]{i, map.get(j)};
            }
            map.put(given[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] given = {2, 4, 11, 15};
        System.out.println(Arrays.toString(twoSum(given, 15)));
    }

}
