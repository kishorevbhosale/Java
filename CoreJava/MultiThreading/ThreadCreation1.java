package CoreJava.MultiThreading;

/**
 * Implementing thread using Runnable interface and extending Thread class
 */
class ChildRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread name = " + Thread.currentThread().getName());
    }
}

class ChildThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread name = " + Thread.currentThread().getName());
    }
}

public class ThreadCreation1 {
    public static void main(String[] args) {
        Thread t = new ChildThread();
        t.start();
        t.setName("Child Thread with Thread");
        System.out.println("Thread name = " + Thread.currentThread().getName());

        ChildRunnableThread thread = new ChildRunnableThread();
        Thread th = new Thread(thread);
        th.start();
        th.setName("Child Thread with Runnable");
    }
}

/*

Thread name = main
Thread name = Child Thread with Thread
Thread name = Child Thread with Runnable


 */