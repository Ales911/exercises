package com.example.exercises.patterns.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaDecoratorTest {

    @Test
    public void shouldMakePepperoniPizza() {
        Pizza pizza = new PepperoniDecorator(new BasePizza());
        assertEquals("Basic Pizza with Pepperoni Toppings", pizza.bakePizza());
        assertEquals(210.0, pizza.getCost(), 0);
    }
}
