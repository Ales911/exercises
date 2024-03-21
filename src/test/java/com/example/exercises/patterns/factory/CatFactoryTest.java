package com.example.exercises.patterns.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatFactoryTest {

    @Test
    public void tigerTest() {
        Cat tiger = CatFactory.createCat(CatType.TIGER);
        String actual = tiger.maay();
        System.out.println(actual);
        Assertions.assertEquals("TIGER says maay.", actual);
    }

}
