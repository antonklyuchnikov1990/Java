import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewTheme {

    public static void main(String[] args) {
//        FileInputStream fis = null;
//        try{
//            fis = new FileInputStream("D:\\IT\\Test.txt");
//            int i;
//            while ((i = fis.read()) != -1) {
//                System.out.println((char) i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fis != null) {
//                    fis.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        try (FileInputStream fis = new FileInputStream("D:\\IT\\Test.txt");
             FileOutputStream fos = new FileOutputStream("D:\\IT\\NewTest.txt")) {
            int i;
            while ((i = fis.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
