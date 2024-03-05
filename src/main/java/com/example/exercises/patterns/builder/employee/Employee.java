package com.example.exercises.patterns.builder.employee;

public record Employee(String name, String company, boolean hasCar, boolean hasBike) {

    public static class EmployeeBuilder {

        String name;
        String company;
        boolean hasCar;
        boolean hasBike;

        public EmployeeBuilder(String name, String company) {
            this.name = name;
            this.company = company;
        }

        public EmployeeBuilder hasCar(boolean hasCar) {
            this.hasCar = hasCar;
            return this;
        }

        public EmployeeBuilder hasBike(boolean hasBike) {
            this.hasBike = hasBike;
            return this;
        }

        public Employee build() {
            return new Employee(name, company, hasCar, hasBike);
        }

    }

}
