package com.example.exercises.itvdn;

import java.util.Scanner;

public class EighthTask {

    public static void main(String[] args) {

        // ITVDN.com ТОП 20 тестовых заданий на интервью для Java разработчика
        String inputString, reversedString = "";

        Scanner scannerQ = new Scanner(System.in);

        int stringLength;

        System.out.println("Введите число или строку");

        inputString = scannerQ.nextLine();

        stringLength = inputString.length();

        for (int x = stringLength - 1; x >= 0; x--) {
            reversedString = reversedString + inputString.charAt(x);
        }
        
        

        System.out.println("reversedString: " + reversedString);
        
        System.out.println("reversedString: " + new StringBuilder(inputString).reverse());

        if (inputString.equals(reversedString)) {
            System.out.println("The entered value is a palindrome");
        } else {
            System.out.println("The entered value isn't a palindrome");
        }

    }
}
