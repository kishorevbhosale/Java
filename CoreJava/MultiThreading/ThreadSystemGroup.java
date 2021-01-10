package CoreJava.MultiThreading;

public class ThreadSystemGroup {
    public static void main(String[] args) {
        ThreadGroup group = Thread.currentThread().getThreadGroup().getParent();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " : " + thread.isDaemon());
        }
    }
}


/*
Reference Handler : true
Finalizer : true
Signal Dispatcher : true
main : false
Monitor Ctrl-Break : true

 */