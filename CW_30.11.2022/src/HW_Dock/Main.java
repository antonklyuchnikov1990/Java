package HW_Dock;

public class Main {

    public static void main(String[] args) {
        Port port = new Port();
        port.startPort();
        Ship ship1 = new Ship(port, 25);
        Ship ship2 = new Ship(port, 0);

        Thread thread1 = new Thread(ship1);
        Thread thread2 = new Thread(ship2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
