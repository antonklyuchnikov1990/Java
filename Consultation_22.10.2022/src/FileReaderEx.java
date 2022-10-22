import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("D:\\IT\\GitHub\\Java\\article.txt")) {
            int characters;
            while ((characters = reader.read()) != -1) {
                System.out.print((char) characters);
            }
            System.out.println();
            System.out.println("DONE");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
