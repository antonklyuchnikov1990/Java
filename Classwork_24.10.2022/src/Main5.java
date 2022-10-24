import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main5 {

    public static void main(String[] args) {
//        PrintWriter

        try (PrintWriter pw = new PrintWriter("D:\\IT\\Test.txt")) {
            pw.println("Example");
            pw.println("Example");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
