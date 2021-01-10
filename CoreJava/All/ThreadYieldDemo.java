package mt;

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
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
        mythread.setPriority(5);
        for (int i = 0; i < 3; i++) {
            System.out.println("main thread!!!");
        }
    }
}

/*
output -

main thread!!!
main thread!!!
main thread!!!
child thread!!!
child thread!!!
child thread!!!
 */