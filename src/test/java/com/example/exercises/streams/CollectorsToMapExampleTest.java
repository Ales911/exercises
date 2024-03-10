package com.example.exercises.streams;

import com.example.exercises.streams.CollectorsToMapExample.Person;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CollectorsToMapExampleTest {

    private final List<CollectorsToMapExample.Book> bookList = List.of(
            new CollectorsToMapExample.Book("The Fellowship of the Ring", 1954, "0395489318"),
            new CollectorsToMapExample.Book("The Two Towers", 1954, "0345339711"),
            new CollectorsToMapExample.Book("The Return of the King", 1955, "0618129111"));

    private final List<CollectorsToMapExample.Person> persons = List.of(
            new CollectorsToMapExample.Person("Adam", 19),
            new CollectorsToMapExample.Person("Eva", 19));

    private final CollectorsToMapExample collectorsToMapExample = new CollectorsToMapExample();

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
        Map<Integer, CollectorsToMapExample.Book> booksByYear = collectorsToMapExample.listToMapWithDupKey(bookList);
        System.out.println(booksByYear);
        Assertions.assertEquals(2, booksByYear.size());
        Assertions.assertEquals("0395489318", booksByYear.get(1954).isbn());
    }

    @Test
    public void whenCreateConcurrentHashMap() {
        Map<Integer, CollectorsToMapExample.Book> result = collectorsToMapExample.listToConcurrentMap(bookList);
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
