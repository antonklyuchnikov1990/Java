package ExecutorService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        CountDownLatch cdl5 = new CountDownLatch(5);
        System.out.println("Run all threads");
        es.execute(new MyThread("A", cdl1));
        es.execute(new MyThread("B", cdl2));
        es.execute(new MyThread("C", cdl3));
        es.execute(new MyThread("D", cdl4));
        es.execute(new MyThread("E", cdl5));

        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
            cdl5.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        es.shutdown();
        System.out.println("Finish all threads");

    }
}

class MyThread implements Runnable {

    private final String name;
    private final CountDownLatch latch;

    public MyThread(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
