package com.example.threads;

import java.util.Random;
import java.util.stream.IntStream;

public class ExampleThreadLocal {

    public static void main(String[] args) {
        //Создаем ThreadLocal
        ThreadLocal<String> local = new ThreadLocal<>();
        //Создаем новый класс Random
        Random random = new Random();
        
        Runnable ra = (() -> {
            //Присваиваем значение каждому потоку
            local.set(/*a + */"  " + random.nextInt(100));
            System.out.println("Thread number and its local value  " + local.get());
        });
        
        IntStream.range(0, 5).forEach((a) -> new Thread(ra).start());
        
        
//                
//        //Создаем 5 потоков
//        IntStream.range(0, 5).forEach(a -> new Thread(() -> {
//            //Присваиваем значение каждому потоку
//            local.set(a + "  " + random.nextInt(100));
//            System.out.println("Thread number and its local value  " + local.get());
//        }).start());
    }

}
