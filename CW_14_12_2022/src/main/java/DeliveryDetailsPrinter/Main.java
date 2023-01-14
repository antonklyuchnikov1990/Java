package DeliveryDetailsPrinter;

//Пусть необходимо создать объект DeliveryDetailsPrinter, который должен печатать сведения о посылках,
// которыми занимается приложение доставки. Эти сведения должны быть упорядочены по адресу назначения.
// Разработайте соответствующий (-ие) класс (-ы) (подсказка: объект, осуществляющий печать сведений,
// должен делегировать обязанность сортировки посылок по адреам доставки другому объекту)

public class Main {

    public static void main(String[] args) {
        DeliveryDetailsPrinter printer1 = new DeliveryDetailsPrinter(new SorterByAddress());
        printer1.printDetails();

        DeliveryDetailsPrinter printer2 = new DeliveryDetailsPrinter(new SorterByName());
        printer2.printDetails();
    }
}
