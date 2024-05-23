package com.example.exercises.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> result = new ArrayList<>();

        if ((words.length < 1) || (words.length > 10000)) {
            System.out.println("More than 10000 words.");
            return result;
        }

        Set<String> input = new HashSet<>();
        int sum = 0;

        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());

        for (String word : words) {

            sum = sum + word.length();
            if (sum > 100000) {
                System.out.println("Sum words length > 100000.");
                return result;
            }

            if ((word.length() < 1) || (word.length() > 30)) {
                continue;
            } else {
                if (!word.toLowerCase().equals(word) || !input.add(word)) {
                    System.out.println("Wrong words.");
                    return result;
                }
            }

            String tmp = word;

            for (String token : words) {
                if ((word.length() > token.length()) && word.contains(token)) {
                    tmp = tmp.replaceAll(token, "");
                    if (tmp.length() == 0) {
                        result.add(word);
                        break;
                    }
                }
            }

        }

        return result;
    }

}
