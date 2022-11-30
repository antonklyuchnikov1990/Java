package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Count count = new Count();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count.add();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count.sub();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count.getCount());
    }


}


class Count {

    private AtomicInteger ai = new AtomicInteger();
//    private volatile int count = 0;

    public void add() {
        ai.incrementAndGet();
    }

    public void sub() {
        ai.decrementAndGet();
    }

    public int getCount() {
        return ai.get();
    }

}
