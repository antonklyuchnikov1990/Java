package Threads_Execute;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3); //nThreads 3
        Future<Integer> f1 = es.submit(new Sum(10)); //stop 10
        // слева - результат работы программы; ExecutorService.submit - метод в ExecutorService

        Future<Double> f2 = es.submit(new Hypot(2,3));
        try {
            System.out.println(f1.get(3, TimeUnit.SECONDS)); //55
            System.out.println(f2.get()); //3.605551275463989
        } catch (Exception e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println("End"); // End

    }
}

class Sum implements Callable<Integer> {

    private int stop;

    public Sum(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}

class Hypot implements Callable<Double> {
    private double side1, side2;

    public Hypot(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt(side1 * side1 + side2 * side2);
    }
}
