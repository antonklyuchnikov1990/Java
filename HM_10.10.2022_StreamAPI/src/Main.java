import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

// First level: 1. Определить количество четных чисел в потоке данных.
        System.out.println("Task 1.1:");
        int[] array = {1, 3, 4, 7, 9, 12, 28, 6, 5, 16, 19};
        long count = Arrays.stream(array).filter(a -> a % 2 == 0).count();
        System.out.println(count);


//Задано множество фамилий сотрудников. Разработать программу, которая отображает все фамилии,
// начинающиеся на букву «J».
        System.out.println();
        System.out.println("Task 1.2:");
        List<String> list = Arrays.asList("Johnson", "Parker", "Trump");
        System.out.println(list.stream().filter(l -> l.startsWith("J")).toList());

        System.out.println();
        System.out.println("Task 1.3a:");
        List<String> list2 = Arrays.asList("Highload", "High", "Load", "Highload");
        long count2 = list2.stream().filter(l2 -> l2.contains("High")).count();
        System.out.println(count2);

        //Пусть дана коллекция состоящая из строк. Arrays.asList(«Highload», «High», «Load», «Highload»).
//а) Вывести, сколько раз объект «High» встречается в коллекции.
//б) Какой элемент в коллекции находится на первом месте? Если мы получили пустую коллекцию,
// то пусть возвращается 0.
        System.out.println();
        System.out.println("Task 1.3b:");
        Optional<String> firstElement = list2.stream().findFirst();
        System.out.println(firstElement);

        //Дана коллекция Arrays.asList("f10", "f15", "f2", "f4", "f4"). Нужно выполнить сортировку
// в обратном алфавитному порядке и удалить дубликаты. В массиве должны оказаться только уникальные значения

        System.out.println();
        System.out.println("Task 1.4:");
        List<String> list3 = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        System.out.println(list3.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList()));
    }
}
