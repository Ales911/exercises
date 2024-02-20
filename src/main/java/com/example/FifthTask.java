package com.example;

import java.util.HashMap;

public class FifthTask {

    public static void main(String[] args) {

        // ITVDN.com 5 из ТОП 20 тестовых заданий на интервью для Java разработчика
        String st = "Current task posted for Java developers developers";
        String[] words = st.split(" ");
        HashMap<String, Integer> keyValue = new HashMap<>();
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
