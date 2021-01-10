package oops;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Employee implements Externalizable {

    private static String department;
    private String firstName;
    private transient String lastName;
    private int age;

    public Employee() {
    }


    public Employee(String firstName, String lastName, int age, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        Employee.department = department;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Custom externalizable serialization logic invoked.");
        out.writeUTF(firstName);
        out.writeUTF(lastName);
        out.writeInt(age);
        out.writeUTF(department);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Custom externalizable de-serialization logic invoked.");
        firstName = in.readUTF();
        lastName = in.readUTF();
        age = in.readInt();
        department = in.readUTF();
    }

    @Override
    public String toString() {
        return String.format("Employee {firstName='%s', lastName='%s', age='%s', department='%s'}", firstName, lastName, age, department);
    }

}

public class ExternalizableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee employee = new Employee("Sonali", "Bhosale", 27, "IT");
        try (FileOutputStream outputStream = new FileOutputStream("abc.txt");
             ObjectOutputStream stream = new ObjectOutputStream(outputStream)) {
            stream.writeObject(employee);
        }

        FileInputStream inputStream = new FileInputStream("abc.txt");
        ObjectInputStream stream1 = new ObjectInputStream(inputStream);
        Employee test2 = (Employee) stream1.readObject();

        System.out.println(employee);
        System.out.println(test2);
    }
}


/*
Custom externalizable serialization logic invoked.
Custom externalizable serialization logic invoked.
Employee {firstName='Sonali', lastName='Bhosale', age='27', department='IT'}
Employee {firstName='Sonali', lastName='Bhosale', age='27', department='IT'}
 */