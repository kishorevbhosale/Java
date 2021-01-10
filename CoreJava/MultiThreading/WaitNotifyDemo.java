package CoreJava.MultiThreading;

public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            int sum = 0;

            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("Child Thread started...");
                    for (int i = 0; i < 10; i++) {
                        sum += i;
                    }
                    System.out.println("Sum : " + sum);
                    this.notify();
                }
            }
        });

        t.start();
        synchronized (t) {
            System.out.println("Main threading waiting for child thread");
            t.wait();
            System.out.println("Main thread got notification from child thread");
        }
    }
}

/*

Main threading waiting for child thread
Child Thread started...
Sum : 45
Main thread got notification from child thread


 */