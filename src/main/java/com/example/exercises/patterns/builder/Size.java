package com.example.exercises.patterns.builder;

public enum Size {
    MEDIUM {
        @Override
        public float getCost() {
            return 100;
        }
    }, LARGE {
        @Override
        public float getCost() {
            return 160;
        }
    };

    public abstract float getCost();
}
