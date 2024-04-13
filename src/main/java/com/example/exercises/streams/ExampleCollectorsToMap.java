package com.example.exercises.streams;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleCollectorsToMap {

    // @formatter:off
    record Book(String name, int releaseYear, String isbn) {};
    record Person(String name, int age) {};
    // @formatter:on
    
    Map<String, String> listBookToMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::isbn, Book::name));
    }
    
    Map<Integer, Book> listToMapWithDupKeyError(List<Book> books) {
        return books.stream().collect(
            Collectors.toMap(Book::releaseYear, Function.identity()));
    }
    
    Map<Integer, Book> listToMapWithDupKey(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::releaseYear, Function.identity(),
            (existing, replacement) -> existing));
    }
    
    Map<Integer, Book> listToConcurrentMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::releaseYear, Function.identity(),
            (o1, o2) -> o1, ConcurrentHashMap::new));
}    

    Map<String, Integer> listPersonToMap(List<Person> persons) {
        return persons.stream().collect(Collectors.toMap(Person::name, Person::age));
    }
    
    Map<String, Person> listPersonToMapEx1(List<Person> persons) {
        return persons.stream().collect(Collectors.toMap(Person::name, Function.identity()));
    }
    
}
