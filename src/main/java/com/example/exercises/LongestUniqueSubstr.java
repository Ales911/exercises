package com.example.exercises;

import java.util.ArrayList;
import java.util.List;

public class LongestUniqueSubstr {
    
    public int getMaxLength(String in) {
        final int lenght = in.length();
        String tmp = "";
        int maxLength = 0;
        for (int i = 0; i < lenght - 1; i++) {
            for (int j = i; j < lenght; j++) {
                char ch = in.charAt(j);
                if (tmp.indexOf(ch) >= 0) {
                    if (maxLength < tmp.length()) {
                        System.out.println("pass N: " + i + ", tmp: " + tmp);
                        maxLength = tmp.length();
                    }
                    tmp = "" + ch;
                } else {
                    tmp = tmp + ch;
                }
            }
        }

        System.out.println("maxLength: " + maxLength);
        return maxLength;
    }

    

    public String getMaxString(String in) {
        final int lenght = in.length();
        List<String> strings = new ArrayList<>();
        String tmp = "";
        int maxLength = 0;

        for (int i = 0; i < lenght - 1; i++) {
            for (int j = i; j < lenght; j++) {
                char ch = in.charAt(j);
                if (tmp.indexOf(ch) >= 0) {
                    if ((maxLength <= tmp.length() && !strings.contains(tmp))) {
                        System.out.println("pass N: " + i + ", tmp: " + tmp);
                        maxLength = tmp.length();
                        strings.add(tmp);
                    }
                    tmp = "" + ch;
                } else {
                    tmp = tmp + ch;
                }
            }
        }

        System.out.println("maxLength: " + maxLength);
        System.out.println("strings: " + strings);
        final int maxL = maxLength;
        return strings.stream().filter(s -> s.length() == maxL).findFirst().get();
    }

}
