package CoreJava.Collection;

import java.util.HashSet;

@FunctionalInterface
interface Square {
    public int calculate(int x);
}

public class FI_Demo {
    public static void main(String[] args) {
        int a = 5;
        Square s = (int x) -> x * x;
        System.out.println(s.calculate(a));
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("data");

    }
}
