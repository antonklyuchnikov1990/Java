import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Main3 {

    public static void main(String[] args) {
//        BufferedInputStream
//        BufferedOutputStream
        String str = "Hello, Java!";
        byte[] array = str.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        try (BufferedInputStream bis = new BufferedInputStream(bais)) {
            int c;
            while ((c = bis.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
