package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p1 = context.getBean("parrot1", Parrot.class);
        System.out.println(p1.getName());

        Parrot p2 = context.getBean("Miki", Parrot.class);
        System.out.println(p2.getName());

        Parrot p3 = context.getBean(Parrot.class);
        System.out.println(p3.getName());

        // Программный способ добавления бинов в контекст
//        Parrot p4 = new Parrot("hello");
//        context.registerBean("hello", Parrot.class, p4);
//        Parrot p41 = context.getBean("hello", Parrot.class);
//        System.out.println(p41.getName());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer i = context.getBean(Integer.class);
        System.out.println(i);

    }
}
