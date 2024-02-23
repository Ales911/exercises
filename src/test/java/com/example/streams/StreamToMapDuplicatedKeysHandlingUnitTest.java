package com.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

record City(String name, String locatedIn) {}

public class StreamToMapDuplicatedKeysHandlingUnitTest {

    // @formatter:off
    private final List<City> CITY_INPUT = List.of(
            new City("New York City", "USA"),
            new City("Shanghai", "China"),
            new City("Hamburg", "Germany"),
            new City("Paris", "France"),
            new City("Paris", "Texas, USA"));
    // @formatter:on

    @Test
    public void givenCityList_whenUsingGroupingBy_shouldContainExpectedCity() {
        Map<String, List<City>> resultMap = CITY_INPUT.stream()
                .collect(Collectors.groupingBy(City::name));
        Assertions.assertEquals(4, resultMap.size());

        System.out.println(resultMap);

        // @formatter:off
        Assertions.assertEquals(List.of(
                new City("Paris", "France"),
                new City("Paris", "Texas, USA")), resultMap.get("Paris"));
        // @formatter:on

    }

    @Test
    public void givenCityList_whenContainingDuplicatedNamesUsingToMap_shouldContainExpectedCity() {
        Map<String, City> resultMap1 = CITY_INPUT.stream()
                .collect(Collectors.toMap(City::name, Function.identity(), (first, second) -> first));
        Assertions.assertEquals(4, resultMap1.size());
        Assertions.assertEquals(new City("Paris", "France"), resultMap1.get("Paris"));

        System.out.println(resultMap1);

        Map<String, City> resultMap2 = CITY_INPUT.stream()
                .collect(Collectors.toMap(City::name, Function.identity(), (first, second) -> second));
        Assertions.assertEquals(4, resultMap2.size());
        Assertions.assertEquals(new City("Paris", "Texas, USA"), resultMap2.get("Paris"));

        System.out.println(resultMap2);

        Map<String, City> resultMap3 = CITY_INPUT.stream()
                .collect(Collectors.toMap(City::name, Function.identity(), (first, second) -> {
                    String locations = first.locatedIn() + " and " + second.locatedIn();
                    return new City(first.name(), locations);
                }));
        Assertions.assertEquals(4, resultMap3.size());
        Assertions.assertEquals(new City("Paris", "France and Texas, USA"), resultMap3.get("Paris"));

        System.out.println(resultMap3);

    }

}
