package CoreJava.MultiThreading;

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

/*

Thread t1 : 0
Thread t1 : 1
Thread t1 : 2
Thread t3 : 0
Thread t3 : 1
Thread t2 : 0
Thread t3 : 2
Thread t3 : 3
Thread t1 : 3
Thread t2 : 1
Thread t2 : 2
Thread t2 : 3

 */