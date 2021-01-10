package CoreJava.Collection;

import java.util.HashMap;


public class ObjectStoring_HashMap {
    public static void main(String[] args) {
        Student s = new Student(1, "sb");
        Student s1 = new Student(1, "sb");
        HashMap<Student, Integer> hashMap = new HashMap<>();
        hashMap.put(s, 1234);
        hashMap.put(s1, 1234);
        System.out.println(hashMap);
        System.out.println(hashMap.get(s));

        System.out.println(Student.counter);
    }

}
