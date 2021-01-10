package oops;

import java.lang.Cloneable;

class DemoTest implements Cloneable {
    String name;
    int mark;
    DemoTest(String name,int mark){
        this.name = name;
        this.mark = mark;
    }
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
    @Override
    public String toString(){
        return name+" : "+mark;
    }
}
public class ClonableInterfaceDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        DemoTest d1 = new DemoTest("abc",30);
        DemoTest d2 = (DemoTest) d1.clone();
        System.out.println(d1);
        System.out.println(d2);
    }
}

/*
output -
abc : 30
abc : 30
*/
