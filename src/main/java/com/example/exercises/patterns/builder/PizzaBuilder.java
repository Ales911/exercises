package com.example.exercises.patterns.builder;

public class PizzaBuilder {

    Pizza pizza = new Pizza();

    public PizzaBuilder withTopping(Topping topping) {
        pizza.setTopping(topping);
        pizza.addToPrice(topping.getCost());
        return this;
    }

    public PizzaBuilder withSize(Size size) {
        pizza.setSize(size);
        pizza.addToPrice(size.getCost());
        return this;
    }

    public PizzaBuilder withCrust(Crust crust) {
        pizza.setCrust(crust);
        pizza.addToPrice(crust.getCost());
        return this;
    }

    public Pizza build() {
        return pizza;
    }

    public double calculatePrice() {
        return pizza.getTotalPrice();
    }
    
}