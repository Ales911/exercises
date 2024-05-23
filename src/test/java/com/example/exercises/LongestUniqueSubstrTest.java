package com.example.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LongestUniqueSubstrTest {

    int getMaxLengthBruteForce(String s) {
        final int lenght = s.length();
        if (lenght <= 1) {
            return lenght;
        }
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 0; i < lenght - 1; i++) {
            sb.setLength(0);
            for (int j = i; j < lenght; j++) {
                char ch = s.charAt(j);
                if (sb.indexOf(String.valueOf(ch)) != -1) {
                    sb.setLength(0);
                }
                sb.append(ch);
                if (result < sb.length()) {
                    // System.out.println("pass N: " + i + ", tmp: " + tmp);
                    result = sb.length();
                }
            }
        }
        return result;
    }

    int getMaxLength(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int start = 0, maxLen = 0, i = 0;
        for (; i < s.length(); i++) {
            Integer previousPos = m.put(s.charAt(i), i);
            if (previousPos != null && previousPos >= start) {
                if (i > start + maxLen) {
                    maxLen = i - start;
                }
                start = previousPos + 1;
            }
        }
        return (i > start + maxLen) ? i - start : maxLen;
    }

    @Test
    public void getMaxStringTest() {
        String given = "geeksforgeeks";
        String actual = new LongestUniqueSubstr().getMaxString(given);
        Set<String> expected = Set.of("eksforg", "ksforge");
        assertTrue(expected.contains(actual));
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    public void getMaxLengthBruteForceTest(String input, int expected) {
        assertEquals(expected, getMaxLengthBruteForce(input));
    }
    
    @ParameterizedTest
    @MethodSource("getTestData")
    public void getMaxLengthTest(String input, int expected) {
        assertEquals(expected, getMaxLength(input));
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("geeksforgeeks", 7),
                Arguments.of("abcabcbb", 3),
                Arguments.of("", 0),
                Arguments.of(" ", 1),
                Arguments.of("bbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("au", 2),
                Arguments.of("asjrgapa", 6),
                Arguments.of("aab", 2)
        );
    }

}
