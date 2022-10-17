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

        String needle = "sad";
        String haystack = "sabutsad";
        System.out.println(findIndex(needle, haystack));
        System.out.println(kmp(needle, haystack));

    }

    private static int kmp(String needle, String haystack) {
        int len = needle.length();
        int[] pi = prefix(needle + "#" + haystack);
        for (int i = 0; i < haystack.length(); i++) {
            if (pi[i + 1 + len] == len) {
                return i - len + 1;
            }
        }
        return -1;
    }

    private static int findIndex(String s, String str) {
        return str.indexOf(s);
    }

    private static int[] prefix(String str) {
        int len = str.length();
        int[] pi = new int[len];
        pi[0] = 0;
        for (int i = 1; i < len; i++) {
            int j = pi[i - 1];
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                pi[i] = j + 1;
            } else {
                pi[i] = j;
            }
        }
        return pi;
    }

}
