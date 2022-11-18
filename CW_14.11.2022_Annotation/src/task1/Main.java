package task1;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
       Example example = new Example();
       Class<?> c = example.getClass();
       try {
           Method m = c.getMethod("method1");
           MyAnno anno = m.getAnnotation(MyAnno.class);
           System.out.println(anno.str());
           System.out.println(anno.val());
           Method m2 = c.getMethod("method3", String.class, int.class);
       } catch (NoSuchMethodException e) {
           e.printStackTrace();
       }
    }
    @MyAnno(str = "Annotation example", val = 100)
    public static void meth1() {
    }
}
