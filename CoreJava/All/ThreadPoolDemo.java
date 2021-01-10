package mt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{
    String name;
    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-Start Command : "+name);
        processCommand();
        System.out.println("Taks completed...");
    }
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            
        }
    }

    @Override
    public String toString(){
        return this.name;
    }
}
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            WorkerThread workerThread = new WorkerThread(" "+i);
            service.execute(workerThread);
        }
        service.shutdownNow();
        while (!service.isTerminated()) {
        }
        System.out.println("Finished all threads");

    }
}
