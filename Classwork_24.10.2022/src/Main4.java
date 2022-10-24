import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Main4 {

    public static void main(String[] args) {
        int a = 1, b = 2;
        System.out.println("a = " + a + ", b = " + b);
        System.out.printf("a = %d, b = %d\n", a, b);
        double pi = Math.PI;
        System.out.printf("pi = %.3f\n", pi);
//        PrintStream
//        PrintWriter
        String text = "Hello, Java!";
        try (FileOutputStream fos = new FileOutputStream("D:\\IT\\Test.txt")) {
            PrintStream ps = new PrintStream(fos);
            ps.print(text);
            ps.printf("\npi = %.3f", pi);
            System.out.print(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
