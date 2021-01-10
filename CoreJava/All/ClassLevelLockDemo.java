package mt;

class Display{
    public  synchronized void displayn(String name){
        for (int i = 0; i < 5; i++) {
            System.out.println("I am displayn of "+name+" : "+i);
        }
    }

    public synchronized void displayc(String name){
        for (int i = 10; i < 15; i++) {
            System.out.println("I am displayc of "+name+" : "+i);
        }
    }

    public void nonSync(String name){
        for (int i = 20; i < 25; i++) {
            System.out.println("I am non sync of "+name+" : "+i);
        }

    }
}

class Mythread1 extends Thread{

    Display display;
    String name;

    Mythread1(Display display,String name){
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {
        display.nonSync(name);
        display.displayn(name);
    }
}

class Mythread2 extends Thread{

    Display display;
    String name;

    Mythread2(Display display,String name){
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {
        display.nonSync(name);
        display.displayc(name);
    }
}


public class ClassLevelLockDemo {
    public static void main(String[] args) {
        /*Display display1 = new Display();
        Display display2 = new Display();*/
        Display display = new Display();
        Mythread1 mythread1 = new Mythread1(display,"thread1");
        Mythread2 mythread2 = new Mythread2(display,"thread2");
        mythread1.start();
        mythread2.start();
    }
}

/*

NonSync method from class display executes without order
But for sync method there is class level lock though we created two thread objects
        I am non sync of thread1 : 20
        I am non sync of thread2 : 20
        I am non sync of thread1 : 21
        I am non sync of thread2 : 21
        I am non sync of thread1 : 22
        I am non sync of thread2 : 22
        I am non sync of thread1 : 23
        I am non sync of thread2 : 23
        I am non sync of thread1 : 24
        I am non sync of thread2 : 24
        I am displayn of thread1 : 0
        I am displayn of thread1 : 1
        I am displayn of thread1 : 2
        I am displayn of thread1 : 3
        I am displayn of thread1 : 4
        I am displayc of thread2 : 10
        I am displayc of thread2 : 11
        I am displayc of thread2 : 12
        I am displayc of thread2 : 13
        I am displayc of thread2 : 14
*/

