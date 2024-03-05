package com.example.exercises.patterns.strategy.fillcar;

public class HybridFillStrategy implements FillStrategy {

    @Override
    public void fill() {
        System.out.println("Заправляем бензином или электричеством на выбор!");
    }
}