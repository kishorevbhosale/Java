package CoreJava.MultiThreading;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        });

        System.out.println("Main class thread name : " + Thread.currentThread().getName());
        System.out.println("Newly created thread name : " + t.getName());

        t.setName("Local worker thread");
        System.out.println("Name assigned to new thread using - t.setName() : " + t.getName());

        t.setPriority(2);
        Thread.currentThread().setPriority(10);
        System.out.println("Main class thread priority : " + Thread.currentThread().getPriority());
        System.out.println("Assigned highest priority to new thread using - t.setPriority() : " + t.getPriority());

        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

/*

Output -
Main class thread name : main
Newly created thread name : Thread-0
Name assigned to new thread using - t.setName() : Local worker thread
Main class thread priority : 10
Assigned highest priority to new thread using - t.setPriority() : 2
main : 0
main : 1
main : 2
main : 3
main : 4
Local worker thread : 0
Local worker thread : 1
Local worker thread : 2
Local worker thread : 3
Local worker thread : 4
 */