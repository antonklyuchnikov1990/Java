import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input file path to find repeat bytes:");
        try (FileInputStream fis = new FileInputStream(sc.nextLine());
             ByteArrayInputStream bais = new ByteArrayInputStream(fis.readAllBytes())) {
            ArrayList<Integer> bytes = new ArrayList<>();
            Set<Integer> repeatedBytes = new HashSet<>();
            int b;
            while ((b = bais.read()) != -1) {
                bytes.add(b);
            }
            for (int i = 0; i < bytes.size(); i++) {
                for (int j = i + 1; j < bytes.size(); j++) {
                    if (Objects.equals(bytes.get(i), bytes.get(j))) {
                        repeatedBytes.add(bytes.get(i));
                    }
                }
            }
            System.out.print(repeatedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
