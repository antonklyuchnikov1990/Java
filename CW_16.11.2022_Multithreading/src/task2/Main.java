package task2;

public class Main {

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();

        Runnable task = () -> System.out.println("Hello, threads in Java");
        Thread thread = new Thread(task);
        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, threads in Java");
    }
}
