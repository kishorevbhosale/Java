package CoreJava.MultiThreading;


/**
 * Thread creation using java8
 */


public class ThreadCreation {
    public static void main(String[] args) {

        Thread t = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Thread.currentThread().setName("Child-Thread-1");
                        System.out.println(Thread.currentThread().getName());
                    }
                }
        );
        t.start();


        Runnable runnable = () -> {
            Thread.currentThread().setName("Child-Thread-2");
            System.out.println(Thread.currentThread().getName());
        };
        new Thread(runnable).start();

    }
}