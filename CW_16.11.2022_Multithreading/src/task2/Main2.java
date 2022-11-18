package task2;

public class Main2 {

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.run();
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello Java threads 2");
    }
}
