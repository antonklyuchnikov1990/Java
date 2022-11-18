package task4;

public class Main {

    public static void main(String[] args) {
        serial();
        parallel();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        double[][] table = new double[10000][10000];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = Math.pow(i, j);
            }
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static void parallel() {
        long start = System.currentTimeMillis();
        double[][] table = new double[10000][10000];
        Runnable task1 = () -> {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length / 2; j++) {
                    table[i][j] = Math.pow(i, j);
                }
            }
        };

        Thread thread1 = new Thread(task1);
        thread1.start();

        Runnable task2 = () -> {
            for (int i = 0; i < table.length; i++) {
                for (int j = table[i].length / 2; j < table[i].length; j++) {
                    table[i][j] = Math.pow(i, j);
                }
            }
        };

        Thread thread2 = new Thread(task2);
        thread2.start();

//        while (thread1.isAlive() || thread2.isAlive()) {
//        }
        System.out.println("Thread1 is Alive" + thread1.isAlive());
        System.out.println("Thread2 is Alive" + thread2.isAlive());

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");
        System.out.println("Thread1 is Alive" + thread1.isAlive());
        System.out.println("Thread2 is Alive" + thread2.isAlive());
    }

    private static void printArray(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.println(table[i][j] + " ");
            }
        }
    }
}
