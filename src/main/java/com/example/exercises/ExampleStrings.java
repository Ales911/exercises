package com.example.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleStrings {

    String reverseStringBuilder(String given) {
        return new StringBuilder(given).reverse().toString();
    }

    String reverse(String given) {
        String result = "";
        for (int i = given.length() - 1; i >= 0; i--) {
            result = result + given.charAt(i);
        }
        return result;
    }

    // подсчета количества конкретных слов в строке, используя HashMap
    Map<String, Integer> wordsCount(String given) {
        String[] words = given.split(" ");
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i <= words.length - 1; i++) {
            if (result.containsKey(words[i])) {
                int counter = result.get(words[i]);
                result.put(words[i], counter + 1);
            } else {
                result.put(words[i], 1);
            }
        }

        System.out.println(result);
        return result;
    }

    // поиск строки в тексте
    List<Integer> searchNaive(String text, String sample) {
        List<Integer> foundPositions = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            while (j < sample.length() && i + j < text.length() && sample.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == sample.length()) {
                foundPositions.add(i);
            }
        }
        return foundPositions;
    }

    private int[] prefixFunction(String sample) {
        int[] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    List<Integer> searchKMP(String text, String sample) {
        List<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return found;
    }
}
