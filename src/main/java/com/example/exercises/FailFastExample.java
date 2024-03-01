package com.example.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FailFastExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");

        // Create an iterator
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);

            // Simulate concurrent modification
            if (name.equals("Bob")) {
                list.remove(name); // This could throw ConcurrentModificationException
            }
        }
        System.out.println(list);

        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        Iterator<String> it = myList.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            // if (value.equals("3")) { // This throw ConcurrentModificationException
            if (value.equals("4")) {
                myList.remove(value);
            }
        }
        System.out.println(myList);
        
        Map<String, String> myMap = new HashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");
        Iterator<String> it1 = myMap.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            System.out.println("Map Value:" + myMap.get(key));
            if (key.equals("2")) {
                myMap.put("1", "4");
                //myMap.put("4", "4");
            }
        }
        System.out.println(myMap);
    }
}
