package CoreJava.Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveWhileIterating {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<String>();
        aList.add("Apple");
        aList.add("Mango");
        aList.add("Guava");
        aList.add("Orange");
        aList.add("Peach");
        System.out.println("The ArrayList elements are: ");
        for (String s : aList) {
            System.out.println(s);
        }
        Iterator<String> iterator = aList.iterator();
        while (iterator.hasNext()) {
            String str = (iterator.next());
            if (str.equalsIgnoreCase("Peach")) {
                iterator.remove();
                System.out.println("\nPeach is removed from list...\n");
            }
        }
        aList.stream().forEach(str -> {
            System.out.println(str);
        });
    }
}
