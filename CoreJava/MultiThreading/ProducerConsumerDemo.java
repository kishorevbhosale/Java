package CoreJava.MultiThreading;

import java.util.LinkedList;
import java.util.List;

class Producer implements Runnable {
    private List<Integer> sharedQueue;
    private int MAX_SIZE = 2;

    Producer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                produce(i);
            } catch (InterruptedException e) {
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.size() == MAX_SIZE) {
                System.out.println("Queue is full. Producer is waiting for Consumer to consume");
                sharedQueue.wait();
            } else {
                sharedQueue.add(i);
                Thread.sleep(1000);
                System.out.println("Produced : " + i);
                sharedQueue.notify();
            }
        }
    }
}

class Cosumer implements Runnable {
    private List<Integer> sharedQueue;
    private int MIN_SIZE = 0;

    Cosumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                consume();
            } catch (InterruptedException e) {

            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.size() == MIN_SIZE) {
                System.out.println("Queue is empty. Waiting for producer to produce");
                sharedQueue.wait();
            } else {
                int num = sharedQueue.remove(0);
                System.out.println("Consumed : " + num);
                sharedQueue.notify();
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        List<Integer> sharedQueue = new LinkedList<>();
        Producer p = new Producer(sharedQueue);
        Cosumer c = new Cosumer(sharedQueue);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

/*

Produced : 1
Produced : 2
Queue is full. Producer is waiting for Consumer to consume
Consumed : 1
Consumed : 2
Queue is empty. Waiting for producer to produce
Produced : 4
Produced : 5
Queue is full. Producer is waiting for Consumer to consume
Consumed : 4
Consumed : 5
Queue is empty. Waiting for producer to produce
Produced : 7
Produced : 8
Queue is full. Producer is waiting for Consumer to consume
Consumed : 7
Consumed : 8
Queue is empty. Waiting for producer to produce


 */