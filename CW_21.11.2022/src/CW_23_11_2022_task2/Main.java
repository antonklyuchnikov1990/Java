package CW_23_11_2022_task2;

public class Main {

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

    private synchronized void method1() {
        System.out.println("Method1 begin");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Method1 end");
    }

    private synchronized void method2() {
        System.out.println("Method2 begin");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Method2 end");
    }
}
