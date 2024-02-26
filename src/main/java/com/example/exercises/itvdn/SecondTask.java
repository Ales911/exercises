package com.example.exercises.itvdn;

public class SecondTask {

    public static void main(String[] args) {
        //ITVDN.com 2 из ТОП 20 тестовых заданий на интервью для Java разработчика
        String st = "Task2";
        char symbols[] = st.toCharArray();  // конвертируем строку в массив символов, затем выводим символы на экран в обратном порядке
        for (int x = symbols.length - 1; x >= 0; x--) {
            System.out.print(symbols[x]);
        }
    }
}
