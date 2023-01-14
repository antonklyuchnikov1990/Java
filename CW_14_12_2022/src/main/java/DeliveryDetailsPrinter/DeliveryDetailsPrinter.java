package DeliveryDetailsPrinter;

public class DeliveryDetailsPrinter {

    private final Sorter sorter;

    public DeliveryDetailsPrinter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void printDetails() {
        sorter.sortDetails();
        System.out.println("Begin printing");
        System.out.println("End printing");
    }

}
