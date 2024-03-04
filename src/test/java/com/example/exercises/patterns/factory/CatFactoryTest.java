package com.example.exercises.patterns.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatFactoryTest {

    private CatFactory catFactory = new CatFactory();

    @Test
    public void tigerTest() {
        CatFactory.Cat tiger = catFactory.createCat(CatFactory.CatType.TIGER);
        String actual = tiger.maay();
        System.out.println(actual);
        Assertions.assertEquals("TIGER says maay.", actual);
    }

}
