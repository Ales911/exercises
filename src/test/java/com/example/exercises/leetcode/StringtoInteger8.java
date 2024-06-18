package com.example.exercises.leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringtoInteger8 {

    public int myAtoi(String s) {
        
        boolean negative = false;
        s = s.trim();
        if (s.startsWith("-")) {
            negative = true;
            s = s.replaceFirst("-", "");
        } else {
            if (s.startsWith("+")) {
                s = s.replaceFirst("\\+","");
            }
        }
        
        s = s.replaceAll("^0+", "");           

        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (number.length() < 11 && Character.isDigit(ch)) {
                number.append(ch);
            } else {
                break;
            }
        }

        if (number.length() == 0) {
            return 0;
        }

        // Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.        
        long lResult = Long.parseLong(number.toString());
        if (negative) {
            lResult = 0 - lResult;
        }
        
        final int result;
        if (lResult > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else {
            if (lResult < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
            } else {
                result = (int) lResult;
            }
        }

        return result;
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(String given, int expected) {
        Assertions.assertEquals(expected, myAtoi(given));
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("  -042", -42),
                Arguments.of("+1", 1),
                Arguments.of("  0000000000012345678", 12345678),
                Arguments.of("20000000000000000000", Integer.MAX_VALUE),
                Arguments.of("-91283472332", Integer.MIN_VALUE)
        );
    }

}
