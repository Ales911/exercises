package com.example.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    
    @Test
    void isPrimeNumberTrueTest() {
        Assertions.assertTrue(exampleIntegers.isPrimeNumber(23));
    }
    
    @Test
    void isPrimeNumberFalseTest() {
        Assertions.assertFalse(exampleIntegers.isPrimeNumber(22));
    }    
    
}