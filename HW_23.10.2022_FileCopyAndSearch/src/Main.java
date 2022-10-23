import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//First level: 1. Напишите метод fileCopy, который принимает на вход два имени файлов: file1 и file2.
// Метод должен сделать копию содержимого файла file1 в файл file2.
// Примечание: file1 обязательно существует на диске.


        try (FileReader fr = new FileReader("D:\\IT\\GitHub\\Java\\HW_23.10.2022_FileCopyAndSearch\\1.txt");
             FileWriter fw = new FileWriter("D:\\IT\\GitHub\\Java\\HW_23.10.2022_FileCopyAndSearch\\new1.txt")) {
            int character;
            while ((character = fr.read()) != -1) {
                fw.write((char) character);
            }
            System.out.println("DONE");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream("D:\\IT\\GitHub\\Java\\HW_23.10.2022_FileCopyAndSearch\\1.jpg");
             FileOutputStream fos = new FileOutputStream("D:\\IT\\GitHub\\Java\\HW_23.10.2022_FileCopyAndSearch\\new1.jpg")) {
            int bytes;
            while ((bytes = fis.read()) != -1) {
                fos.write(bytes);
            }
            System.out.println("DONE");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //2*. Написать метод который циклически просматривает содержимое заданного каталога и выводит на печать
// информацию о всех файлах и каталогах, находящихся в нем и в его подкаталогах.
        ArrayList<File> list = new ArrayList<>();
        getFilesPath(new File("D:\\IT"), list);
    }

    private static void getFilesPath(File file, ArrayList<File> list) {
        if (file.isDirectory()) {
            System.out.println(file.getPath());
            File[] filesInDirectory = file.listFiles();
            if (filesInDirectory != null) {
                for (File f : filesInDirectory) {
                    if (f.isDirectory()) {
                        getFilesPath(f, list);
                    } else {
                        System.out.println(f.getPath());
                    }
                }
            }
        }
    }
}