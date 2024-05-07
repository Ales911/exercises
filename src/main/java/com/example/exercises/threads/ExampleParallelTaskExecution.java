package com.example.exercises.threads;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;

class Task {

    int order;
    String description;

    Consumer<Task> taskProcessor;

    public Task(int order, String description, Consumer<Task> taskProcessor) {
        this.order = order;
        this.description = description;
        this.taskProcessor = taskProcessor;
    }
}

public class ExampleParallelTaskExecution {

    public static void main(String[] args) {
        // Sample list of tasks with order numbers
        List<Task> tasks = Arrays.asList(
                new Task(1, "Task 1", ExampleParallelTaskExecution::processTask1),
                new Task(2, "Task 2", ExampleParallelTaskExecution::processTask2),
                new Task(2, "Task 3", ExampleParallelTaskExecution::processTask3),
                new Task(2, "Task 4", ExampleParallelTaskExecution::processTask4),
                new Task(3, "Task 5", ExampleParallelTaskExecution::processTask5)
        );

        // Group tasks by order number
        Map<Integer, List<Task>> tasksByOrder = new HashMap<>();
        for (Task task : tasks) {
            tasksByOrder.computeIfAbsent(task.order, k -> new ArrayList<>()).add(task);
        }

        // Create an ExecutorService for parallel execution
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Process tasks
        for (List<Task> orderTasks : tasksByOrder.values()) {
            CompletableFuture<Void>[] futures = orderTasks.stream()
                    .map(task -> CompletableFuture.runAsync(() -> task.taskProcessor.accept(task), executorService))
                    .toArray(CompletableFuture[]::new);

            // Wait for all parallel tasks with the same order to complete
            CompletableFuture.allOf(futures).join();
        }
        System.out.println("done");
        // Shutdown the executor
        executorService.shutdown();
    }

    private static void processTask1(Task task) {
        System.out.println("Processing Task 1: " + task.description);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static void processTask2(Task task) {

        System.out.println("Processing Task 2: " + task.description);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static void processTask3(Task task) {

        System.out.println("Processing Task 3: " + task.description);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static void processTask4(Task task) {
        System.out.println("Processing Task 4: " + task.description);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static void processTask5(Task task) {
        System.out.println("Processing Task 5: " + task.description);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
