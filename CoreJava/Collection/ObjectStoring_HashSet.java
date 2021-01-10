package CoreJava.Collection;

import lombok.Data;

import java.util.HashSet;

@Data
class Student {
    public static int counter = 0;
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        counter++;
    }
}

public class ObjectStoring_HashSet {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Sonali");
        Student s2 = new Student(1, "Sonali");
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(s1);
        hashSet.add(s2);

        System.out.println(hashSet);
        System.out.println(Student.counter);
    }
}
