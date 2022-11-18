package task1;

public class Main {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        System.out.println(currentThread.getPriority());
        System.out.println(currentThread.isDaemon());
        ThreadGroup threadGroup = currentThread.getThreadGroup();
        System.out.println(threadGroup.getName());

    }
}
