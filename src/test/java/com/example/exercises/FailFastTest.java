package com.example.exercises;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FailFastTest {

    List<String> given = new ArrayList<>(List.of("1", "2", "3", "4", "5"));

    @Test
    public void FailFast4Test() {
        System.out.println("source: " + given);
        Iterator<String> it = given.iterator();
        while (it.hasNext()) {
            String value = it.next();
            if (value.equals("4")) {
                given.remove(value);
            }
        }
        Assertions.assertEquals(4, given.size());
        System.out.println("result: " + given);
    }

    @Test
    public void FailFast3Test() {
        System.out.println("source: " + given);
        ConcurrentModificationException ex = Assertions.assertThrows(ConcurrentModificationException.class, () -> {
            Iterator<String> it = given.iterator();
            while (it.hasNext()) {
                String value = it.next();
                if (value.equals("3")) {
                    given.remove(value);
                }
            }
        });
        
        Assertions.assertTrue(Objects.isNull(ex.getMessage()));
        Assertions.assertEquals(4, given.size());
        System.out.println("result: " + given);
    }

}