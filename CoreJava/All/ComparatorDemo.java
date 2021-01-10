package collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1<l2){
            return -1;
        }else if(l1>l2){
            return 1;
        }else {
            return s1.compareTo(s2);
        }
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        Map map = new HashMap();
        TreeSet treeSet = new TreeSet(new MyComparator());
        treeSet.add("ab");
        treeSet.add("adc");
        treeSet.add("cd");
        treeSet.add("abcd");
        treeSet.add("abc");
        System.out.println(treeSet);
    }
}
