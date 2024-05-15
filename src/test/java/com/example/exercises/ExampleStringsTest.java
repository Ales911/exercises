package com.example.exercises;

import java.util.List;
import java.util.Map;
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

}
