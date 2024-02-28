package com.example.exercises.streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByExampleEmployee {

    public static void main(String[] args) {

        record Employee(int id, String name, int salary, String deptt, String city) {

        }

        final List<Employee> employees = List.of(
                new Employee(1, "John Smith", 5000, "Marketing", "New York"),
                new Employee(2, "Jane Doe", 6000, "Engineering", "Chicago"),
                new Employee(3, "Bob Johnson", 4500, "Engineering", "Pune"),
                new Employee(4, "Sarah Lee", 5500, "HR", "Pune"),
                new Employee(5, "Alice", 7000, "HR", "San Francisco"),
                new Employee(6, "Emily", 6500, "Sales", "San Francisco"));

        String location = "San Francisco";
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.city().equals(location))
                .sorted(Comparator.comparing(Employee::name).thenComparing(Employee::salary, Comparator.reverseOrder()))
                .toList();
        System.out.println("Filtered employees: " + filteredEmployees);

        Map<String, Integer> nameFrequencyMap = new HashMap<>();
        for (Employee employee : employees) {
            String name = employee.name();
            nameFrequencyMap.put(name, nameFrequencyMap.getOrDefault(name, 0) + 1);
        }
        System.out.println("Name frequency: " + nameFrequencyMap);

        Stream<Employee> employeeStream = employees.stream();
        // Group the employees by department.
        Map<String, Long> employeeCountByDepartment = employeeStream
                .collect(Collectors.groupingBy(Employee::deptt, Collectors.counting()));
        // Print the results.
        System.out.println(employeeCountByDepartment);

        Optional<Employee> highestPaidHrEmployee = employees.stream()
                .filter(e -> "HR".equals(e.deptt()))
                .max(Comparator.comparing(Employee::salary));
        if (highestPaidHrEmployee.isPresent()) {
            System.out.println("The highest paid HR employee is: " + highestPaidHrEmployee.get().name());
        } else {
            System.out.println("No HR employees found in the list.");
        }

        // Filtering and sorting employees who live in Pune
        List<Employee> puneEmployees = employees.stream()
                .filter(e -> e.city().equals("Pune"))
                .sorted(Comparator.comparing(Employee::name))
                .toList();
        // Printing the names of employees who live in Pune
        System.out.println("Employees who live in Pune:");
        puneEmployees.stream()
                .map(Employee::name)
                .forEach(System.out::println);
    }

}
