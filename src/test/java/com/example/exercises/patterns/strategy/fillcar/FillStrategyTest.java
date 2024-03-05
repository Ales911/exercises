package com.example.exercises.patterns.strategy.fillcar;

import org.junit.jupiter.api.Test;

public class FillStrategyTest {

    @Test
    public void simpleTest() {
        Auto sedan = new Sedan();
        Auto hybrid = new HybridAuto();
        Auto f1car = new F1Car();

        sedan.fill();
        hybrid.fill();
        f1car.fill();
    }

}
