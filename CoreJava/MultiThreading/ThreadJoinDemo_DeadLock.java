package CoreJava.MultiThreading;

class MyThread extends Thread {
    static Thread main;

    @Override
    public void run() {
        System.out.println("Child Thread");
        try {
            main.join();
            main.interrupt();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ThreadJoinDemo_DeadLock {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread.main = Thread.currentThread();
        myThread.start();
        try {
            System.out.println("Parent Thread");
            myThread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Deadlock resolved");
    }
}

/*

Because of deadLock no output
Both thread waiting for each other

 */