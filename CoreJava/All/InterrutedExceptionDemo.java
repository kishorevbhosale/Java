package mt;

public class InterrutedExceptionDemo {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("exiting  eblocking thread ");
                }
            }
        });
        t.start();
        t.interrupt();
    }
}
