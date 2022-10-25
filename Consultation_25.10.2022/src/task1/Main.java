package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Dmitry", 17, Gender.MAN),
                new Student("Maksim", 20, Gender.MAN),
                new Student("Kate", 20, Gender.WOMAN),
                new Student("Michael", 28, Gender.MAN)
        );

        double avg = students.stream()
                .filter(s -> s.getGender() == Gender.MAN)
                .mapToDouble(Student::getAge)
                .average().orElseThrow();
        System.out.println(avg);

    }
}
