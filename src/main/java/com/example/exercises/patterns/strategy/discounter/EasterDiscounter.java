package com.example.exercises.patterns.strategy.discounter;

import java.math.BigDecimal;

public class EasterDiscounter implements Discounter {

    @Override
    public BigDecimal apply(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}
