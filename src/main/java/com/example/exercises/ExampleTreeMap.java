package com.example.exercises;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExampleTreeMap {
    
    record Person(String firstName, String lastName, int age) {
        
    }
    
    public static void main(String[] args) {
        TreeMap<Person, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> o.age));
        map.put(new Person("John", "Smith", 17), 0);
        map.put(new Person("Ivan", "Petrenko", 65), 0);
        map.put(new Person("Pedro", "Escobar", 32), 0);
        map.put(new Person("Radion", "Pyatkin", 14), 0);
        map.put(new Person("Sergey", "Vashkevich", 19), 0);
        
        Person firstAdultPerson = map.navigableKeySet().stream().filter(person -> person.age > 18).findFirst().get();
        
        Map<Person, Integer> youngPeopleMap = map.headMap(firstAdultPerson, false);
        Map<Person, Integer> adultPeopleMap = map.tailMap(firstAdultPerson, true);
        showAdvertisementToYoung(youngPeopleMap);
        showAdvertisementToAdult(adultPeopleMap);
    }
    
    private static void showAdvertisementToYoung(Map<Person, Integer> map) {
        map.entrySet().forEach(e -> e.setValue(e.getValue() + 1));
        System.out.println("Young:");
        map.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));
    }
    
    private static void showAdvertisementToAdult(Map<Person, Integer> map) {
        final Iterator<Map.Entry<Person, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, Integer> entry = (Map.Entry) iterator.next();
            entry.setValue(entry.getValue() + 1);
        }
        
        System.out.println("Adult:");
        map.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));
    }
    
}