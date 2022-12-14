import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//First level: 1. Написать регулярное выражение, определяющее является ли данная строчка шестнадцатиричным
// идентификатором цвета в HTML. Где #FFFFFF для белого, #000000 для черного, #FF0000 для красного и т.д.
//– пример правильных выражений: #FFFFFF, #FF3421, #00ff00.
//– пример неправильных выражений: 232323, f#fddee, #fd2.

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("#[A-Z\\d]{6}");
        matcher = pattern.matcher("#FFFFFF");
        System.out.println(matcher.matches());

        //Проверить, надежно ли составлен пароль. Пароль считается надежным, если он состоит из 8 или более символов.
// Где символом может быть английская буква, цифра и знак подчеркивания.
//– пример правильных выражений: C00l_Pass, SupperPas1.
//– пример неправильных выражений: C00l.

        System.out.println("COOL".matches("\\w{7}+\\w+"));

//        Проверить на обязательное наличие буквы из нижнего регистра, из верхнего регистра
//        а также специального символа


//        Scanner sc = new Scanner(System.in);
//        String example = sc.next();
//        System.out.println(validation(example));
//        String regEx = "\\w{8,}(?=.*\\W)(?=.*[a-z])(?=.*[A-Z])";
//        System.out.println("GoodVibes?".matches(regEx));
        String regEx = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)\\w{8,}";
        System.out.println("GoodVibes6".matches(regEx));

    }

//    private static boolean validation(String example) {
//        String regEx = "\\w{8,}";
//        return example.contains("a-zA-Z");
//    }
//     example.contains("a-zA-Z\\W") &&
//    example.matches(regEx)
}
