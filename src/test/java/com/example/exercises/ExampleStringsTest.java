package com.example.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleStringsTest {

    ExampleStrings exampleStrings = new ExampleStrings();

    @Test
    void reverseStringBuilderTest() {
        String given = "String";
        String expected = "gnirtS";

        Assertions.assertEquals(expected, exampleStrings.reverseStringBuilder(given));
    }

    @Test
    void reverseTest() {
        String given = "String";
        String expected = "gnirtS";

        Assertions.assertEquals(expected, exampleStrings.reverse(given));
    }

    @Test
    void wordsCountTest() {
        String given = "Current task posted for Java developers developers";
        Map<String, Integer> expected = Map.of(
                "Current", 1,
                "task", 1,
                "posted", 1,
                "for", 1,
                "Java", 1,
                "developers", 2);

        Assertions.assertEquals(expected, exampleStrings.wordsCount(given));
    }

    @Test
    void searchNaiveTest() {
        String given = "aabaabaaaaaabaabaabaabbaaab";
        String sample = "aabaab";
        List<Integer> expected = List.of(0, 10, 13, 16);

        Assertions.assertEquals(expected, exampleStrings.searchNaive(given, sample));
    }

    @Test
    void searchKMPTest() {
        String given = "aabaabaaaaaabaabaabaabbaaab";
        String sample = "aabaab";
        List<Integer> expected = List.of(0, 10, 13, 16);

        Assertions.assertEquals(expected, exampleStrings.searchKMP(given, sample));
    }

    @Test
    void hashSetTest() {
        Set<String> hs = new HashSet<>();
        hs.add("Abcd");
        hs.add("efg");
        hs.add("abcd");
        String s = new String("Abcd");
        hs.add(s);
        hs.add("Abcdefg");

        System.out.println(hs);
    }

    @Test
    void canConstructTest() {
        String ransomNote = "a";
        String magazine = "b";

        Assertions.assertFalse(exampleStrings.canConstruct(ransomNote, magazine));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 != 0) {
                count++;
            }
        }
        return (count == 0) ? s.length() : s.length() - count + 1;
    }
    
    @Test
    void longestPalindromeTest1() {
        Assertions.assertEquals(7, longestPalindrome("abccccdd"));
    }
    
    @Test
    void longestPalindromeTest2() {
        Assertions.assertEquals(9, longestPalindrome("abcccceeedd"));
    }
    

}
