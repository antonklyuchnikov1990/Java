import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        byte[] array = {1, 2, 3, 4, 5, 4, 5, 9};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileOutputStream fos = new FileOutputStream("D:\\IT\\Test_26.10.2022")) {
            baos.writeTo(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Выполнение задания
        try (FileInputStream fis = new FileInputStream("D:\\IT\\Test_26.10.2022")) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            Map<Byte, Integer> map = new HashMap<>();
            for (int i = 0; i < buffer.length; i++) {
                if (map.containsKey(buffer[i])) {
                    map.put(buffer[i], map.get(buffer[i]) + 1);
                } else {
                    map.put(buffer[i], 1);
                }
            }
            int maxValue = map.values().stream()
                    .max(Integer::compareTo).orElse(0);
            for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
