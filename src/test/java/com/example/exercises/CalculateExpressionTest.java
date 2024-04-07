package com.example.exercises;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculateExpressionTest {
    
    private final CalculateExpression calculateExpression = new CalculateExpression();
    
    @ParameterizedTest
    @MethodSource("getTestData")
    void test1(String input, int expected) {
        Assertions.assertEquals(expected, calculateExpression.calculate(input));
    }
    
    public static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("1+0", 1),
                Arguments.of("0+1", 1),
                Arguments.of("0*1", 0),
                Arguments.of("1*0", 0),
                Arguments.of("0*0", 0),
                Arguments.of("0+0", 0),
                Arguments.of("1*2+1", 3),
                Arguments.of("1+2*1", 3),
                Arguments.of("11+2*3", 17),
                Arguments.of("11*2+3", 25),
                Arguments.of("11+2*3*4", 35),
                Arguments.of("11*2+3*4", 34),
                Arguments.of("10*2+3*2", 26),
                Arguments.of("11*2*3", 66),
                Arguments.of("11+2+3", 16),
                Arguments.of("4*2*3", 24),
                Arguments.of("4+2+3", 9),
                Arguments.of("11+2*1", 13));
    }
    
}
