package com.example;

import java.util.Scanner;

public class NinthTask {

    public static void main(String[] args) {

        // ITVDN.com 9 из ТОП 20 тестовых заданий на интервью для Java разработчика
        int number, x = 0, y = 0, z = 1;
        Scanner scannerQ = new Scanner(System.in);
        System.out.println("Введите количество значений");
        number = scannerQ.nextInt();
        System.out.println("Fibonacci number series: ");
        for (int i = 0; i <= number; i++) {
            x = y;
            y = z;
            z = x + y;
            System.out.println(x + "");    // если вы хотите вывести в текущей строке - используйте print()
        }
    }
}
