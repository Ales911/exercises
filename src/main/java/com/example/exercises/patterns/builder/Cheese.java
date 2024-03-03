package com.example.exercises.patterns.builder;

public enum Cheese {

    AMERICAN {
        @Override
        public float getCost() {
            return 40;
        }
    }, ITALIAN {
        @Override
        public float getCost() {
            return 60;
        }
    };

    public abstract float getCost();

}
