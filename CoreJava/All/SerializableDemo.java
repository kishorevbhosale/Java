package oops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test1  implements Serializable{
    int mark;
    String name;
    transient int a;
    static int b;


    public Test1(int mark, String name,int a, int b) {
        this.mark = mark;
        this.name = name;
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return name+" : "+mark +" : "+a+" : "+b;
    }
}
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Test1 test1 = new Test1(35,"abc",2, 1000);

        //Serilizing object
        try(FileOutputStream outputStream = new FileOutputStream("abc.txt");
            ObjectOutputStream stream = new ObjectOutputStream(outputStream)) {
            stream.writeObject(test1);
            test1.b=2000;
        }



        //Deserilizing object
        FileInputStream inputStream = new FileInputStream("abc.txt");
        ObjectInputStream stream1 = new ObjectInputStream(inputStream);
        Test1 test2 = (Test1) stream1.readObject();

        System.out.println(test1);
        System.out.println(test2);
    }
}

/*

Points to remember
1. If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true.
2. Only non-static data members are saved via Serialization process.
3. Static data members and transient data members are not saved via Serialization process.So, if you don’t want to save value of a non-static data member then make it transient.
4. Constructor of object is never called when an object is deserialized.
5. Associated objects must be implementing Serializable interface.

output -
abc : 35 : 2 : 2000
abc : 35 : 0 : 2000
*/
