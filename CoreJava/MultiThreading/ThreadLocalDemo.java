package CoreJava.MultiThreading;

class Local extends Thread {
    static Integer threadId = 0;
    private static ThreadLocal threadLocal = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return ++threadId;
        }
    };

    Local(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread-name : " + getName() + " Thread ID : " + threadLocal.get());
    }
}

public class ThreadLocalDemo {
    public static void main(String[] args) {
        Local t1 = new Local("t1");
        Local t2 = new Local("t2");
        Local t3 = new Local("t3");
        Local t4 = new Local("t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
/*
O/p
        Thread-name : t2 Thread ID : 2
        Thread-name : t4 Thread ID : 4
        Thread-name : t3 Thread ID : 3
        Thread-name : t1 Thread ID : 1
*/
