package task2;

public class Main3 {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Hello, threads in Java");
//        task.run();

        new Thread(() -> System.out.println("Hello, threads in Java")).start();
    }
}
