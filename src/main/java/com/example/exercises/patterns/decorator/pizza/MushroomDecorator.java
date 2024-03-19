package com.example.exercises.patterns.decorator.pizza;

public class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String bakePizza() {
        return super.bakePizza() + " with Mushroom Topings";
    }

    @Override
    public float getCost() {
        return super.getCost() + 80;
    }

}
