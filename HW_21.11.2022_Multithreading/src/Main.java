import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        First level: Написать метод, в котором 3 потока построчно пишут данные в файл
//        (штук по 10 записей, с периодом в 20 мс)
        String str = "Some information";
        printToFile("Thread#1 " + str);
        printToFile("Thread#2 " + str);
        printToFile("Thread#3 " + str);
    }
    private static void printToFile(String str) {
        new Thread(() -> {
            try (FileWriter fr = new FileWriter("D:\\IT\\GitHub\\Java\\HW_21.11.2022_Multithreading\\1.txt", true)) {
                for (int i = 1; i < 11; i++) {
                    fr.write(str + " " + i + "\n");
                    Thread.sleep(20);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
