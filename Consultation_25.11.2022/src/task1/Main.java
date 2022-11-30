package task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = {-1, -2, -3, -4, -5, -6, -7, -8, -9};
        int[] array3 = {10, 20, 30};
        new SaveAsThread(array1, "D:\\IT\\GitHub\\Java\\Consultation_25.11.2022\\1.txt");
        new SaveAsThread(array2, "D:\\IT\\GitHub\\Java\\Consultation_25.11.2022\\2.txt");
        new SaveAsThread(array3, "D:\\IT\\GitHub\\Java\\Consultation_25.11.2022\\3.txt");
    }
}


class SaveAsThread implements Runnable {

    private final int[] array;
    private final String fileName;

    public SaveAsThread(int[] array, String fileName) {
        this.array = array;
        this.fileName = fileName;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try (PrintStream ps = new PrintStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < array.length; i++) {
                ps.println(array[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
