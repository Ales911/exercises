package com.example;

import java.util.Scanner;

public class SeventhTask {

    public static void main(String[] args) {

        // ITVDN.com ТОП 20 тестовых заданий на интервью для Java разработчика
        int tempNumber, number;
        boolean numberIsPrime = true;
        Scanner scannerQ = new Scanner(System.in);
        number = scannerQ.nextInt();
        scannerQ.close();
        for (int x = 2; x <= number / 2; x++) {
            tempNumber = number % x;
            if (tempNumber == 0) {
                numberIsPrime = false;
                break;
            }
        }
        if (numberIsPrime) {
            System.out.println(number + " prime number");
        } else {
            System.out.println(number + " doesn't prime number");
        }

    }

}