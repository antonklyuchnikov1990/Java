import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFolderNames(new String[]{"pes", "fifa", "gta", "pes2019"})));
        System.out.println(Arrays.toString(getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"})));
        System.out.println(Arrays.toString(getFolderNames(new String[]{"openpiece", "openpiece(1)", "openpiece(2)", "openpiece(3)", "openpiece"})));


    }
    private static String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                // Такое имя уже использовалось
                int val = map.get(names[i]);
                while (map.containsKey(names[i] + "(" + val + ")")) {
                    val++;
                }
                result[i] = names[i] + "(" + val + ")";
                map.put(names[i], 1);
            } else {
                // Такое имя ещё не использовалось - используем его
                result[i] = names[i];
                map.put(names[i], 1);
            }
        }
        return result;
    }
}