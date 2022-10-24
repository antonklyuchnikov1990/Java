import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class Main2 {

    public static void main(String[] args) {
//        ByteArrayInputStream
//        ByteArrayOutputStream
        byte[] array = {1, 3, 5, 7};
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        int b;

        while ((b = bais.read()) != -1) {
            System.out.println(b);
        }

        String text = "Hello, Java!";
        byte[] array2 = text.getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
           baos.write(array2);
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println(baos);
    }
}
