package HW;

//        First level: Написать программу, моделирующую работу библиотеки.
//        В библиотеке доступны к чтению несколько книг.
//        Некоторые из них можна выдавать на руки некоторые только в читальный зал.
//        Посетители могут брать одновременно по несколько книг на руки и в читальный зал.
//        Использовать можно все знания из Java, включая многопоточность.

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

    private static final int MAX_TIME_READ = 3000;
    private static final int MAX_BOOKS = 10;
    private static final int MAX_READERS = 3;

    public static void main(String[] args) {

        ArrayList<Integer> libraryCollection = new ArrayList<>(MAX_BOOKS);
        for (int i = 0; i < MAX_BOOKS; i++) {
            libraryCollection.add(i);
        }

        Semaphore semaphore = new Semaphore(MAX_READERS);

        while (!libraryCollection.isEmpty()) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Reader wait for accepting...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Reader # " + new Random().nextInt(MAX_READERS) +
                        " take a book # " +
                        libraryCollection.remove(new Random().nextInt(libraryCollection.size())));
            }).start();
            try {
                Thread.sleep(1000, new Random().nextInt(MAX_TIME_READ));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Reader go to reading room");
            semaphore.release();
        }
    }
}
