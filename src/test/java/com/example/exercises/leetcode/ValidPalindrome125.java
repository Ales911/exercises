package com.example.exercises.leetcode;

public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
        StringBuilder sbRight = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch>='A' && ch <= 'Z') {
                ch += 32;
            }
            if ((ch >= 'a' && ch <= 'z') || ((ch >= '0' && ch <= '9'))) {
                sbRight.append(ch);
            }
        }
        String strRight = sbRight.toString();
        return strRight.equals(sbRight.reverse().toString());
    }

    void start() {
        // System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static void main(String[] args) {
        new ValidPalindrome125().start();
    }

}
