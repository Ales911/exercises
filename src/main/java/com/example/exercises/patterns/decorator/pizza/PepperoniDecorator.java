package com.example.exercises.patterns.decorator.pizza;

public class PepperoniDecorator extends PizzaDecorator {

    public PepperoniDecorator(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String bakePizza() {
        return super.bakePizza() + " with Pepperoni Toppings";
    }

    @Override
    public float getCost() {
        return super.getCost() + 110;
    }

}
