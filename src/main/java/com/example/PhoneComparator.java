package com.example;

import java.util.Comparator;

public class PhoneComparator implements Comparator<Phone> {

    /**
     *
     * @param p1
     * @param p2
     * @return
     */
    @Override
    public int compare(Phone p1, Phone p2) {
        if (p1.getPrice() > p2.getPrice()) {
            return 1;
        }
        return -1;
    }
}
