package CoreJava.MultiThreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerDemo1 {
    public static void main(String[] args) {
        List<Integer> sharedQueue = new LinkedList<>();
        int maxSize = 2;

        final Runnable producer = () -> {
            synchronized (sharedQueue) {
                if (sharedQueue.size() == maxSize) {
                    System.out.println("Queue is full. Producer is waiting for Consumer to consume");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Integer i = new Random().nextInt(100);
                    sharedQueue.add(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Produced : " + i);
                    sharedQueue.notify();

                }
            }
        };


        final Runnable consumer = () -> {
            synchronized (sharedQueue) {
                if (sharedQueue.size() == 0) {
                    System.out.println("Queue is empty. Waiting for producer to produce");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Integer i = sharedQueue.remove(0);
                    System.out.println("Consumed..." + i);
                }
                sharedQueue.notify();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(producer).start();
            new Thread(consumer).start();
        }

    }
}


/*

Produced : 80
Consumed...80
Produced : 53
Consumed...53
Produced : 3
Consumed...3
Produced : 61
Consumed...61
Produced : 23
Consumed...23
Produced : 14
Consumed...14
Produced : 4
Consumed...4
Produced : 66
Consumed...66
Produced : 93
Consumed...93
Produced : 19
Consumed...19

 */