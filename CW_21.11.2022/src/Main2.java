import java.io.FileWriter;

public class Main2 {

    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("D:\\IT\\GitHub\\Java\\CW_21.11.2022\\3.txt", true);
        FileWriteThread2 thread1 = new FileWriteThread2("Thread1", fileWriter, 10);
        FileWriteThread2 thread2 = new FileWriteThread2("Thread2", fileWriter, 5);
        FileWriteThread2 thread3 = new FileWriteThread2("Thread3", fileWriter, 1);
        thread1.join();
        thread2.join();
        thread3.join();
        fileWriter.flush();
        fileWriter.close();
    }
}

class FileWriteThread2 extends Thread {

    private final FileWriter fileWriter;

    public FileWriteThread2(
            String threadName,
            FileWriter fileWriter,
            int priority) {
        this.fileWriter = fileWriter;
        this.setName(threadName);
        this.setPriority(priority);
        this.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                fileWriter.write(this.getName() + ": " + i + "\n");
                Thread.sleep(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
