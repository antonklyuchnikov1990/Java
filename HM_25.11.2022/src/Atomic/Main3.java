package Atomic;

import java.util.concurrent.CountDownLatch;

public class Main3 {

    public static void main(String[] args) {
        int threadCount = 6;
        CountDownLatch cdl = new CountDownLatch(threadCount);
        System.out.println("Begin");
        for (int i = 0; i < threadCount; i++) {
            final int j = i;
            new Thread(() -> {
                try {
                    Thread.sleep(500 + (int)(500 * Math.random()));
                    cdl.countDown();
                    System.out.println("Thread #" + j + " - ready");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
