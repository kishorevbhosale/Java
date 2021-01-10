package CoreJava.MultiThreading;


/**
 * Child thread give chance to other thread for execution using yield method
 */
class Mythread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("child thread!!!");
            Thread.yield();
        }
    }
}

public class ThreadYieldDemo {
    public static void main(String[] args) throws InterruptedException {
        Mythread mythread = new Mythread();
        mythread.start();
        mythread.setPriority(5);
        for (int i = 0; i < 3; i++) {
            System.out.println("main thread!!!");
        }
    }
}

/*

child thread!!!
main thread!!!
main thread!!!
main thread!!!
child thread!!!
child thread!!!

 */