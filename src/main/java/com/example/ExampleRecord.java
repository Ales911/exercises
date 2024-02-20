package com.example;

import java.util.Map;

public class ExampleRecord {

    public record EmpRecord(int id, String name, long salary, Map<String, String> addresses) {

    }

    public static void main(String[] args) {

        EmpRecord empRecord1 = new EmpRecord(10, "Pankaj", 10000, null);
        EmpRecord empRecord2 = new EmpRecord(10, "Pankaj", 10000, null);

        // toString()
        System.out.println(empRecord1);

        // accessing fields
        System.out.println("Name: " + empRecord1.name());
        System.out.println("ID: " + empRecord1.id());

        // equals()
        System.out.println(empRecord1.equals(empRecord2));

        // hashCode()
        System.out.println(empRecord1 == empRecord2);
    }

}
