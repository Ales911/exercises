package com.example.exercises.patterns.strategy.fillcar;

public class HybridAuto extends Auto {

    public HybridAuto() {
        super(new HybridFillStrategy());
    }
}
