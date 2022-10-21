import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
//        First level: 1. Напишите метод fileCopy, который принимает на вход два имени файлов: file1 и file2.
//        Метод должен сделать копию содержимого файла file1 в файл file2.
//        Примечание: file1 обязательно существует на диске.
        File file1 = new File("D://IT//Test.txt");
        String str = "Sample test text";
        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(str.getBytes(StandardCharsets.UTF_8));
        fos.close();
        fileCopy(file1);
        directoryPass(new File("D://"));
    }

    private static void directoryPass(File dir) {
        Stack<File> stack = new Stack<>();
        stack.push(dir);
        while (!stack.empty()) {
            File currentDir = stack.pop();
            System.out.println(currentDir.getPath());
            File[] files = currentDir.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    System.out.println(files[i].getPath());
                }
                if (files[i].isDirectory()) {
                    stack.push(files[i]);
                }
            }
        }
    }

    private static void fileCopy(File file1) throws IOException {
        File file2 = new File("D://IT//Test2.txt");
        FileOutputStream fos = new FileOutputStream(file2);
        FileInputStream fis = new FileInputStream(file1);
        while (fis.available() > 0) {
            fos.write(fis.read());
        }
        fis.close();
        fos.close();
    }
}
