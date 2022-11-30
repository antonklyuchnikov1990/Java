package Atomic;

import java.util.concurrent.CyclicBarrier;

public class Main4 {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            final int j = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread #" + j + " getting ready");
                    Thread.sleep(100 + (int)(3000 * Math.random()));
                    System.out.println("Thread #" + j + " is ready");
                    cb.await();
                    System.out.println("Thread #" + j + " run");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
