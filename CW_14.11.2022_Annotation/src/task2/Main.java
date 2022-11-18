package task2;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Example example = new Example();
        Class<?> c = example.getClass();
        Class<?> voidClass = void.class;
        Class<?> stringClass = String.class;
        Class<?> intClass = int.class;

        try {
            Class<?> cl = Class.forName("task2.Example");
            Method meth = c.getMethod("method1");
            System.out.println(meth.getAnnotation(MyAnno.class).str());
//            Method[] methods = c.getMethods();
//            for (Method m : methods) {
//                System.out.println(m.getName());
//                MyAnno myAnno = m.getAnnotation(MyAnno.class);
//                if (myAnno != null) {
//                    System.out.println(myAnno.str());
//                }
        } catch (ClassNotFoundException | NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

//        try {
//            Class<?> cl = Class.forName("task2.Example");
//            Annotation[] annotations = cl.getAnnotations();
//            for (Annotation an : annotations) {
//                if (an.annotationType().equals(MyAnno.class)) {
//                    System.out.println(((MyAnno)an).str());
//                }
//            }
//        } catch (ClassNotFoundException e) {
//           e.printStackTrace();
//        }
    }

