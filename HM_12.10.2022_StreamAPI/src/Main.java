import java.util.*;

public class Main {

    public static void main(String[] args) {
//        First level: Дан список строк. С помощью Stream API найти самую длинную строку.

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Hello, Java", "Berlin", "Tel-Ran");
        Optional<String> ol = list.stream().max(Comparator.comparingInt(String::length));
        ol.ifPresent(System.out::println);

//        Second level: Given two strings needle and haystack,
//        return the index of the first occurrence of needle in haystack,
//        or -1 if needle is not part of haystack.
//
//Example 1:
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//
//Example 2:
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.

        String needle = "ght";
        String haystack = "klldsjfksdjfisdfj";
        System.out.println(findIndex(needle, haystack));

    }

    private static int findIndex(String s, String str) {
        return str.indexOf(s);
    }
}
