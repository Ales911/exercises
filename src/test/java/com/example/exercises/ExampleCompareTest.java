package com.example.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleCompareTest {

    record Employee(int id, String name, int salary, String deptt, String city, int age) {

    }

    record Phone(String name, int price) {

    }

    Phone phoneIPhone = new Phone("iPhone 8", 52000);
    Phone phoneNokia = new Phone("Nokia 9", 35000);

    class PhoneComparator implements Comparator<Phone> {

        @Override
        public int compare(Phone p1, Phone p2) {
            if (p1.price() > p2.price()) {
                return 1;
            }
            return -1;
        }
    }

    List<Phone> phones = List.of(
            phoneIPhone,
            phoneNokia,
            new Phone("Samsung Galaxy S9", 48000),
            new Phone("HTC U12", 36000)
    );

    List<String> fruitsGiven = List.of("apple", "cherry", "banana", "pineapple", "kiwi", "elderberry");
    List<String> fruitsExpected = List.of("kiwi", "apple", "cherry", "banana", "pineapple", "elderberry");

    @Test
    void integerMinTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Assertions.assertEquals(Integer.valueOf(1), min.get());
        System.out.println(min.get());  // 1        
    }

    @Test
    void integerTest() {
        List<Integer> givenI = new ArrayList<>(List.of(3, 2, 90, 34, 21, 12));
        givenI.sort(Comparator.reverseOrder());
        List<Integer> expectedI = List.of(90, 34, 21, 12, 3, 2);
        System.out.println(givenI);
        Assertions.assertIterableEquals(expectedI, givenI);
    }

    @Test
    void phoneMinTest() {
        Optional<Phone> min = phones.stream().min(new PhoneComparator());
        Assertions.assertEquals(phoneNokia, min.get());
        System.out.printf("MIN Name: %s Price: %d \n", min.get().name(), min.get().price());
    }

    @Test
    void phoneMaxTest() {
        Optional<Phone> max = phones.stream().max(new PhoneComparator());
        Assertions.assertEquals(phoneIPhone, max.get());
        System.out.printf("MAX Name: %s Price: %d \n", max.get().name(), max.get().price());
    }

    @Test
    void fruitsCollectionsTest() {
        List<String> source = new ArrayList<>(fruitsGiven);
        Collections.sort(source, Comparator.comparingInt(String::length));
        System.out.println(source);
        Assertions.assertIterableEquals(fruitsExpected, source);
    }

    @Test
    void fruitsSortTest() {
        List<String> source = new ArrayList<>(fruitsGiven);
        source.sort(Comparator.comparingInt(String::length));
        System.out.println(source);
        Assertions.assertIterableEquals(fruitsExpected, source);
    }
    
    @Test
    void fruitsNullSortTest() {
        List<String> source = new ArrayList<>();
        source.add("Apple");
        source.add(null);
        source.add("Banana");
        source.add(null);
        List<String> expected = new ArrayList<>();
        expected.add(null);
        expected.add(null);
        expected.add("Banana");
        expected.add("Apple");
        source.sort(Comparator.nullsFirst(Comparator.reverseOrder()));
        System.out.println(source);
        Assertions.assertIterableEquals(expected, source);
    }
    
    @Test
    void employeeSortTest() {
        final List<Employee> given = new ArrayList<>(List.of(
                new Employee(1, "John Smith", 5000, "Marketing", "New York", 28),
                new Employee(2, "Jane Doe", 6000, "Engineering", "Chicago", 21),
                new Employee(3, "Bob Johnson", 4500, "Engineering", "Pune", 21),
                new Employee(4, "Sarah Lee", 5500, "HR", "Pune", 30),
                new Employee(5, "Alice", 7000, "HR", "San Francisco", 29),
                new Employee(6, "Emily", 6500, "Sales", "San Francisco", 27)));
        final List<Employee> expected = new ArrayList<>(List.of(
                new Employee(3, "Bob Johnson", 4500, "Engineering", "Pune", 21),
                new Employee(2, "Jane Doe", 6000, "Engineering", "Chicago", 21),
                new Employee(6, "Emily", 6500, "Sales", "San Francisco", 27),
                new Employee(1, "John Smith", 5000, "Marketing", "New York", 28),
                new Employee(5, "Alice", 7000, "HR", "San Francisco", 29),
                new Employee(4, "Sarah Lee", 5500, "HR", "Pune", 30)));
        
        given.sort(Comparator.comparingInt(Employee::age).thenComparing(Comparator.comparing(Employee::salary)));
        Assertions.assertIterableEquals(expected, given);
    }

}
