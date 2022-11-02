import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\IT\\GitHub\\Java\\Classwork_31.10.2022\\file.txt"))) {
            ArrayList<String> words = new ArrayList<>();
            String str;
            while ((str = br.readLine()) != null) {
                int count = 0;
                String word = "";
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (c == ' ') {
                        try {
                            words.set(count, words.get(count) + " " + word);
                        } catch (IndexOutOfBoundsException e) {
                            words.add(count, word);
                        }
                        count++;
                        word = "";
                    } else {
                        word = word + c;
                    }
                }
                try {
                    words.set(count, words.get(count) + " " + word);
                } catch (IndexOutOfBoundsException e) {
                    words.add(count, word);
                }
            }
            System.out.println(words);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IT\\GitHub\\Java\\Classwork_31.10.2022\\file2.txt"))) {
                for (int i = 0; i < words.size(); i++) {
                    bw.write(words.get(i));
                    bw.write("\n");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
