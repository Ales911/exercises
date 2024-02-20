package com.example.java1000._001_Not_deaf_phone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class NotDeafPhone {

    public static void main(String[] args) throws IOException {
        String str;
        try (FileReader fin = new FileReader("input.txt")) { // Получение числа из файла
            Scanner sc = new Scanner(fin);
            str = sc.nextLine();
            try (FileWriter countStepFinish = new FileWriter("output.txt")) { // Запись числа в файл
                countStepFinish.write(str);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (NoSuchElementException ex) {
            System.out.println("empty file");
        }
    }
}
