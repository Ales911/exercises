package com.example.exercises;

import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestUniqueSubstrTest {
    
    private String given = "geeksforgeeks";
    
    @Test
    public void getMaxStringTest() {
        String actual = new LongestUniqueSubstr().getMaxString(given);
        Set<String> expected = Set.of("eksforg", "ksforge");
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void getMaxL() {
        int actual = new LongestUniqueSubstr().getMaxLength(given);
        assertEquals(7, actual);
    }
    
}
