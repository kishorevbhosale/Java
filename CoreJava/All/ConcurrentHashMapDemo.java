package collection;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo extends Thread {
    static ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();
    @Override
    public void run() {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){}
        System.out.println("Child thread is trying to Modifying map");
        map.putIfAbsent(5,"Test");
    }

    public static void main(String[] args) throws InterruptedException{
        ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
        map.put(1,"My");
        map.put(2,"Best");
        map.put(4,"God");
        map.put(5,"You");
        demo.start();
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Integer integer = (Integer)iterator.next();
            System.out.println("Iterating object : "+map.get(integer));
            Thread.sleep(5000);
        }
        System.out.println(map);
    }
}
