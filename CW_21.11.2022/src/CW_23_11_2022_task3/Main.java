package CW_23_11_2022_task3;

public class Main {

    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Main m = new Main();
        Thread thread1 = new Thread(m::method1);
        Thread thread2 = new Thread(m::method2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("End");
    }

    private void method1() {
        System.out.println("method1 begin");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (lock) {
            System.out.println("method1 block begin");
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("method1 block end");
        }
        System.out.println("method1 end");
    }

    private void method2() {
        System.out.println("method2 begin");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (lock) {
            System.out.println("method2 block begin");
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("method2 block end");
        }
        System.out.println("method2 end");
    }
}
