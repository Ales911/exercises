package com.example.exercises.threads.synchronizers;

import java.util.concurrent.Exchanger;

public class ExampleExchanger {

    public static void main(String[] args) throws InterruptedException {

        Exchanger<String> exchanger = new Exchanger<>();

        String[] p1 = new String[]{"{parsel A->D}", "{parsel A->C}"};//Формируем груз для 1-го грузовика
        String[] p2 = new String[]{"{parsel B->C}", "{parsel B->D}"};//Формируем груз для 2-го грузовика
        new Thread(new Truck(exchanger, "truck1", "A", "D", p1)).start();//Отправляем 1-й грузовик из А в D
        Thread.sleep(100);
        new Thread(new Truck(exchanger, "truck2", "B", "C", p2)).start();//Отправляем 2-й грузовик из В в С
    }
}
