import java.util.Arrays;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
//        First level: Разработать программу,
//        в которой осуществляется поэлементное суммирование массивов из 10 чисел.
//        Тип чисел может быть любым числовым (int, double, float, …).
//        Суммирование массивов реализовать с помощью лямбда-выражения.
//        Поэлементно сложить два массива - это так: {1, 2, 3} + {4, 5, 6} = {5, 7, 9}

        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        BiFunction<int[], int[], int[]> biFunction = (int[] a1, int[] a2) -> {
            int[] a3 = new int[a1.length];
            for (int i = 0; i < a1.length; i++) {
                a3[i] = a1[i] + a2[i];
            }
            return a3;
        };

        System.out.println(Arrays.toString(biFunction.apply(array1, array2)));
    }
}
