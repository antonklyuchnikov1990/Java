package MySelf;

public class Main {

    public static void main(String[] args) {
//        First level: 1. Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз,
//        порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
//
//Написать класс МФУ на котором возможны одновременная печать и сканирование документов,
// при этом нельзя одновременно печатать два документа или сканировать (при печати в консоль
// выводится сообщения "отпечатано 1, 2, 3,… страницы", при сканировании то же самое только "отсканировано…",
// вывод в консоль с периодом в 50 мс.)
        Print print = new Print();
        Thread thread1 = new Thread(print::printA);
        Thread thread2 = new Thread(print::printB);
        Thread thread3 = new Thread(print::printC);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Print {
    public char currentChar = 'A';

    public synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                if (currentChar != 'B' && currentChar != 'C') {
                    wait();
                }
                System.out.println("A");
                currentChar = 'B';
                notifyAll();
                wait(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                if (currentChar != 'A' && currentChar != 'B') {
                    wait();
                }
                System.out.println("B");
                currentChar = 'C';
                notifyAll();
                wait(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                if (currentChar != 'A' && currentChar != 'B') {
                    wait();
                }
                System.out.println("C");
                currentChar = 'A';
                notifyAll();
                wait(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}