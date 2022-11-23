public class Synchronize {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("1234")).setPriority(Thread.MAX_PRIORITY);
        CallMe target = new CallMe();
        Caller caller1 = new Caller(target, "Welcome!", 10);
        Caller caller2 = new Caller(target, "to synchronized!", 5);
        Caller caller3 = new Caller(target, "method", 1);
        try {
            caller3.t.join();
            caller1.t.join();
            caller2.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class CallMe {
    public void call (String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {

    private final String msg;
    private final CallMe target;
    Thread t;

    public Caller(CallMe target, String msg, int priority) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.setPriority(priority);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
