package HW_Dock;

public class Ship implements Runnable {

    public final int MAX_COUNT_CONTAINERS = 25;
    private Port port;
    private Cargo cargo;

    public Cargo getCargo() {
        return cargo;
    }

    public Ship(Port port, int countContainers) {
        this.port = port;
        cargo = new Cargo(countContainers);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            port.addCargoTime(this);
        }
    }
}
