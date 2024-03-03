package com.example.exercises.patterns.builder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PizzaBuilderTest {

    @Test
    public void shouldBuildThinCrustChickenPizza() {
        Pizza pizza = new PizzaBuilder().withCrust(Crust.THIN).withTopping(Topping.CHICKEN).withSize(Size.LARGE).build();
        Assertions.assertEquals(Topping.CHICKEN, pizza.getTopping());
        Assertions.assertEquals(Size.LARGE, pizza.getSize());
        Assertions.assertEquals(Crust.THIN, pizza.getCrust());
        Assertions.assertEquals(265.0, pizza.getTotalPrice(), 0);
    }

}
