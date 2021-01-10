package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(3);
        arrayList.add(14);
        arrayList.add(52);
        arrayList.add(67);
        arrayList.add(37);
        arrayList.add(28);
        arrayList.add(19);
        arrayList.add(10);
        arrayList.add(12);

        System.out.println(arrayList);
        List<Integer> data =  arrayList.stream().filter(integer -> integer%2==0).collect(Collectors.toList());
        List<Integer> add_data = arrayList.stream().map(integer -> integer+5).collect(Collectors.toList());
        long count = arrayList.stream().filter(integer -> integer<4).count();
        List<Integer> sorted_list = arrayList.stream().sorted().collect(Collectors.toList());
        List<Integer> desc_list = arrayList.stream().sorted((i1,i2)->(i1<i2)?1:(i1>i2)?-1:0).collect(Collectors.toList());
        System.out.println(data);
        System.out.println(add_data);
        System.out.println(count);
        System.out.println(sorted_list);
        System.out.println(desc_list);
        long min = arrayList.stream().min(Integer::compareTo).get();
        long max = arrayList.stream().max(Comparator.naturalOrder()).get();
        System.out.println(min);
        System.out.println(max);
        Consumer<Integer> consumer = integer -> {
            System.out.println("square : of "+integer+" : "+integer*integer);
        };
        arrayList.stream().forEach(consumer);

        arrayList.stream().forEach(integer -> {
            System.out.println("double : of "+integer+" : "+integer*2);
        });
        Integer[] integers =  arrayList.stream().toArray(Integer[]::new);
        for (Integer integer:integers) {
            System.out.println(integer);
        }
    }
}
