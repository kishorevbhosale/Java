package java8;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class MyImmutable {
    private final String name;
    private final String company;
    private final Set<String> stringSet;


    public MyImmutable(String name, String company, Set<String> newstringset) {
        Set<String> tmpSet = new HashSet<>();
        tmpSet.addAll(newstringset);
        this.name = name;
        this.company = company;
        this.stringSet = Collections.unmodifiableSet(tmpSet);;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    @Override
    public String toString() {
        return " name='" + name + ", stringSet=" + stringSet + ", company='" + company;
    }
}

public class ImmutableClassDemo {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>(Arrays.asList("a", "b", "c"));
        MyImmutable myImmutable = new MyImmutable("SB","CSSTACK",stringSet);
        System.out.println("Before change in stringSet : "+myImmutable);
        stringSet.add("d");
        System.out.println("After  change in stringSet : "+myImmutable);

    }
}

/*

Before change in stringSet :  name='SB, stringSet=[a, b, c], company='CSSTACK
After  change in stringSet :  name='SB, stringSet=[a, b, c], company='CSSTACK

 */