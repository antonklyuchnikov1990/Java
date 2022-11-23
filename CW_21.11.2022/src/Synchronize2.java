public class Synchronize2 {

    public static void main(String[] args) {
    Queue q = new Queue();
    new Producer(q);
    new Consumer(q);
    }
}

class Queue {
    private int n;

    int get() {
        System.out.println("Get: " + n);
        return n;
    }

    public void put(int n) {
        this.n = n;
        System.out.println("Put: " + n);
    }
}

class Producer implements Runnable {

    private Queue q;

    public Producer(Queue q) {
        this.q = q;
        new Thread(this, "Supplier").start();
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