package com.example.exercises.patterns.decorator.pizza;

public class PizzaDecorator implements Pizza {

    Pizza pizza;

    public PizzaDecorator(Pizza newPizza) {
        this.pizza = newPizza;
    }

    @Override
    public String bakePizza() {
        return pizza.bakePizza();
    }

    @Override
    public float getCost() {
        return pizza.getCost();
    }
}
