import java.io.*;

public class Main {

    public static void main(String[] args) {
        // BufferWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IT\\GitHub\\Java\\article.txt"))) {
            String text = "Hello, Java!\nExample of text";
            bw.write(text);
            bw.write("\nAddition\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // BufferReader
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\IT\\GitHub\\Java\\article.txt"))) {
            int c;
            while ((c = br.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\IT\\GitHub\\Java\\article.txt"))) {
            while (br.ready()) {
                int c = br.read();
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\IT\\GitHub\\Java\\article.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
