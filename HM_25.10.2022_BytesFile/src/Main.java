import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input file path to find repeat bytes:");
        try (FileInputStream fis = new FileInputStream(sc.nextLine());
             ByteArrayInputStream bais = new ByteArrayInputStream(fis.readAllBytes())) {
            HashMap<Integer, Integer> repeatedBytes = new HashMap<>();
            ArrayList<Integer> bytes = new ArrayList<>();
            int b;
            while ((b = bais.read()) != -1) {
                bytes.add(b);
            }
            for (Integer aByte : bytes) {
                repeatedBytes.put(aByte, repeatedBytes.getOrDefault(aByte, 0) + 1);
            }
            int max =  Collections.max(repeatedBytes.values());
//            Map.Entry<Integer, Integer> searchByte = repeatedBytes.entrySet().stream()
//                    .max(Map.Entry.comparingByValue()).orElseThrow();
//            System.out.println(searchByte);
            for (Map.Entry<Integer, Integer> m : repeatedBytes.entrySet()) {
                if (m.getValue() == max) {
                    System.out.println("Byte: " + m.getKey() + " repeat " + m.getValue() + " times");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
