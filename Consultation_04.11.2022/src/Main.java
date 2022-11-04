import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\b[a-zA-Z]+\b)\s\1");
        Matcher matcher = pattern.matcher("word word example is not suitable");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
