package CoreJava.MultiThreading;

public class ThreadJoinDemo_SelfWaiting_Dedlock {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
        for (int i = 0; i < 3; i++) {
            System.out.println("Main " + i);
        }
    }
}
