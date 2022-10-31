import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader("D:/IT/GitHub/Java/HW_29.10.2022_File_Transpose/file.txt");
             FileWriter fw = new FileWriter("D:/IT/GitHub/Java/HW_29.10.2022_File_Transpose/file_new.txt")) {
            int character;
            while ((character = fr.read()) != -1) {
                if ((char) character == ' ') {
                    al.add(String.valueOf(sb));
                    sb.delete(0, sb.length());
                } else if ((char) character == '\n') {
                    al.add(String.valueOf(sb));
                    sb.append((char) character);
                    sb.delete(0, sb.length());
                } else if ((char) character == '\r') {
                    continue;
                } else {
                    sb.append((char) character);
                }
            }
            al.add(String.valueOf(sb));
            System.out.println(al);
            for (int i = 0; i < al.size(); i += 2) {
                fw.write(al.get(i) + " ");
            }
            fw.write("\n");
            for (int i = 1; i < al.size(); i += 2) {
                fw.write(al.get(i) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
