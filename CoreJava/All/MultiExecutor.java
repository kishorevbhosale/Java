package mt;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {
    private final List<Runnable> tasks;

    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread t1 : " + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread t2 : " + i);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread t3 : " + i);
            }
        });
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        MultiExecutor m = new MultiExecutor(tasks);
        m.executeAll();
    }

    public void executeAll() {
        List<Thread> threads = new ArrayList<>(tasks.size());

        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }


}
