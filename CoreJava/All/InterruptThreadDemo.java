package mt;

class LazyThread extends Thread{
    @Override
    public void run() {
        System.out.println("I am child and very lazy");
        for (int i = 0; i < 10; i++) {
            System.out.println("child thread : "+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Someone interrupted lazy child thread...");
            }
        }
    }
}
public class InterruptThreadDemo {
    public static void main(String[] args) {
        LazyThread lazyThread = new LazyThread();
        lazyThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread : "+i);
            lazyThread.interrupt();
        }
    }
}
