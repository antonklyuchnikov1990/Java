import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number a");
        int a = scanner.nextInt();
        System.out.println("Input number b");
        int b = scanner.nextInt();
        StringBuilder first = getString(a, b, '+', a + b);
        StringBuilder second = getString(a, b, '-', a - b);
        StringBuilder third = getString(a, b, '*', a * b);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(replaceEquals1(first));
        System.out.println(replaceEquals1(second));
        System.out.println(replaceEquals1(third));
//        System.out.println(replaceEquals2(first));
//        System.out.println(replaceEquals2(second));
//        System.out.println(replaceEquals2(third));

    }

    private static StringBuilder replaceEquals1(StringBuilder sb) {
        int idx = sb.indexOf("=");
        return sb.deleteCharAt(idx)
                .insert(idx, " equal ");
    }

    private static StringBuilder replaceEquals2(StringBuilder sb) {
        int idx = sb.indexOf("=");
        return sb.replace(idx, idx + 1, " equal ");
    }

    private static StringBuilder getString(int a, int b, char op, int result) {
        StringBuilder sb = new StringBuilder();
        sb
                .append(a)
                .append(op)
                .append(b)
                .append("=")
                .append(result);
        return sb;
    }
}
