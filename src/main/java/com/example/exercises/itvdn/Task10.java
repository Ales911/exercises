package com.example.exercises.itvdn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task10 {

    public static void main(String[] args) {

        // ITVDN.com 10 из ТОП 20 тестовых заданий на интервью для Java разработчика
//        List testList = new ArrayList();
//        testList.add("50");
//        testList.add("60");
//        testList.add("70");
        
        // List<String> testList = Stream.of("50", "60", "70").collect(Collectors.toList());
        List<String> testList = List.of("50", "60", "70");
        
        System.out.println(testList.size());
        System.out.println("Цикл While:");
        Iterator iter = testList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("Улучшенный цикл For:");
        for (Object o : testList) {
            System.out.println(o);
        }

        System.out.println("Цикл For:");
        for (int i = 0; i < testList.size(); i++) {
            System.out.println(testList.get(i));
        }
    }
}
