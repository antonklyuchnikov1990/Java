package HW_Dock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Port {

    public final int MAX_COUNT_CONTAINERS = 250;
    private int countContainers;
    private int countShips;
    private List<Dock> docks;

    private final List<Cargo> cargos;

    public Port() {
        docks = new ArrayList<>();
        docks.add(new Dock(this));
        docks.add(new Dock(this));
        docks.add(new Dock(this));
        docks.add(new Dock(this));

        countContainers = 0;
        countShips = 0;
        cargos = new LinkedList<>();
    }

    public void startPort() {
        docks.forEach(Thread::start);
    }

    public void loadingCargo(Ship ship) {

    }

    public void unloadingCargo(Ship ship) {

    }

    public void addCargoTime(Ship ship) {
        synchronized (cargos) {
            while (countShips + 1 > docks.size()) {
                try {
                    cargos.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cargos.add(ship.getCargo());
            countShips++;
            System.out.println("added ship");
            cargos.notify();
        }
    }

    public void removeCargoTime() throws InterruptedException {
        synchronized (cargos) {
            while (countShips == 0) {
                try {
                    cargos.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Cargo cargo = cargos.remove(0);
            if (cargo.getCountContainers() == 0) {
                System.out.println("Start loading empty ship" + Thread.currentThread().getName());
                cargo.setCountContainers(25);
                Thread.sleep(5000);
                System.out.println("Ship is loaded! " + Thread.currentThread().getName());
            }
            if (cargo.getCountContainers() == 25) {
                System.out.println("Start unloading ship " + Thread.currentThread().getName());
                cargo.setCountContainers(0);
                Thread.sleep(5000);
                System.out.println("Ship is unloaded! " + Thread.currentThread().getName());
            }
            countShips--;
            System.out.println("removed ships");
            cargos.notify();
        }
    }
}
