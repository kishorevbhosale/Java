package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        /*Map<String,Integer> map = new HashMap<>();
        map.put("aaa",1);
        map.put("bbb",2);
        map.put("ccc",3);
        map.put("ddd",4);
        map.put("aaa",5);
        System.out.println(map);*/
        String s1 = "Ea";
        String s2 = "FB";
        Map<String,Integer> map1 = new HashMap<>();
        map1.put(s1,23);
        map1.put(s2,100);
        map1.put("newKey",null);
        map1.put(null,45);
        map1.put(null,156);
        System.out.println(map1);
        Set set = map1.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry m1 = (Map.Entry) iterator.next();
            System.out.println(m1.getKey()+" : "+m1.getValue());
        }

    }
}

/* 
output:
{null=156, newKey=null, Ea=23, FB=100}
null : 156
newKey : null
Ea : 23
FB : 100
*/
