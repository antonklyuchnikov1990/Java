package SheduledExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);

        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        };
        ses.schedule(task, 5, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate((Runnable) task, 1, 4, TimeUnit.SECONDS);
        ses.shutdown();

        List<Integer> arrayList = Collections.synchronizedList(new ArrayList<>());

        List<Integer> list = new CopyOnWriteArrayList<>();

    }
}
