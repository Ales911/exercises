package com.example.exercises.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToMap {

    public static void main(String[] args) {
        record Person(int id, String name) {

        };
        List<Person> listPerson = List.of(new Person(1, "vna"), new Person(2, "vid"));
        Map<Integer, Person> mapPerson = listPerson.stream().
                collect(Collectors.toMap(Person::id, Function.identity()));
        System.out.println(mapPerson);
    }

}
