package task3;

public class Main {

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Subthread: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Subthread interrupted");
                }
            }
            System.out.println("Subthread finish");
        };
        new Thread(task).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Mainthread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Mainthread interrupted");
            }
        }
        System.out.println("Mainthread finish");
    }
}
