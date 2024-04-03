package com.example.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseIntTest {
    
    ReverseInt reverseInt = new ReverseInt();
    
    @Test
    void test123() {
        Assertions.assertEquals(321, reverseInt.reverse(123));
    }
    
    @Test
    void test321N() {
        Assertions.assertEquals(-123, reverseInt.reverse(-321));
    }
    
    @Test
    void test120() {
        Assertions.assertEquals(21, reverseInt.reverse(120));
    }
    
    @Test
    void testMax() {
        Assertions.assertEquals(0, reverseInt.reverse(Integer.MAX_VALUE));
    }
    
    @Test
    void testMin() {
        Assertions.assertEquals(0, reverseInt.reverse(Integer.MIN_VALUE));
    }
    
    
}
