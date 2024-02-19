package by.lyofa.streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateInList {

    public record Worker(String name, int age, int salary, String position) {

    }

    public static void main(String[] args) {
        final List<String> strings = List.of("apple", "banana", "apple", "orange", "banana", "grape", "orange");

        final List<String> stringsWithoutBanana = new ArrayList<>(strings);
        final Iterator<String> itr = stringsWithoutBanana.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals("banana")) {
                itr.remove();
            }
        }
        System.out.println("stringsWithoutBanana: " + stringsWithoutBanana);

        List<String> duplicates = strings.stream()
                .collect(Collectors.groupingBy(s -> s))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry -> entry.getKey())
                .toList();
        System.out.println("Duplicates: " + duplicates);

        final Map<String, List<String>> r1 = strings.stream()
                .collect(Collectors.groupingBy(s -> s));
        System.out.println("r1: " + r1);

        List<Entry<String, List<String>>> r2 = r1.entrySet().stream().filter(entry -> entry.getValue().size() > 1).toList();
        System.out.println("r2: " + r2);

        List<String> r3 = r2.stream().map(Entry::getKey).toList();
        System.out.println("r3: " + r3);

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
