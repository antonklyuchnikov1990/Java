import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // 1. Определить количество четных чисел в потоке данных.
        long count = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(count);
        // Можно было использовать IntStream.of

        // 2. Задано множество фамилий сотрудников. Разработать программу, которая отображает все фамилии,
        // начинающиеся на букву «J».
        Set<String> names = new HashSet<>();
        names.add("Johnson");
        names.add("Black");
        names.add("White");
        names.stream().filter(s -> s.startsWith("J")).forEach(System.out::println);

        //Пусть дана коллекция состоящая из строк. Arrays.asList(«Highload», «High», «Load», «Highload»).
        //а) Вывести, сколько раз объект «High» встречается в коллекции.
        //б) Какой элемент в коллекции находится на первом месте? Если мы получили пустую коллекцию,
        // то пусть возвращается 0.
        List<String> strings = Arrays.asList("Highload", "High", "Load", "Highload");
        long countHigh = strings.stream().filter("High"::equals).count(); // s -> s.equals("High")
        System.out.println(countHigh);

        String firstName = strings.stream().findFirst().orElse("0");
        System.out.println(firstName);

        Optional<String> optFirstName = strings.stream().findFirst();
        if (optFirstName.isPresent()) {
            System.out.println(optFirstName.get());
        } else {
            System.out.println(0);
        }
        //Дана коллекция Arrays.asList("f10", "f15", "f2", "f4", "f4"). Нужно выполнить сортировку
        // в обратном алфавитному порядке и удалить дубликаты. В массиве должны оказаться только уникальные значения

        Stream.of("f10", "f15", "f2", "f4", "f4").distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
