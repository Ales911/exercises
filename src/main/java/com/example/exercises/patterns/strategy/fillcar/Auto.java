package com.example.exercises.patterns.strategy.fillcar;

public abstract class Auto {

   FillStrategy fillStrategy;
   
   public Auto(FillStrategy fillStrategy) {
       this.fillStrategy = fillStrategy;
   }   

   public void fill() {
       fillStrategy.fill();
   }

   public void gas() {
       System.out.println("Едем вперед");
   }

   public void stop() {
       System.out.println("Тормозим!");
   }

}