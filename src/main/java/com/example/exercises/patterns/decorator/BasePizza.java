package com.example.exercises.patterns.decorator;

public class BasePizza implements Pizza {

    @Override
    public String bakePizza() {
        return "Basic Pizza";
    }

    @Override
    public float getCost() {
        return 100;
    }
}
