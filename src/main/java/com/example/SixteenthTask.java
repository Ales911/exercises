package com.example;

public class SixteenthTask {

    public static void main(String[] args) {

        // ITVDN.com 16 из ТОП 20 тестовых заданий на интервью для Java разработчика
        int numbersArray[] = {10, 15, 32, 100, 16, 11, 98, 36, 95, 33};
        int biggest = numbersArray[0];
        int secondBiggest = numbersArray[0];
        System.out.println("Полученный массив: ");
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.print(numbersArray[i] + "\t");
        }

        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] > biggest) {
                secondBiggest = biggest;
                biggest = numbersArray[i];
            } else if (numbersArray[i] > secondBiggest && numbersArray[i] != biggest) {
                secondBiggest = numbersArray[i];
            }
        }

        System.out.println("\nВторое по величине число:" + secondBiggest);

    }

}
