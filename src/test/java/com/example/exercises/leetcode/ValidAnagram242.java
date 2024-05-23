package com.example.exercises.leetcode;

import java.util.Arrays;

public class ValidAnagram242 {

    public boolean isAnagram(String s, String t) {
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        return Arrays.equals(a1, a2);
    }

    void start() {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    
    public static void main(String[] args) {
        new ValidAnagram242().start();
    }
    
}
