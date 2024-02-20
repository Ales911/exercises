package com.example;

import java.util.*;

public class ExampleDecorator {

    public static void main(String[] arguments) {
        List<String> list = new ArrayList<>();
        List<String> decorated = Collections.checkedList(list, String.class);
        decorated.add("2");
        list.add("3");
        System.out.println(decorated);
    }

}
