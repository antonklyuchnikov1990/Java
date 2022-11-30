package Teacher;

public class Main2 {

    public static void main(String[] args) {
        Mfu mfu = new Mfu();
        Thread thread1 = new Thread(() -> mfu.print(50));
        Thread thread2 = new Thread(() -> mfu.scan(50));
        Thread thread3 = new Thread(() -> mfu.print(20));
        Thread thread4 = new Thread(() -> mfu.scan(20));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Mfu {

    private final Object mon1 = new Object();
    private final Object mon2 = new Object();

    public void print(int pages) {
        synchronized (mon1) {
            System.out.println("Print begin");
            for (int i = 0; i < pages; i++) {
                System.out.println("Printing " + (i + 1) + " page");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Print end");
        }
    }

    public void scan(int pages) {
        synchronized (mon2) {
            System.out.println("Scan begin");
            for (int i = 0; i < pages; i++) {
                System.out.println("Scanning " + (i + 1) + " page");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Scan end");
        }
    }
}
