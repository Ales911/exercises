package com.example.exercises.streams;

import com.example.exercises.streams.ExampleCollectorsToMap.Person;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CollectorsToMapExampleTest {

    private final List<ExampleCollectorsToMap.Book> bookList = List.of(
            new ExampleCollectorsToMap.Book("The Fellowship of the Ring", 1954, "0395489318"),
            new ExampleCollectorsToMap.Book("The Two Towers", 1954, "0345339711"),
            new ExampleCollectorsToMap.Book("The Return of the King", 1955, "0618129111"));

    private final List<ExampleCollectorsToMap.Person> persons = List.of(
            new ExampleCollectorsToMap.Person("Adam", 19),
            new ExampleCollectorsToMap.Person("Eva", 19));

    private final ExampleCollectorsToMap collectorsToMapExample = new ExampleCollectorsToMap();

    @Test
    public void whenConvertFromBookListToMap() {
        Assertions.assertTrue(collectorsToMapExample.listBookToMap(bookList).size() == 3);
    }

    @Test
    public void whenMapHasDuplicateKey_without_merge_function_then_runtime_exception() {
        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            collectorsToMapExample.listToMapWithDupKeyError(bookList);
        });

        Assertions.assertTrue(ex instanceof IllegalStateException);
    }

    @Test
    public void whenMapHasDuplicateKeyThenMergeFunctionHandlesCollision() {
        Map<Integer, ExampleCollectorsToMap.Book> booksByYear = collectorsToMapExample.listToMapWithDupKey(bookList);
        System.out.println(booksByYear);
        Assertions.assertEquals(2, booksByYear.size());
        Assertions.assertEquals("0395489318", booksByYear.get(1954).isbn());
    }

    @Test
    public void whenCreateConcurrentHashMap() {
        Map<Integer, ExampleCollectorsToMap.Book> result = collectorsToMapExample.listToConcurrentMap(bookList);
        System.out.println(result);
        Assertions.assertTrue(result instanceof ConcurrentHashMap);
    }

    @Test
    public void whenConvertFromPersonListToMap() {
        Assertions.assertTrue(collectorsToMapExample.listPersonToMap(persons).size() == 2);
    }

    @Test
    public void whenConvertFromPersonListEx1ToMap() {
        Map<String, Person> result = collectorsToMapExample.listPersonToMapEx1(persons);
        System.out.println(result);
        Assertions.assertTrue(result.size() == 2);
    }

}
