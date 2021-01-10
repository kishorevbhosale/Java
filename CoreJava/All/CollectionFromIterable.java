package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionFromIterable {
    public static void main(String[] args) {
        Iterable<Integer> i = Arrays.asList(1, 2, 3, 4);
        System.out.println("Iterable List : " + i);
        Collection<Integer> cn = getCollectionFromIteralbe(i);
        System.out.println("Collection List : " + cn);
    }

    private static <T> Collection<T> getCollectionFromIteralbe(Iterable<T> i) {
        Collection<T> cltn = new ArrayList<T>();
        i.forEach(cltn::add);
        return cltn;
    }
}
