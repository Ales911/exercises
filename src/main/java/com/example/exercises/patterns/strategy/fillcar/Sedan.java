package com.example.exercises.patterns.strategy.fillcar;

public class Sedan extends Auto {

    public Sedan() {
        super(new StandartFillStrategy());
    }
}
