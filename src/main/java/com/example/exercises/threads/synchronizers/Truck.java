package com.example.exercises.threads.synchronizers;

import java.util.concurrent.Exchanger;

public class Truck extends Thread {

    private final Exchanger<String> exchanger;
    private final String name;
    private String departure;
    private String destination;
    private String[] parcels;

    Truck(Exchanger<String> exchanger, String name, String departure, String destination, String[] parcels) {
        this.exchanger = exchanger;
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.parcels = parcels;
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s loaded: %s и %s.\n", name, parcels[0], parcels[1]);
            System.out.printf("%s departed from %s to %s.\n", name, departure, destination);
            Thread.sleep(1000 + (long) Math.random() * 5000);
            System.out.printf("%s arrived to E.\n", name);
            parcels[1] = exchanger.exchange(parcels[1]);//При вызове exchange() поток блокируется и ждет
            //пока другой поток вызовет exchange(), после этого произойдет обмен посылками
            System.out.printf("%s get a parcel for %s.\n", name, destination);
            Thread.sleep(1000 + (long) Math.random() * 5000);
            System.out.printf("%s arrived in %s and delivered: %s и %s.\n", name, destination, parcels[0], parcels[1]);
        } catch (InterruptedException e) {
        }
    }
}
