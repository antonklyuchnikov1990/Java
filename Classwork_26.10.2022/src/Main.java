import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Writer
        try (FileWriter writer = new FileWriter("D:\\IT\\GitHub\\Java\\article.txt")) {
            String text = "Hello, Java!";
            writer.write(text);
            // Запись по символам
            writer.append("!");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Reader
        try (FileReader reader = new FileReader("D:\\IT\\GitHub\\Java\\article.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение через буффер
        try (FileReader reader = new FileReader("D:\\IT\\GitHub\\Java\\article.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
