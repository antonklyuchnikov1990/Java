public class Main {

    public static final int CONS = 100;

    public static void main(String[] args) {
//        First level: Написать класс Counter, в котором есть одно целочисленное поле count
//        (инициализировано нулем). В классе реализовать два метода add и sub.
//        Первый метод увеличивает значение count на 1, второй - уменьшает на 1.
//        Запустить два потока: в первом в цикле (можно 100 раз) вызвать метод add,
//        во втором потоке столько же раз вызвать метод sub. В цикле, после каждой итерации,
//        лучше поставить Thread.sleap, чтобы лучше смоделировать ситуацию. Добиться синхронизацией потоков,
//        чтобы значение count после всех операций было равно 0. Пример, одного потока:
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                count.add();
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
        Counter counter = new Counter();

        new Thread(() -> {
            for (int i = 0; i < CONS; i++) {
                counter.add();
                System.out.print(counter.count + "; ");
                try {
                    Thread.sleep(CONS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < CONS; i++) {
                counter.sub();
                System.out.print(counter.count + "; ");
                try {
                    Thread.sleep(CONS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

class Counter {
    int count = 0;
    public synchronized void add() {
        count++;
    }
    public synchronized void sub() {
        count--;
    }
}
