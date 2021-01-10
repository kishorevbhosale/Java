package ReflectionAPI;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

abstract class StudAbstract implements Serializable, Cloneable {
    void method() {
        System.out.println("demo");
    }
}

class StudentConc {
    public String name;
    public int age;

    public StudentConc(String name, int i) {
        this.name = name;
        age = i;
    }

    public void show() {
        System.out.println(name + " : " + age);
    }
}


public class ClassMetadataTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("ReflectionAPI.StudAbstract");

        System.out.println("Name of class : " + c.getName());
        System.out.println("Superclass name : " + c.getSuperclass().getName());
        Class[] interf = c.getInterfaces();
        for (Class cls : interf) {
            System.out.println("Interfaces : " + cls.getName() + " ");
        }
        int i = c.getModifiers();
        System.out.println("Access modifiers : " + Modifier.toString(i));
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println("Methods : " + method);
        }
        System.out.println("-------------------");

        Class s = Class.forName("ReflectionAPI.StudentConc");
        Method[] sMethods = s.getMethods();
        for (Method method : sMethods) {
            System.out.println("Student Methods : " + method);
        }
        Constructor[] cons = s.getConstructors();
        for (Constructor con : cons) {
            System.out.println("Student Constructor : " + con);
        }
        Field[] fields = s.getFields();
        for (Field field : fields) {
            System.out.println("Student Fields : Field : " + field.getName() + " Data type : " + field.getType());
        }
        System.out.println();
    }
}

/*
Name of class : ReflectionAPI.StudAbstract
Superclass name : java.lang.Object
Interfaces : java.io.Serializable
Interfaces : java.lang.Cloneable
Access modifiers : abstract
Methods : public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
Methods : public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
Methods : public final void java.lang.Object.wait() throws java.lang.InterruptedException
Methods : public boolean java.lang.Object.equals(java.lang.Object)
Methods : public java.lang.String java.lang.Object.toString()
Methods : public native int java.lang.Object.hashCode()
Methods : public final native java.lang.Class java.lang.Object.getClass()
Methods : public final native void java.lang.Object.notify()
Methods : public final native void java.lang.Object.notifyAll()
-------------------
Student Methods : public void ReflectionAPI.StudentConc.show()
Student Methods : public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
Student Methods : public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
Student Methods : public final void java.lang.Object.wait() throws java.lang.InterruptedException
Student Methods : public boolean java.lang.Object.equals(java.lang.Object)
Student Methods : public java.lang.String java.lang.Object.toString()
Student Methods : public native int java.lang.Object.hashCode()
Student Methods : public final native java.lang.Class java.lang.Object.getClass()
Student Methods : public final native void java.lang.Object.notify()
Student Methods : public final native void java.lang.Object.notifyAll()
Student Constructor : public ReflectionAPI.StudentConc(java.lang.String,int)
Student Fields : Field : name Data type : class java.lang.String
Student Fields : Field : age Data type : int
 */