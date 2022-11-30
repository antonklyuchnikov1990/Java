package HW_CW_30_11_2022;

//First level: Написать программу, моделирующую работу порта. Корабли могут заходить в порт для
// разгрузки / загрузки контейнеров. Количество контейнеров, находящихся в текущий момент в порту
// и на корабле, не должно превышать заданную грузоподъемность судна и емкость порта.
// В порту работает несколько причалов. В одном причале может стоять только один корабль.
// Корабль может загружаться у причала, разгружаться или выполнять оба действия.
//Нужны любые Ваши идеи. Можете даже менять условие задачи (упростить, например),
// но модель многопоточной системы должна работать.


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        final int dailyShips = 10;
        final int docks = 2;
        final int maxValueOfContainers = 350;
        AtomicInteger currentValueOfContainers = new AtomicInteger(maxValueOfContainers);

        Semaphore port = new Semaphore(docks);
        Semaphore dockContainers = new Semaphore(maxValueOfContainers / docks);

        for (int i = 1; i < dailyShips; i++) {
            Ship ship = new Ship(100 + (int) (Math.random() * 100));
            final int l = i;
            new Thread(() -> {
                try {
                    System.out.println("Ship # " + l + " is waiting for permission");
                    port.acquire();
                    System.out.println("Ship # " + l + " is loading");
                    for (int j = 0; j < ship.loadCapacity; j++) {
                        ship.loading();
                        Thread.sleep(ship.loadCapacity / 10);
                        currentValueOfContainers.getAndIncrement();
                    }

                    System.out.println("Ship # " + l + " is waiting for unloading");
                    dockContainers.acquire();
                    System.out.println("Ship # " + l + " is unloading");

                    for (int k = 0; k < ship.loadCapacity; k++) {
                        ship.unloading();
                        Thread.sleep(ship.loadCapacity / 10);
                        currentValueOfContainers.decrementAndGet();
                    }
                    dockContainers.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Ship # " + l + " is came out of the Port");
                    port.release();
                }
            }).start();
        }
    }
}

class Ship {
    public int loadCapacity;
    AtomicInteger container = new AtomicInteger();
    public Ship(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    public void loading() {
        container.incrementAndGet();
    }
    public void unloading() {
        container.decrementAndGet();
    }
}
