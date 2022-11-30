package task3;

import javax.swing.text.DefaultStyledDocument;

public class Main {

    private boolean flag = true;

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

    private synchronized void changeFlag() {
        try {
            if (!flag) {
                Thread.sleep(1000);
                flag = true;
                notify();
            } else {
                Thread.sleep(1000);
                flag = false;
                notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private synchronized void print() {
        try {
            for (int i = 30; i >= 0; i--) {
                while (flag) {
                    wait();
                }
                System.out.println(i);
                Thread.sleep(100);
                notify();
                flag = !flag;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
