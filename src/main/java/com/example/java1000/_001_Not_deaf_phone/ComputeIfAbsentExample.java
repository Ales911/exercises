package com.example.java1000._001_Not_deaf_phone;

import java.util.HashMap;
import java.util.Map;

//import static org.junit.Assert.assertEquals;

public class ComputeIfAbsentExample {

    public void test() {
        Map<String, Integer> stringLength = new HashMap<>();
        stringLength.put("John", 5);
//        assertEquals((long) stringLength.computeIfAbsent("John", s -> s.length()), 5);
    }

    public void test2() {
        Map<String, Integer> stringLength = new HashMap<>();
//        assertEquals((long) stringLength.computeIfAbsent("John", s -> s.length()), 4);
//        assertEquals((long) stringLength.get("John"), 4);
        System.out.println(stringLength);
    }

}
