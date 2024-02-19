package by.lyofa.threads;

public class ExampleThread {

    public static void main(String[] args) throws Exception {
        Runnable task = () -> {
            System.out.println("Task executed");
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
