package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationDemo extends Thread {
    static ArrayList list = new ArrayList();

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
        }
        System.out.println("Child thread modifying list");
        list.add("d");
    }

    public static void main(String[] args) throws InterruptedException {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("e");
        ConcurrentModificationDemo thread = new ConcurrentModificationDemo();
        thread.start();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String s1 = (String)iterator.next();
            System.out.println("Main thread iterating object : "+s1);
            Thread.sleep(10000);
        }
        System.out.println(list);
    }
}
