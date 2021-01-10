package CoreJava.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadEvenOddPrint {
    public static void printNum(String threadName) throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        if ("odd".equals(threadName)) {
            for (int i = 1; i < 10; i += 2) {
                System.out.println(threadName + " : " + i);
                Thread.sleep(1000);
            }
        }
        if ("even".equals(threadName)) {
            for (int i = 0; i < 10; i += 2) {
                System.out.println(threadName + " : " + i);
                Thread.sleep(1000);
            }
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().setName("odd");
                    String odd = Thread.currentThread().getName();
                    printNum(odd);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().setName("even");
                    String even = Thread.currentThread().getName();
                    printNum(even);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

/*

odd : 1
even : 0
even : 2
odd : 3
odd : 5
even : 4
even : 6
odd : 7
odd : 9
even : 8

 */