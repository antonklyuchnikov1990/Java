public class Main {

    public static void main(String[] args) {
//        First level: 1. Дано два числа, например 3 и 56, необходимо составить следующие строки:
//3 + 56 = 59
//3 – 56 = -53
//3 * 56 = 168.
//Используем метод StringBuilder.append().
        int a = 3, b = 56;
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(a).append(" + ").append(b).append(" = 59"));
        sb.delete(0, sb.length());
        System.out.println(sb.append(a).append(" - ").append(b).append(" = -53"));
        sb.delete(0, sb.length());
        System.out.println(sb.append(a).append(" * ").append(b).append(" = 168"));

//Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(), StringBuilder.deleteCharAt().
        sb.insert(sb.indexOf("="), "equal");
        sb.deleteCharAt(sb.indexOf("="));
        System.out.println(sb);


//Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace()
        sb.replace(sb.indexOf("e"), sb.indexOf("1"), "= ");
        System.out.println(sb);
    }
}
