package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author nikola
 */
public class StreamToMapDuplicatedKeysHandlingUnitTest2 {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // @formatter:off
    private final List<City> CITY_INPUT = Arrays.asList(
      new City("New York City", "USA"),
      new City("Shanghai", "China"),
      new City("Hamburg", "Germany"),
      new City("Paris", "France"),
      new City("Paris", "Texas, USA"));
    // @formatter:on

    @Test
    public void givenCityList_whenUsingGroupingBy_shouldContainExpectedCity() {
        Map<String, List<City>> resultMap = CITY_INPUT.stream()
          .collect(groupingBy(City::getName));
        assertEquals(4, resultMap.size());
        
        System.out.println(resultMap);
                
        // @formatter:off
        assertEquals(Arrays.asList(
          new City("Paris", "France"),
          new City("Paris", "Texas, USA")), resultMap.get("Paris"));
        // @formatter:on

    }

    @Test
    public void givenCityList_whenContainingDuplicatedNamesUsingToMap_shouldContainExpectedCity() {
        Map<String, City> resultMap1 = CITY_INPUT.stream()
          .collect(toMap(City::getName, Function.identity(), (first, second) -> first));
        assertEquals(4, resultMap1.size());
        assertEquals(new City("Paris", "France"), resultMap1.get("Paris"));
        
        System.out.println(resultMap1);

        Map<String, City> resultMap2 = CITY_INPUT.stream()
          .collect(toMap(City::getName, Function.identity(), (first, second) -> second));
        assertEquals(4, resultMap2.size());
        assertEquals(new City("Paris", "Texas, USA"), resultMap2.get("Paris"));
        
        System.out.println(resultMap2);

        Map<String, City> resultMap3 = CITY_INPUT.stream()
          .collect(toMap(City::getName, Function.identity(), (first, second) -> {
              String locations = first.getLocatedIn() + " and " + second.getLocatedIn();
              return new City(first.getName(), locations);
          }));
        assertEquals(4, resultMap3.size());
        assertEquals(new City("Paris", "France and Texas, USA"), resultMap3.get("Paris"));
        
        System.out.println(resultMap3);
        
    }

}
