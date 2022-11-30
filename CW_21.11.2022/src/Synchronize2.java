public class Synchronize2 {

    public static void main(String[] args) {
    Queue q = new Queue();
    new Producer(q);
    new Consumer(q);
    }
}

class Queue {
    private int n;

    private boolean valueSet = false;

    public synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get: " + n);
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer implements Runnable {

    private Queue q;

    public Producer(Queue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {

    private Queue q;

    public Consumer(Queue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}