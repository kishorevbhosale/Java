package DesignPattern.SingletonPattern;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class EagerDemo {
    private static EagerDemo instance = new EagerDemo();

    private EagerDemo() {
    }

    public static EagerDemo getInstance() {
        return instance;
    }

    public static void dummyMethod() {
        System.out.println("I am dummy class :" + Thread.currentThread().getName());
    }
}

class LazyDemo {
    private static LazyDemo instance;

    //Added lock for multithreaded case
    private static Lock lock = new ReentrantLock();

    private LazyDemo() {
    }

    public static LazyDemo getInstance() {
        lock.lock();
        if (instance == null) {
            instance = new LazyDemo();
        }
        lock.unlock();
        return instance;
    }
}

class StaticBlockDemo {
    private static StaticBlockDemo instance;

    static {
        try {
            instance = new StaticBlockDemo();
        } catch (Exception e) {
            throw new RuntimeException("Exception while creating object!!!");
        }
    }

    private StaticBlockDemo() {
    }

    public static StaticBlockDemo getInstance() {
        return instance;
    }
}

public class SingletoneDemo {
    public static void main(String[] args) {
        System.out.println("\n------ Eager Demo ----------");
        EagerDemo eagerDemo = EagerDemo.getInstance();
        EagerDemo eagerDemo1 = EagerDemo.getInstance();
        System.out.println("HashCode for eagerDemo : " + eagerDemo.hashCode() + "\nHashCode for eagerDemo1 : " + eagerDemo1.hashCode());

        System.out.println("\n------ Eager Demo ----------");
        StaticBlockDemo demo = StaticBlockDemo.getInstance();
        StaticBlockDemo demo1 = StaticBlockDemo.getInstance();
        System.out.println("HashCode for demo : " + demo.hashCode() + "\nHashCode for demo1 : " + demo1.hashCode());

        System.out.println("\n------ Single Threaded LazyDemo  ----------");
        LazyDemo lazyDemo = LazyDemo.getInstance();
        LazyDemo lazyDemo1 = LazyDemo.getInstance();
        System.out.println("HashCode for lazyDemo : " + lazyDemo.hashCode() + "\nHashCode for lazyDemo1 : " + lazyDemo1.hashCode());

        System.out.println("\n------ Multi Threaded LazyDemo ----------");
        Runnable runnable = () -> {
            LazyDemo l1 = LazyDemo.getInstance();
            System.out.println("HashCode for l1 instilized : " + l1.hashCode());
        };
        Runnable runnable1 = () -> {
            LazyDemo l2 = LazyDemo.getInstance();
            System.out.println("HashCode for l2 instilized : " + l2.hashCode());
        };
        new Thread(runnable).start();
        new Thread(runnable1).start();


        System.out.println("\n------ Multi Threaded EagerDemo ----------");
        Runnable r1 = () -> {
            EagerDemo e1 = EagerDemo.getInstance();
            System.out.println("HashCode for e1 instilized : " + e1.hashCode());
            e1.dummyMethod();
        };
        Runnable r2 = () -> {
            EagerDemo e2 = EagerDemo.getInstance();
            System.out.println("HashCode for e2 instilized : " + e2.hashCode());
            e2.dummyMethod();
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}


/*
------ Eager Demo ----------
HashCode for eagerDemo : 1846274136
HashCode for eagerDemo1 : 1846274136

------ Eager Demo ----------
HashCode for demo : 1639705018
HashCode for demo1 : 1639705018

------ Single Threaded LazyDemo  ----------
HashCode for lazyDemo : 1625635731
HashCode for lazyDemo1 : 1625635731

------ Multi Threaded LazyDemo ----------
HashCode for l1 instilized : 1625635731
HashCode for l2 instilized : 1625635731

------ Multi Threaded EagerDemo ----------
HashCode for e1 instilized : 1846274136
HashCode for e2 instilized : 1846274136

I am dummy class :Thread-3
I am dummy class :Thread-2
 */