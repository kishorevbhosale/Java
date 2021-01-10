package CoreJava.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
    String name;

    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-Start Command : " + name);
        processCommand();
        System.out.println("Taks completed...");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            WorkerThread workerThread = new WorkerThread(" " + i);
            service.execute(workerThread);
        }
        service.shutdownNow();
        while (!service.isTerminated()) {
        }
        System.out.println("Finished all threads");

    }
}

/*
pool-1-thread-2-Start Command :  1
pool-1-thread-5-Start Command :  4
pool-1-thread-4-Start Command :  3
pool-1-thread-1-Start Command :  0
pool-1-thread-3-Start Command :  2
Taks completed...
Taks completed...
Taks completed...
Taks completed...
Taks completed...
Finished all threads

 */