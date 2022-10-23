public class Student {

    String name;
    int age;
    Gender gender;

    public Student(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

class Gender {
    public static final Gender MAN = new Gender();
    public static final Gender WOMAN = new Gender();
}
