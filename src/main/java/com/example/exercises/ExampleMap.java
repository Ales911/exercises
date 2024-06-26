package com.example.exercises;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExampleMap {

    public static void main(String[] args) {

        // ITVDN.com ТОП 20 тестовых заданий на интервью для Java разработчика
        HashMap<Integer, String> keyValue = new HashMap<>();
        keyValue.put(1, "Hello");
        keyValue.put(2, "World");
        keyValue.put(3, "Have a nice day!");
        System.out.println(keyValue.size());
        System.out.println("Цикл While:");
        Iterator<Map.Entry<Integer, String>> iterator = keyValue.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> qurentMe = iterator.next();
            System.out.println("Ключ это " + qurentMe.getKey() + " Значение это " + qurentMe.getValue());
        }

        System.out.println("Цикл For:");
        for (Map.Entry<Integer, String> qurentMe2 : keyValue.entrySet()) {
            System.out.println("Ключ это: " + qurentMe2.getKey() + " Значение это: " + qurentMe2.getValue());
        }

        System.out.println("Цикл forEach:");
        keyValue.forEach((key, value) -> System.out.println("Ключ это: " + key + " Значение это: " + value));

    }

}
