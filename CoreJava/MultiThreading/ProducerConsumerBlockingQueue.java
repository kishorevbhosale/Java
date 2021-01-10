package CoreJava.MultiThreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
        final Runnable producer = () -> {
            while (true) {
                try {
                    System.out.println("Producer Thread : " + Thread.currentThread().getName());
                    queue.put(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () -> {
            while (true) {
                try {
                    Integer i = queue.take();
                    System.out.println("Consumer Thread : " + Thread.currentThread().getName() + " consumed item : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();

        Thread.sleep(1000);

    }
}

/*

Output :

Producer Thread : Thread-0
Producer Thread : Thread-1
Consumer Thread : Thread-2 consumed item : 75
Consumer Thread : Thread-2 consumed item : 33
Producer Thread : Thread-0
Producer Thread : Thread-1
Producer Thread : Thread-1
Producer Thread : Thread-1
Producer Thread : Thread-0
Consumer Thread : Thread-3 consumed item : 69
Consumer Thread : Thread-2 consumed item : 53
Consumer Thread : Thread-2 consumed item : 63
Consumer Thread : Thread-2 consumed item : 11
Producer Thread : Thread-1
Consumer Thread : Thread-3 consumed item : 87
Consumer Thread : Thread-2 consumed item : 65
Producer Thread : Thread-1
Producer Thread : Thread-0
Consumer Thread : Thread-3 consumed item : 26
Consumer Thread : Thread-2 consumed item : 78
Producer Thread : Thread-1
Producer Thread : Thread-0
Consumer Thread : Thread-3 consumed item : 93
Producer Thread : Thread-1
Consumer Thread : Thread-2 consumed item : 28
Consumer Thread : Thread-3 consumed item : 70
Producer Thread : Thread-0
Producer Thread : Thread-1

 */