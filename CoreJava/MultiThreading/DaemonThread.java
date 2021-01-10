package CoreJava.MultiThreading;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am daemon running in backend...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("Daemon thread task competed...");
            }
        });
        t.setDaemon(true);
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            Thread.sleep(300);
        }
    }
}

/*

0
I am daemon running in backend...
1
2
3
Daemon thread task competed...
4

 */