package CW_23_11_2022;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
        Thread thread1 = new Thread(print::printA);
        Thread thread2 = new Thread(print::printB);
        thread2.start();
        thread1.start();
        thread1.join();
        thread2.join();
    }
}

class Print {

    private char currentLetter = 'A';

    public synchronized void printA() {
        for (int i = 0; i < 3; i++) {
            while (currentLetter != 'A') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            currentLetter = 'B';
            notify();
        }
    }

    public synchronized void printB() {
        for (int i = 0; i < 3; i++) {
            while (currentLetter != 'B') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B");
            currentLetter = 'A';
            notify();
        }
    }
}