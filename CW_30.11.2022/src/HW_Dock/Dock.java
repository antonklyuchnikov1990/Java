package HW_Dock;

public class Dock extends Thread {

    private Port port;

    public Dock(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println("Dock started " + Thread.currentThread().getName());
        while (true) {
            try {
                port.removeCargoTime();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
