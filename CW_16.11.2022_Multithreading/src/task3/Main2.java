package task3;

public class Main2 {

    public static void main(String[] args) {
        new MyThread("Thread1");
        new MyThread("Thread2");
        new MyThread("Thread3");
    }
}

class MyThread implements Runnable {
    String name;
    private Thread thread;

    public MyThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("New thread: " + thread);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(name + "interrupted");
            }
        }
        System.out.println(name + "finish");
    }
}
