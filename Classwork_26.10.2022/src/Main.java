import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
//       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Input string");
//       String str = reader.readLine();

//        while (true) {
//            int x = System.in.read();
//            System.out.println(x);
//        }

//        char c = (char)System.in.read();
//        System.out.println(c);

        InputStreamReader isr = new InputStreamReader(System.in);
        int x = isr.read();
        System.out.println((char) x);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
    }
}