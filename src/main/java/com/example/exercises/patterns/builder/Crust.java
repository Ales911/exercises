package com.example.exercises.patterns.builder;

public enum Crust {
    THIN {
        @Override
        public float getCost() {
            return 70;
        }
    }, STUFFED {
        @Override
        public float getCost() {
            return 90;
        }
    };

    public abstract float getCost();
}
