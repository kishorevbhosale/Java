package mt;

class MyThreads extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Child method.");
        }
    }
}

public class ThreadJoinDemo_MainWaitForChild {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread will wait until child completes...");
        MyThreads mt = new MyThreads();
        mt.start();
        mt.join();
        for (int i = 0; i < 3; i++) {
            System.out.println("Main method");
        }
    }
}

/*
output -
Main thread will wait until child completes...
Child method.
Child method.
Child method.
Main method
Main method
Main method
 */