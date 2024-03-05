package com.example.exercises.patterns.strategy.fillcar;

public class F1PitstopStrategy implements FillStrategy {

    @Override
    public void fill() {
         System.out.println("Заправляем бензин только после всех остальных процедур пит-стопа!");
   }
    
}
