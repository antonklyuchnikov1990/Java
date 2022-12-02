package task1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {

    private static int CARS_COUNT = 0;

    private  Race race;
    private int speed;
    private String name;

    private CyclicBarrier startBarrier;

    private CountDownLatch cdl;

    private static AtomicInteger ai = new AtomicInteger(0);

    public Car(Race race, int speed, CyclicBarrier startBarrier, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        this.startBarrier = startBarrier;
        this.cdl = cdl;
        CARS_COUNT++;
        this.name = "Car N " + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " is preparing");
            Thread.sleep((int) (Math.random() * 800 + 500));
            System.out.println(this.name + " is prepared");
            startBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdl.countDown();
        if (ai.incrementAndGet() == 1) {
            System.out.println(this.name + " is WIN!!!");
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
