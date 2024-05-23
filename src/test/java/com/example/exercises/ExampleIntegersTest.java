package com.example.exercises;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ExampleIntegersTest {

    private final ExampleIntegers exampleIntegers = new ExampleIntegers();

    @Test
    void reverseTest123() {
        Assertions.assertEquals(321, exampleIntegers.reverse(123));
    }

    @Test
    void reverseTest321N() {
        Assertions.assertEquals(-123, exampleIntegers.reverse(-321));
    }

    @Test
    void reverseTest120() {
        Assertions.assertEquals(21, exampleIntegers.reverse(120));
    }

    @Test
    void reverseTestMax() {
        Assertions.assertEquals(0, exampleIntegers.reverse(Integer.MAX_VALUE));
    }

    @Test
    void reverseTestMin() {
        Assertions.assertEquals(0, exampleIntegers.reverse(Integer.MIN_VALUE));
    }

    @ParameterizedTest
    @MethodSource("getTestDataisPrimeNumber")
    void isPrimeNumberFalseTest(int input, boolean expected) {
        Assertions.assertEquals(expected, exampleIntegers.isPrimeNumber(input));
    }

    public static Stream<Arguments> getTestDataisPrimeNumber() {
        return Stream.of(
                Arguments.of(23, true),
                Arguments.of(22, false));
    }

    @ParameterizedTest
    @MethodSource("getTestDataGetFirstDigit")
    void getFirstDigitTest(int input, int expected) {
        Assertions.assertEquals(expected, exampleIntegers.getFirstDigit(input));
    }

    public static Stream<Arguments> getTestDataGetFirstDigit() {
        return Stream.of(
                Arguments.of(321, 3),
                Arguments.of(3, 3),
                Arguments.of(39, 3),
                Arguments.of(390235, 3));
    }

    @ParameterizedTest
    @MethodSource("getTestDataGetCountDigit")
    void getCountDigitTest(int input, int expected) {
        Assertions.assertEquals(expected, exampleIntegers.getCountDigit(input));
    }

    public static Stream<Arguments> getTestDataGetCountDigit() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(0, 1),
                Arguments.of(3, 1),
                Arguments.of(999, 3),
                Arguments.of(1000, 4),
                Arguments.of(1001, 4),
                Arguments.of(1999, 4),
                Arguments.of(Integer.MAX_VALUE, 10));
    }
    
    
    void methodForParamTest(Integer param) {
        param++;
    }
    
    @Test
    void paramTest1() {
        Integer given = 0;
        methodForParamTest(given);
        Assertions.assertEquals((Integer) 0, given);
    }
    
    void methodForParamTest2(int param) {
        param++;
    }
    
    @Test
    void paramTest2() {
        int given = 0;
        methodForParamTest2(given);
        Assertions.assertEquals(0, given);
    }

}