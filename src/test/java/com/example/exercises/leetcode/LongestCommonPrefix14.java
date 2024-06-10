package com.example.exercises.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if ((strs.length == 0) || strs[0].length() == 0) {
            return result;
        }

        if (strs.length == 1) {
            return strs[0];
        }

//        for (int i = 0; i <= strs[0].length(); i++) {
//            String str = strs[0].substring(0, i);
//            boolean b = true;
//            for (int j = 1; j < strs.length; j++) {
//                if (!strs[j].startsWith(str)) {
//                    b = false;
//                    break;
//                }
//            }
//            if (b) {
//                result = str;
//            }
//        }
//        return (index >= 0) ? strs[0].substring(0, index + 1) : "";


        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int i = 0;

        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }

        return i == 0 ? "" : s1.substring(0, i);
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(String[] given, String expected) {
        Assertions.assertEquals(expected, longestCommonPrefix(given));
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flower", "flower", "flower"}, "flower"),
                Arguments.of(new String[]{"ab", "a"}, "a"),
                Arguments.of(new String[]{"a"}, "a"),
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }

}
