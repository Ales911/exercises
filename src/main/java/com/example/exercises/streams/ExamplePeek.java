package com.example.exercises.streams;

import java.util.stream.Stream;

public class ExamplePeek {

    class User {

        private String name;

        User(String name) {
            this.name = name;
        }

        void setName(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    class Test {
        void doSomething() {
            Stream<User> userStream = Stream.of(new User("Alice"), new User("Bob"), new User("Chuck"));
            userStream.peek(u -> u.setName(u.getName().toLowerCase()))
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        new ExamplePeek().new Test().doSomething();
    }

}
