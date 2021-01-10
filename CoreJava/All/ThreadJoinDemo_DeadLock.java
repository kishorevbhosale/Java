package mt;

class JoinChildThread extends Thread {
    static Thread mainThread;

    @Override
    public void run() {
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Child thread : " + i);
        }

    }
}

public class ThreadJoinDemo_DeadLock {
    public static void main(String[] args) throws InterruptedException {
        JoinChildThread thread = new JoinChildThread();
        JoinChildThread.mainThread = Thread.currentThread();
        thread.start();
        thread.join();
        for (int i = 0; i < 3; i++) {
            System.out.println("Main thread : " + i);
        }
    }
}

/*

Because of deadLock no output
Both thread waiting for each other

 */