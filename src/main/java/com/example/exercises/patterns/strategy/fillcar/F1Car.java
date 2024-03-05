package com.example.exercises.patterns.strategy.fillcar;

public class F1Car extends Auto {

    public F1Car() {
        super(new F1PitstopStrategy());
    }
}
