package com.example.exercises;

import java.util.HashMap;
import java.util.Map;

public class ExampleStrings {

    public static void main(String[] args) {
        // Reverse String
        String given = "String1";
        System.out.println(new StringBuilder(given).reverse());

        for (int i = given.length() - 1; i >= 0; i--) {
            System.out.print(given.charAt(i));
        }
        
        // подсчета количества конкретных слов в строке, используя HashMap
        String st = "Current task posted for Java developers developers";
        String[] words = st.split(" ");
        Map<String, Integer> keyValue = new HashMap<>();
        for (int i = 0; i <= words.length - 1; i++) {
            if (keyValue.containsKey(words[i])) {
                int counter = keyValue.get(words[i]);
                keyValue.put(words[i], counter + 1);
            } else {
                keyValue.put(words[i], 1);
            }
        }

        System.out.println(keyValue);
        
    }

}
