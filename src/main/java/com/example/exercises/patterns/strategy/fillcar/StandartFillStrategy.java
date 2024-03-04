package com.example.exercises.patterns.strategy.fillcar;

public class StandartFillStrategy implements FillStrategy {

    @Override
    public void fill() {
        System.out.println("Просто заправляем бензин!");
    }
}
