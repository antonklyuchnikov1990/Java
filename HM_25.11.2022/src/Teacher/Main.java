package Teacher;

public class Main {

    private char currentLetter = 'C';

    public static void main(String[] args) {
        Main m = new Main();
        Thread thread1 = new Thread(m::printA);
        Thread thread2 = new Thread(m::printB);
        Thread thread3 = new Thread(m::printC);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'C') {
                    wait();
                }
                System.out.print('A');
                currentLetter = 'A';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'A') {
                    wait();
                }
                System.out.print('B');
                currentLetter = 'B';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'B') {
                    wait();
                }
                System.out.print('C');
                currentLetter = 'C';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
