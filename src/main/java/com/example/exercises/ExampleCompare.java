package com.example.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ExampleCompare {

    // ************************************************************
    record Phone(String name, int price) {

    }

    // ************************************************************
    class PhoneComparator implements Comparator<Phone> {

        @Override
        public int compare(Phone p1, Phone p2) {
            if (p1.price() > p2.price()) {
                return 1;
            }
            return -1;
        }
    }

    // ************************************************************
    void example1() {
        List<Phone> phones = new ArrayList<>();
        phones.addAll(Arrays.asList(new Phone[]{
            new Phone("iPhone 8", 52000),
            new Phone("Nokia 9", 35000),
            new Phone("Samsung Galaxy S9", 48000),
            new Phone("HTC U12", 36000)
        }));

        Phone min = phones.stream().min(new PhoneComparator()).get();
        Phone max = phones.stream().max(new PhoneComparator()).get();
        System.out.printf("MIN Name: %s Price: %d \n", min.name(), min.price());
        System.out.printf("MAX Name: %s Price: %d \n", max.name(), max.price());
    }

    // ************************************************************
    void example2() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println(min.get());  // 1        
    }

    // ************************************************************
    public static void main(String[] args) {
        ExampleCompare exampleCompare = new ExampleCompare();

        exampleCompare.example1();
        exampleCompare.example2();
    }

}
