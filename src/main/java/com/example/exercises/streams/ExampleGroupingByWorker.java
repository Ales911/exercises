package com.example.exercises.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ExampleGroupingByWorker {

    public static void main(String[] args) {

        record Worker(String name, int age, int salary, String position) {

        }

        final List<Worker> workers = List.of(new Worker("name1", 20, 1000, "position1"), new Worker("name2", 21, 1000, "position1"), new Worker("name3", 22, 1000, "position2"));

        final Map<String, List<Worker>> map1 = workers.stream()
                .collect(Collectors.groupingBy(Worker::position));
        System.out.println("Группировка списка рабочих по их должности (деление на списки): " + map1);

        final Map<String, Set<Worker>> map2 = workers.stream()
                .collect(Collectors.groupingBy(Worker::position, Collectors.toSet()));
        System.out.println("Группировка списка рабочих по их должности (деление на множества): " + map2);

        final Map<String, Long> map3 = workers.stream()
                .collect(Collectors.groupingBy(Worker::position, Collectors.counting()));
        System.out.println("Подсчет количества рабочих, занимаемых конкретную должность: " + map3);

        final Map<String, Set<String>> map4 = workers.stream()
                .collect(Collectors.groupingBy(Worker::position,
                        Collectors.mapping(Worker::name, Collectors.toSet())));
        System.out.println("Группировка списка рабочих по их должности, при этом нас интересуют только имена: " + map4);

        final Map<String, Double> map5 = workers.stream()
                .collect(Collectors.groupingBy(Worker::position,
                        Collectors.averagingInt(Worker::salary)));
        System.out.println("Расчет средней зарплаты для данной должности: " + map5);

        final Map<String, String> map6 = workers.stream()
                .collect(Collectors.groupingBy(Worker::position,
                        Collectors.mapping(Worker::name,
                                Collectors.joining(", ", "{", "}")))
                );
        System.out.println("Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой: " + map6);

        final Map<String, Map<Integer, List<Worker>>> map7 = workers.stream()
                .collect(Collectors.groupingBy(Worker::position,
                        Collectors.groupingBy(Worker::age)));
        System.out.println("Группировка списка рабочих по их должности и по возрасту: " + map7);
    }

}
