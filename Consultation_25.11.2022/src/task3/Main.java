package task3;

import javax.swing.text.DefaultStyledDocument;

public class Main {

    private volatile boolean flag = true;
    private int count = 30;

    public static void main(String[] args) throws InterruptedException {
//        // Напишите код, в котором создаются и запускаются на выполнение
//        // потоки S и W. Поток S выполняет переключение с задержкой 1000
//        // миллисекунд из состояния true в состояние false и наоборот.
//        // Поток W ожидает состояния true потока S, выводит на консоль
//        // обратный отсчет от 30 с задержкой 100 миллисекунд и
//        // приостанавливает свое действие, как только поток S переключен
//        // в состояние false. Условием завершения работы потоков является
//        // достижение отсчета нулевой отметки.
        Main m = new Main();
        Thread s = new Thread(m::changeFlag);
        Thread w = new Thread(m::print);
        s.start();
        w.start();
        s.join();
        w.join();
        System.out.println("The end");
    }

    private void changeFlag() {
        while (count > 0) {
            flag = !flag;
            System.out.println(flag);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void print() {
        for (int i = 30; i >= 0; i--) {
            while (!flag) {

            }
            System.out.println(i);
            count = i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
