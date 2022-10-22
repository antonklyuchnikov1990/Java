import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamAndOutputStream {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\BMW.jpg");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Desktop\\BMW_COPY.jpg")) {
            int i;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }
            System.out.println("DONE");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
