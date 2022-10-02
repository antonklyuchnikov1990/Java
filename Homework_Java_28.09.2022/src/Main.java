import java.nio.charset.StandardCharsets;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
//        First level: 1. Написать функциональный интерфейс с методом, который принимает две строки и возвращает
//        тоже строку. Написать реализацию такого интерфейса в виде лямбды, которая возвращает ту строку,
//        которая длиннее.

        StringCalculatable stringCalculatable = (a, b) -> {
            if (a.length() > b.length()) {
                return a;
            }
            if (a.length() < b.length()) {
                return b;
            } else {
                return "Strings has equals length";
            }
        };
        System.out.println(stringCalculatable.calculateString("Bern", "Amsterdam"));
        System.out.println(stringCalculatable.calculateString("Berlin", "Warsaw"));
        System.out.println(stringCalculatable.calculateString("London", "Nice"));


//        Написать программу проверяющую, что строка не null и не пуста, используя метод and()
//        функционального интерфейса Predicate.
        System.out.println("Task 1.2:");

        Predicate<String> predicate = s -> (s != null) && s.length() != 0;
        System.out.println(predicate.test("Munich"));
        System.out.println(predicate.test(null));
        System.out.println(predicate.test(""));

        System.out.println("Task 1.2 (Variant 2):");
        Predicate<String> predicate1 = s -> s != null;
        Predicate<String> predicate2 = s -> s.length() != 0;
        System.out.println(predicate1.and(predicate2).test("Munich"));
        System.out.println(predicate1.and(predicate2).test(null));
        System.out.println(predicate1.and(predicate2).test(""));

//        Second level: Given a string s, find the length of the longest substring without repeating characters.

//Example 1:

//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.

//Example 2:

//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.

//Example 3:

//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

        
    }
}
