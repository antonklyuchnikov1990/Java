import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RunTests {

    public static void start(Class obj) {
        getAnnotationAndRun(obj);
    }

    public static void start(String objFullName) {
        try {
            getAnnotationAndRun(Class.forName(objFullName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getAnnotationAndRun(Class testedObj) {
        Method beforeMethod = null;
        Method afterMethod = null;
        ArrayList<Method> methods = new ArrayList<>();
        for (Method method : testedObj.getDeclaredMethods()) {
            if (method.getDeclaredAnnotation(BeforeSuite.class) != null) {
                if (beforeMethod != null) {
                    throw new RuntimeException("Annotation BeforeSuite already exists");
                }
                beforeMethod = method;
                continue;
            }
            if (method.getDeclaredAnnotation(AfterSuite.class) != null) {
                if (afterMethod != null) {
                    throw new RuntimeException("Annotation AfterSuite already exists");
                }
                afterMethod = method;
                continue;
            }
            if (method.getDeclaredAnnotation(Test.class).priority() > 10 ||
                    method.getDeclaredAnnotation(Test.class).priority() < 1) {
                throw new RuntimeException("Class has methods with wrong priority");
            }
            methods.add(method);
        }
        methods.sort((o1, o2) -> {
            int order1 = o1.getDeclaredAnnotation(Test.class).priority();
            int order2 = o2.getDeclaredAnnotation(Test.class).priority();
            return Integer.compare(order1, order2);
        });
        if (beforeMethod != null) {
            methods.add(0, beforeMethod);
        }
        if (afterMethod != null) {
            methods.add(afterMethod);
        }

        Object obj = null;
        try {
            obj = testedObj.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (Method method : methods) {
            System.out.println(sdf.format(Calendar.getInstance().getTime()) + " :: Run "
                    + testedObj.getSimpleName() + ". " + method.getName() + ": ");
            try {
                method.invoke(obj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

}