package com.example.exercises;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class RoundDance {

//Имеется список из 5 человек - "Глеб", "Сергей", "Женя", "Костя", "Наташа"
//Необходимо написать программу выводящую схему "хоровода" составленного из этих людей. Т.е. схему замкнутой цепи.
//При каждом последующем запуске программа должна выдавать другое, случайное построение цепи.
//Примеры вывода программы:
//Костя->Наташа->Женя->Глеб->Серегей->Костя
//2 запуск:
//Глеб->Костя->Наташа->Серегей->Женя->Глеб
//3 запуск:
//Серегей->Глеб->Костя->Наташа->Женя->Серегей
    List<Integer> getRandomIndexes() {
        List<Integer> result = null;
        do {
            result = new Random().ints(15, 0, 5).distinct().limit(5).boxed().toList();            
        } while (result.size() < 5);
        return result;
    }

    void run(List<String> list) {
        List<Integer> randomIndexes = getRandomIndexes();
        for (int index : randomIndexes) {
            System.out.print(list.get(index) + ", ");
        }
        System.out.println(list.get(randomIndexes.get(0)));
    }

    @Test
    void test() {
        List<String> list = List.of("Глеб", "Сергей", "Женя", "Костя", "Наташа");
        for (int i = 1; i <= 5; i++) {
            run(list);
        }
    }
    
    @Test
    void getRandomIndexesTest() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getRandomIndexes());
        }
    }

}
