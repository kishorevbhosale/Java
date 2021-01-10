package CoreJava.ExceptionHandling;

/**
 * Throws handover exception to parent class
 * If exception is not handled by Main class then JVM - default exception handler take care of it
 */
public class ThrowsDemo {
    public static void main(String[] args) throws InterruptedException {
        doMoreStuff();
    }

    public static void doMoreStuff() throws InterruptedException {
        doStuff();
    }

    public static void doStuff() throws InterruptedException {
        Thread.sleep(1000);
    }
}
