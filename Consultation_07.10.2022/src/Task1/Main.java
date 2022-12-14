package Task1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Hello", "Java", "Spring");

        list.forEach(s -> System.out.println(s));

        // 2. Создать переменную типа Task1.Operationable
        Operationable operation;

        // 3. Присвоить этой переменной реализацию метода calculate
        // с помощью лямбды
        operation = (x, y) -> {
            for (int i = 0; i < 10; i++) {
            }
            if (x + y > 0) {
                return x - y;
            } else {
                return 100;
            }
        };

        Operationable operation2 = (x, y) -> x - y;

        // 4. Теперь можно обратиться к методу calculate через переменную operation
        int result = operation.calculate(12, 3);
        System.out.println(result);

        Operation operation1 = new Operation();
        operation1.calculate(20, 30);

        Operationable operation3 = new Operationable() {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        };
    }
}


// 1. Создать функциональный интерфейс
@FunctionalInterface
interface Operationable {
    int calculate(int x, int y);
}