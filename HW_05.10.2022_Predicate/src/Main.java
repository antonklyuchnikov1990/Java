import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
//        First level: Написать программу, которая проверяет, что строка начинается буквой “J”или “N”
//        и заканчивается “A”. Используем функциональный интерфейс Predicate.

        Predicate<String> p1 = s1 -> s1.toLowerCase().startsWith("j");
        Predicate<String> p2 = s1 -> s1.toLowerCase().startsWith("n");
        Predicate<String> p3 = s1 -> s1.toLowerCase().endsWith("a");

        System.out.println(p1.or(p2).and(p3).test("nrgdrghdrhdra"));
        System.out.println(p1.or(p2).and(p3).test("rgdrghdrhdra"));
        System.out.println(p1.or(p2).and(p3).test("jrgdrghdrhdra"));
        System.out.println(p1.or(p2).and(p3).test("rgdrghdrhdr"));

//Second level: Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri),
// remove all intervals that are covered by another interval in the list.
//The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
//Return the number of remaining intervals.
//
//Example 1:
//
//Input: intervals = [[1,4],[3,6],[2,8]]
//Output: 2
//Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
//
//Example 2:
//
//Input: intervals = [[1,4],[2,3]]
//Output: 1

//        int[] a ={1, 4};
//        int[] b ={3, 6};
//        int[] c ={2, 8};
//        int number = 0;
//        if (a[0] < c[0] && a[1] < c[1]) {
//            number++;
//        }
//        if (a[0] < b[0] && a[1] < b[1]) {
//            number++;
//        }
//        if (b[0] < c[0] && b[1] < c[1]) {
//            number++;
//        }
//        System.out.println(number);

//        Solution from teacher:
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(Arrays.toString(intervals));
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int maxEnd = intervals[0][1];
        int answer = intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= maxEnd) {
                answer--;
            } else {
                maxEnd = intervals[i][1];
            }
        }
        System.out.println(answer);
    }
}
