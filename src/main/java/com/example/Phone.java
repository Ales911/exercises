package com.example;

import java.util.Comparator;

class Phone {

    private final String name;
    private final int price;

    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static int compare(Phone p1, Phone p2) {
        if (p1.getPrice() > p2.getPrice()) {
            return 1;
        }
        return -1;
    }
    
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

//    @Override
//    public int compare(Phone p1, Phone p2) {
//            if (p1.getPrice() > p2.getPrice()) {
//                return 1;
//            }
//            return -1;
//    }
}