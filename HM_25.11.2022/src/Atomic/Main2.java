package Atomic;

import java.util.concurrent.Semaphore;

public class Main2 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            final int j = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + j + " before semaphore");
                    semaphore.acquire();
                    System.out.println("Thread " + j + " got access");
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Thread " + j + " released the resource");
                    semaphore.release();
                }
            }).start();
        }
    }
}
