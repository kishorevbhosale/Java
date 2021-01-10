package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stud implements Comparable<Stud> {
    String name;
    Integer rollNo;
    Integer marks;

    public Stud(String name, Integer rollNo, Integer marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "\n name = " + name + "\trollNo = " + rollNo + "\tmarks = " + marks;
    }

    @Override
    public int compareTo(Stud o) {
        //return o.name.compareTo(this.name) + o.rollNo.compareTo(this.rollNo) + o.marks.compareTo(this.marks);
        return this.name.compareTo(o.name)+ this.rollNo.compareTo(o.rollNo);
    }
}

public class SortBasedOnMultipleVal {
    public static void main(String[] args) {
        Stud stud = new Stud("aa", 31, 77);
        Stud stud1 = new Stud("xy", 23, 82);
        Stud stud2 = new Stud("pq", 2, 82);
        Stud stud3 = new Stud("pq", 43, 92);
        List<Stud> studList = new ArrayList<>();
        studList.add(stud);
        studList.add(stud1);
        studList.add(stud2);
        studList.add(stud3);
        Collections.sort(studList);
        System.out.println(studList);
    }
}

/*
output : 
       [name = aa	rollNo = 31	marks = 77,
        name = pq	rollNo = 2	marks = 82,
        name = pq	rollNo = 43	marks = 92,
        name = xy	rollNo = 23	marks = 82]
*/
