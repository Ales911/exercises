package com.example;


import java.util.Scanner;

public class ThirdTask {

    public static void main(String[] args) {

        // ITVDN.com 3 из ТОП 20 тестовых заданий на интервью для Java разработчика
        int a, b, temp;

        System.out.println("Введите значения a и b");

        Scanner scannerQ = new Scanner(System.in);

        a = scannerQ.nextInt();

        b = scannerQ.nextInt();

        System.out.println("До обмена значениями " + a + b);

        temp = a;

        a = b;

        b = temp;

        System.out.println("После обмена значениями " + a + b);

    }

}
