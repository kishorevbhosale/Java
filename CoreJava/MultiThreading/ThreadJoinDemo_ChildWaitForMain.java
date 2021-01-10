package CoreJava.MultiThreading;

class MyTh extends Thread {
    static Thread mainThread;

    @Override
    public void run() {
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Child Thread");
        }
    }
}

public class ThreadJoinDemo_ChildWaitForMain {
    public static void main(String[] args) {
        MyTh.mainThread = Thread.currentThread();
        MyTh myTh = new MyTh();
        myTh.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("Main Thread");
        }
    }
}

/*
Output -

Main Thread
Main Thread
Main Thread
Child Thread
Child Thread
Child Thread
 */