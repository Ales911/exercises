package com.example.exercises.leetcode;

import java.util.Stack;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EvaluateReversePolishNotation150 {

    int calculate(char operation, int x1, int x2) {
        int result = switch (operation) {
            case '+' ->
                x1 + x2;
            case '-' ->
                x2 - x1;
            case '*' ->
                x1 * x2;
            case '/' ->
                x2 / x1;
            default ->
                throw new IllegalArgumentException("");
        };
        return result;
    }

    int evalRPN(String[] params) {
        Stack<Integer> s = new Stack<>();
        for (String str : params) {
            if (str.length() > 1 || Character.isDigit(str.charAt(0))) {
                s.push(Integer.valueOf(str));
            } else {
                Integer v1 = s.pop();
                Integer v2 = s.pop();
                s.push(calculate(str.charAt(0), v1, v2));
            }
        }
        return s.pop();
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test(String[] given, int expected) {
        Assertions.assertEquals(expected, evalRPN(given));
    }

    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(new String[]{"4", "-2", "/", "2", "-3", "-", "-"}, -7),
                Arguments.of(new String[]{"3", "11", "+", "5", "-"}, 9),
                Arguments.of(new String[]{"3", "11", "5", "+", "-"}, -13),
                Arguments.of(new String[]{"3"}, 3),
                Arguments.of(new String[]{"18"}, 18),
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("getTestDataCalculate")
    void testCalculate(char operation, int x1, int x2, int expected) {
        Assertions.assertEquals(expected, calculate(operation, x1, x2));
    }

    public static Stream<Arguments> getTestDataCalculate() {
        return Stream.of(
                Arguments.of('+', 1, 2, 3));
    }

}
