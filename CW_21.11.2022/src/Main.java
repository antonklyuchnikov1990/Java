import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        new FileWriteThread("Thread1", "D:\\IT\\GitHub\\Java\\CW_21.11.2022\\1.txt");
        new FileWriteThread("Thread2", "D:\\IT\\GitHub\\Java\\CW_21.11.2022\\1.txt");
        new FileWriteThread("Thread3", "D:\\IT\\GitHub\\Java\\CW_21.11.2022\\1.txt");
    }
}

class FileWriteThread extends Thread {

    private String fileName;
    private String threadName;

    public FileWriteThread(String threadName, String fileName) {
        this.fileName = fileName;
        this.setName(threadName);
        this.start();
    }


    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (int i = 0; i < 10; i++) {
                fileWriter.write(this.getName() + ": " + i + "\n");
                Thread.sleep(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
