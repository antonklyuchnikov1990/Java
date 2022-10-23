import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//First level: Предположим имеется коллекция вида:
//Arrays.asList( new Student("Дмитрий", 17, Gender.MAN), new Student("Максим", 20, Gender.MAN),
// new Student("Екатерина", 20, Gender.WOMAN), new Student("Михаил", 28, Gender.MAN)
//Создать необходимые классы самостоятельно и потом создать подобную коллекцию.
// Найти в этой коллекции средний возраст студентов мужского пола. Использовать Stream API.

        ArrayList<Student> list = new ArrayList<>(Arrays.asList(new Student("Dmitry", 17, Gender.MAN),
                new Student("Maksim", 20, Gender.MAN),
                new Student("Ekaterina", 20, Gender.WOMAN),
                new Student("Michail", 28, Gender.MAN)));
        double avgAge = list.stream().filter(student -> student.gender.equals(Gender.MAN))
                .mapToInt(student -> student.age)
                .average().orElseThrow();
        System.out.printf("%.2f", avgAge);
    }
}
