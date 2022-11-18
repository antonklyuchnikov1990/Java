package task1;

public class Example {

    @MyAnno (str = "Annotation example1", val = 200)
    public void method1() {
        System.out.println("in method1()");
    }

    public void method2() {
        System.out.println("in method2()");
    }

    public void method3(String s, int a) {
    }
}
