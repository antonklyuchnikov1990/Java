import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewTheme {

    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("Java");
        matcher = pattern.matcher("Java");
        System.out.println(matcher.matches());

        matcher = pattern.matcher("Java 11");
        System.out.println(matcher.matches());

        System.out.println(matcher.find());

        matcher = pattern.matcher("Java 11 Java");
        while (matcher.find()) {
            System.out.println(matcher.start() + " - " + matcher.end());
        }

        System.out.println("-123".matches("-\\d"));
        System.out.println("-123".matches("-\\d+"));
        System.out.println("-1".matches("-\\d"));
        System.out.println("-123".matches("\\d+"));

        System.out.println("-123".matches("-?\\d+"));
        System.out.println("123".matches("-?\\d+"));
        System.out.println("-123.12".matches("-?\\d+\\.\\d+"));
        System.out.println("-123,12".matches("-?\\d+[.,]\\d+"));
        System.out.println("123".matches("\\d+"));
        System.out.println("-123".matches("\\d+"));

        String[] words = "name age".split("\\s");
        System.out.println(Arrays.toString(words));

        String text = "Egor Alla Alexander";
        Pattern pattern1 = Pattern.compile("A.+a");
        Matcher matcher1 = pattern1.matcher(text);
        while (matcher1.find()) {
            System.out.println(text.substring(matcher1.start(), matcher1.end()));
        }

        Pattern pattern2 = Pattern.compile("A.++a");
        Matcher matcher2 = pattern2.matcher(text);
        while (matcher2.find()) {
            System.out.println(text.substring(matcher2.start(), matcher2.end()));
        }

        Pattern pattern3 = Pattern.compile("A.+?a");
        Matcher matcher3 = pattern3.matcher(text);
        while (matcher3.find()) {
            System.out.println(text.substring(matcher3.start(), matcher3.end()));
        }

        Pattern pattern4 = Pattern.compile("W+");
        Matcher matcher4 = pattern4.matcher("W WW WWW");
        while (matcher4.find()) {
            System.out.println("Matches: " + matcher4.group());
        }

        System.out.println("W WW WWW".replaceAll("\\s", "q"));

        System.out.println("name@gmail.com".matches("^[A-Za-z0-9_-]+@(.+)$"));
    }
}
